package scheduling;

import employees.Employee;
import tasks.ScheduledTask;
import tasks.Task;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Scheduler {
	private ArrayList<Task> tasks;
	private ArrayList<Employee> employees;
	private Map<Employee, ArrayList<ScheduledTask>> employeeScheduledTasks;

	public Scheduler(ArrayList<Task> tasks, ArrayList<Employee> employees) {
		this.tasks = tasks;
		this.employees = employees;
		this.employeeScheduledTasks = new HashMap<>();
	}

    public ScheduledTask getTaskById(int taskId) {
        for (ArrayList<ScheduledTask> scheduledTasks : employeeScheduledTasks.values()) {
            for (ScheduledTask scheduledTask : scheduledTasks) {
                if (scheduledTask.getTaskID() == taskId) {
                    return scheduledTask;
                }
            }
        }
        return null;
    }

	public void allocateTaskToEmployee(Task task, Employee employee, int startTime, int endTime) {
		ScheduledTask scheduledTask = new ScheduledTask(task, startTime, endTime);

		if (!employeeScheduledTasks.containsKey(employee)) {
			employeeScheduledTasks.put(employee, new ArrayList<>());
		}

		employeeScheduledTasks.get(employee).add(scheduledTask);

		// remove from dependencies of other tasks
    	for (Task t : tasks) {
        	if(t.getTaskDependencies() != 0) {
				t.setTaskDependencies(0);
			}
    	}

        int taskDuration = endTime - startTime;
        employee.fillHours(taskDuration);
	}

	public void generateOutputScheduleFile(String outputFilePath) {
		try (FileWriter writer = new FileWriter(outputFilePath)) {
			writer.write("Task ID,Task Name,Employee Assigned,Start Time,End Time\n");
			for (Employee employee : employees) {
				if (employeeScheduledTasks.containsKey(employee)) {
					for (ScheduledTask scheduledTask : employeeScheduledTasks.get(employee)) {
						writer.write(String.format("%d,%s,%s,%d,%d\n", scheduledTask.getTaskID(), scheduledTask.getTaskName(), employee.getEmployeeName(), scheduledTask.getStartTime(), scheduledTask.getEndTime()));
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<ScheduledTask> getEmployeeTasks(Employee employee) {
		return employeeScheduledTasks.getOrDefault(employee, new ArrayList<>());
	}

	public ScheduledTask getTaskSchedule(Task task) {
		for (ArrayList<ScheduledTask> scheduledTasks : employeeScheduledTasks.values()) {
			for (ScheduledTask scheduledTask : scheduledTasks) {
				if (scheduledTask.getTaskID() == task.getTaskID()) {
					return scheduledTask;
				}
			}
		}
		return null;
	}

	public ArrayList<Task> getUnscheduledTasks() {
		ArrayList<Task> unscheduledTasks = new ArrayList<>(tasks);
		for (ArrayList<ScheduledTask> scheduledTasks : employeeScheduledTasks.values()) {
			for (ScheduledTask scheduledTask : scheduledTasks) {
				unscheduledTasks.removeIf(task -> task.getTaskID() == scheduledTask.getTaskID());
			}
		}
		return unscheduledTasks;
	}

    public Employee findFirstAvailableEmployeeForJobType(String jobType) {
        Employee firstAvailableEmployee = null;
        int minFreeDay = Integer.MAX_VALUE;
        int maxFreeHours = Integer.MIN_VALUE;

        for (Employee employee : employees) {
            if (employee.getEmployeeType().equals(jobType)) {
                if (employee.getFirstFreeDay() < minFreeDay
                        || (employee.getFirstFreeDay() == minFreeDay && employee.getFreeHoursInCurrentDay() > maxFreeHours)) {
                    firstAvailableEmployee = employee;
                    minFreeDay = employee.getFirstFreeDay();
                    maxFreeHours = employee.getFreeHoursInCurrentDay();
                }
            }
        }

        return firstAvailableEmployee;
    }
}


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

	public void allocateTaskToEmployee(Task task, Employee employee, int startTime, int endTime) {
		ScheduledTask scheduledTask = new ScheduledTask(task, startTime, endTime);

		if (!employeeScheduledTasks.containsKey(employee)) {
			employeeScheduledTasks.put(employee, new ArrayList<>());
		}

		employeeScheduledTasks.get(employee).add(scheduledTask);
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

	public ArrayList<Task> getUnscheduledTasks(ArrayList<Task> tasks) {
		ArrayList<Task> unscheduledTasks = new ArrayList<>(tasks);
		for (ArrayList<ScheduledTask> scheduledTasks : employeeScheduledTasks.values()) {
			for (ScheduledTask scheduledTask : scheduledTasks) {
				unscheduledTasks.removeIf(task -> task.getTaskID() == scheduledTask.getTaskID());
			}
		}
		return unscheduledTasks;
	}
}


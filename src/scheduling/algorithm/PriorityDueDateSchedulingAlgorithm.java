package scheduling.algorithm;

import employees.Employee;
import tasks.Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PriorityDueDateSchedulingAlgorithm implements SchedulingAlgorithm {
	private Scheduler scheduler;

	public PriorityDueDateSchedulingAlgorithm(Scheduler scheduler) {
		this.scheduler = scheduler;
	}

	@Override
	public void applyAlgorithm() {
		ArrayList<Task> unscheduledTasks = scheduler.getUnscheduledTasks(scheduler.getTasks());

		// Sort unscheduled tasks by importance (Priority / Due Date) in descending order
		Collections.sort(unscheduledTasks, new Comparator<Task>() {
			@Override
			public int compare(Task task1, Task task2) {
				double importance1 = (double) task1.getPriorityLevel() / task1.getDueDate();
				double importance2 = (double) task2.getPriorityLevel() / task2.getDueDate();
				return Double.compare(importance2, importance1);
			}
		});

		for (Task task : unscheduledTasks) {
			if (task.getTaskDependencies().isEmpty()) {
				// Find the first available employee for the job type
				Employee employee = scheduler.findFirstAvailableEmployeeForJobType(task.getEmployeeType());

				if (employee != null) {
					// Allocate the task to the employee with the highest importance
					scheduler.allocateTaskToEmployee(task, employee, employee.getFirstFreeDay(, task.getProductionTime());
				}
			}
		}
	}
}


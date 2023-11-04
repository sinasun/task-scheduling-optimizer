package testing;

import static org.junit.Assert.*;
import org.junit.Test;
import tasks.Task;
import employees.Employee;
import scheduling.Scheduler;
import scheduling.ScheduledTask;

public class TestScheduler {

    @Test
    public void testAllocateTaskToEmployee() {
        Scheduler scheduler = new Scheduler(new ArrayList<>(), new ArrayList<>());
        Task task = new Task(1, "Task 1", "Type A", 4, 0, "High", "2023-11-15");
        Employee employee = new Employee(1, "John Doe", "Type A", 8, 0);

        scheduler.allocateTaskToEmployee(task, employee, 0, 4);

        ArrayList<ScheduledTask> employeeTasks = scheduler.getEmployeeTasks(employee);
        assertEquals(1, employeeTasks.size());
        assertEquals(task.getTaskID(), employeeTasks.get(0).getTaskID());
    }

    @Test
    public void testGenerateOutputScheduleFile() {
        Scheduler scheduler = new Scheduler(new ArrayList<>(), new ArrayList<>());
        Task task = new Task(1, "Task 1", "Type A", 4, 0, "High", "2023-11-15");
        Employee employee = new Employee(1, "John Doe", "Type A", 8, 0);

        scheduler.allocateTaskToEmployee(task, employee, 0, 4);

        scheduler.generateOutputScheduleFile("output_schedule.csv");

        File file = new File("output_schedule.csv");
        assertTrue(file.exists());
    }

    @Test
    public void testGetUnscheduledTasks() {
        Scheduler scheduler = new Scheduler(new ArrayList<>(), new ArrayList<>());
        Task task1 = new Task(1, "Task 1", "Type A", 4, 0, "High", "2023-11-15");
        Task task2 = new Task(2, "Task 2", "Type B", 4, 0, "Medium", "2023-11-16");
        Employee employee = new Employee(1, "John Doe", "Type A", 8, 0);

        scheduler.allocateTaskToEmployee(task1, employee, 0, 4);

        ArrayList<Task> unscheduledTasks = scheduler.getUnscheduledTasks();

        assertEquals(1, unscheduledTasks.size());
        assertEquals(task2.getTaskID(), unscheduledTasks.get(0).getTaskID());
    }

    @Test
    public void testFindFirstAvailableEmployeeForJobType() {
        Scheduler scheduler = new Scheduler(new ArrayList<>(), new ArrayList<>());
        Task task = new Task(1, "Task 1", "Type A", 4, 0, "High", "2023-11-15");
        Employee employee1 = new Employee(1, "John Doe", "Type A", 8, 0);
        Employee employee2 = new Employee(2, "Jane Smith", "Type A", 8, 0);

        scheduler.allocateTaskToEmployee(task, employee1, 0, 4);

        Employee availableEmployee = scheduler.findFirstAvailableEmployeeForJobType("Type A");

        assertEquals(employee2.getEmployeeID(), availableEmployee.getEmployeeID());
    }
}

package testing;

import static org.junit.Assert.*;
import org.junit.Test;
import tasks.Task;

public class TestTask {

    @Test
    public void testTaskCreation() {
        Task task = new Task(1, "Task 1", "Type A", 4, 2, 3, 15);

        assertEquals(1, task.getTaskID());
        assertEquals("Task 1", task.getTaskName());
        assertEquals("Type A", task.getEmployeeType());
        assertEquals(4, task.getProductionTime());
        assertEquals(2, task.getTaskDependencies());
        assertEquals(3, task.getPriorityLevel());
        assertEquals(15, task.getDueDate());
    }
}

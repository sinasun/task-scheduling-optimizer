package testing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import employees.Employee;

public class TestEmployee {
    @Test
    public void testEmployeeCreation() {
        Employee employee = new Employee(1, "John Doe", "Engineer", 8, 0);

        assertEquals(1, employee.getEmployeeID());
        assertEquals("John Doe", employee.getEmployeeName());
        assertEquals("Engineer", employee.getEmployeeType());
        assertEquals(8, employee.getHoursPerDay());
		assertEquals(0, employee.getFirstFreeDay());
    }
}

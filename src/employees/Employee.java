package employees;

public class Employee {
    private int employeeID;
    private String employeeName;
    private String employeeType;
    private int hoursPerDay;
    private int firstFreeDay;
    private int freeHoursInCurrentDay;

    public Employee(int employeeID, String employeeName, String employeeType, int hoursPerDay, int firstFreeDay, int freeHoursInCurrentDay) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.employeeType = employeeType;
        this.hoursPerDay = hoursPerDay;
        this.firstFreeDay = firstFreeDay;
        this.freeHoursInCurrentDay = freeHoursInCurrentDay;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public int getHoursPerDay() {
        return hoursPerDay;
    }

    public int getFirstFreeDay() {
        return firstFreeDay;
    }

    public int getFreeHoursInCurrentDay() {
        return getFreeHoursInCurrentDay;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public void setHoursPerDay(int hoursPerDay) {
        this.hoursPerDay = hoursPerDay;
    }

    public void fillHours(int hours) {
        while (hours > 0) {
			if (freeHoursInCurrentDay > hours) {
				freeHoursInCurrentDay =- hours;
				hours = 0;
			} else {
				hours =- freeHoursInCurrentDay;
				freeHoursInCurrentDay = hoursPerDay;
				firstFreeDay++;
			}

        }
    }
}

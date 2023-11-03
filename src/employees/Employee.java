package employees;

public class Employee {
    private int employeeID;
    private String employeeName;
    private String employeeType;
    private int hoursPerDay;

    public Employee(int employeeID, String employeeName, String employeeType, int hoursPerDay) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.employeeType = employeeType;
        this.hoursPerDay = hoursPerDay;
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
}

package tasks;

public class Task {
    private int taskID;
    private String taskName;
    private String employeeType;
    private int productionTime;
    private int taskDependencies;
    private int priorityLevel;
    private int dueDate;

    public Task(int taskID, String taskName, String employeeType, int productionTime, int taskDependencies, int priorityLevel, int dueDate) {
        this.taskID = taskID;
        this.taskName = taskName;
        this.employeeType = employeeType;
        this.productionTime = productionTime;
        this.taskDependencies = taskDependencies;
        this.priorityLevel = priorityLevel;
        this.dueDate = dueDate;
    }

    public int getTaskID() {
        return taskID;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public int getProductionTime() {
        return productionTime;
    }

    public int getTaskDependencies() {
        return taskDependencies;
    }

    public int getPriorityLevel() {
        return priorityLevel;
    }

    public int getDueDate() {
        return dueDate;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public void setProductionTime(int productionTime) {
        this.productionTime = productionTime;
    }

    public void setTaskDependencies(int taskDependencies) {
        this.taskDependencies = taskDependencies;
    }

    public void setPriorityLevel(int priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public void setDueDate(int dueDate) {
        this.dueDate = dueDate;
    }
}

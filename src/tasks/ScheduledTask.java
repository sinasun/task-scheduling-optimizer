package tasks;

public class ScheduledTask extends Task {
    private int startTime;
    private int endTime;

    public ScheduledTask(Task task, int startTime, int endTime) {
        super(task.getTaskID(), task.getTaskName(), task.getEmployeeType(), task.getProductionTime(), task.getTaskDependencies(), task.getPriorityLevel(), task.getDueDate());
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }
}

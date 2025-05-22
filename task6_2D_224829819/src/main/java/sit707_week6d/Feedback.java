package sit707_week6d;

public class Feedback {
    private String taskId;
    private String feedbackContent;

    public Feedback(String taskId, String feedbackContent) {
        this.taskId = taskId;
        this.feedbackContent = feedbackContent;
    }

    public String getTaskId() { return taskId; }
    public String getFeedbackContent() { return feedbackContent; }
}

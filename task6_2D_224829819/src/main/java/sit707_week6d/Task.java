package sit707_week6d;

import java.time.LocalDateTime;

public class Task {
    private String taskId;
    private String studentId;
    private String content;
    private LocalDateTime timestamp;

    public Task(String taskId, String studentId, String content) {
        this.taskId = taskId;
        this.studentId = studentId;
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }

    public String getTaskId() {
        return taskId;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}

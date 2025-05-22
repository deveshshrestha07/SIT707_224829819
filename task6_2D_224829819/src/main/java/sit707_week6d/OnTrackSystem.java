package sit707_week6d;

import java.util.*;

public class OnTrackSystem {
    private Map<String, List<Task>> studentTasks = new HashMap<>();
    private Map<String, Task> taskMap = new HashMap<>();
    private Map<String, List<Message>> messageMap = new HashMap<>();
    private Map<String, Feedback> feedbackMap = new HashMap<>();

    public String submitTask(String studentId, String content) {
        if (content == null || content.trim().isEmpty())
            return "Task content cannot be empty.";

        String taskId = UUID.randomUUID().toString();
        Task task = new Task(taskId, studentId, content);

        studentTasks.computeIfAbsent(studentId, k -> new ArrayList<>()).add(task);
        taskMap.put(taskId, task);

        return "Task submitted with ID: " + taskId;
    }

    public List<Task> getTaskInbox(String studentId) {
        return studentTasks.getOrDefault(studentId, new ArrayList<>());
    }

    public Task viewTask(String taskId) {
        return taskMap.get(taskId);
    }

    public String getFeedback(String taskId) {
        Feedback fb = feedbackMap.get(taskId);
        return (fb != null) ? fb.getFeedbackContent() : "No feedback available.";
    }

    public String sendMessage(String senderId, String receiverId, String messageContent, String taskId) {
        if (messageContent == null || messageContent.trim().isEmpty())
            return "Message cannot be empty.";

        Message message = new Message(senderId, receiverId, messageContent);
        messageMap.computeIfAbsent(taskId, k -> new ArrayList<>()).add(message);
        return "Message sent.";
    }

    public List<Message> getChatMessages(String taskId) {
        return messageMap.getOrDefault(taskId, new ArrayList<>());
    }

    public void addFeedback(String taskId, String content) {
        feedbackMap.put(taskId, new Feedback(taskId, content));
    }
}

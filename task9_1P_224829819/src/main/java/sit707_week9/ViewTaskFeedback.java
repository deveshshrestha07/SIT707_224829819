package sit707_week9;


import java.util.*;

public class ViewTaskFeedback {

    public static class FeedbackResult {
        private String feedback;
        private List<String> chatHistory;

        public FeedbackResult(String feedback, List<String> chatHistory) {
            this.feedback = feedback;
            this.chatHistory = chatHistory;
        }

        public String getFeedback() {
            return feedback;
        }

        public List<String> getChatHistory() {
            return chatHistory;
        }
    }

public FeedbackResult getTaskFeedback(String studentId, String taskId) {
    if (studentId == null || taskId == null) {
        return new FeedbackResult("No feedback available.", Collections.emptyList());
    }

    if (studentId.equals("student123") && taskId.equals("task456")) {
        String feedback = "Great work!";
        List<String> chat = Arrays.asList(
            "Tutor: Please check your code formatting.",
            "Student: Sure, I’ll fix that."
        );
        return new FeedbackResult(feedback, chat);
    } else {
        return new FeedbackResult("No feedback available.", Collections.emptyList());
    }
}
}

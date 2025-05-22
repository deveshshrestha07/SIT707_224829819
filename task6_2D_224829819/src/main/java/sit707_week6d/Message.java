package sit707_week6d;

import java.time.LocalDateTime;

public class Message {
    private String senderId;
    private String receiverId;
    private String message;
    private LocalDateTime timestamp;

    public Message(String senderId, String receiverId, String message) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public String getSenderId() { return senderId; }
    public String getReceiverId() { return receiverId; }
    public String getMessage() { return message; }
    public LocalDateTime getTimestamp() { return timestamp; }
}

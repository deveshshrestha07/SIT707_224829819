package sit707_week6d;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OnTrackSystemTest {

    private OnTrackSystem system;
    private String studentId;

    @BeforeEach
    public void setUp() {
        system = new OnTrackSystem();
        studentId = "student001";
    }

    @Test
    public void testSubmitTask_Right() {
        String result = system.submitTask(studentId, "Finish SIT707 Week 6D");
        assertTrue(result.contains("Task submitted with ID"));
    }

    @Test
    public void testSubmitTask_Boundary_EmptyContent() {
        String result = system.submitTask(studentId, "  ");
        assertEquals("Task content cannot be empty.", result);
    }

    @Test
    public void testGetTaskInbox_Right() {
        system.submitTask(studentId, "Task A");
        List<Task> inbox = system.getTaskInbox(studentId);
        assertEquals(1, inbox.size());
    }

    @Test
    public void testViewTask_Inverse() {
        String result = system.submitTask(studentId, "Task B");
        String taskId = extractTaskId(result);
        Task retrieved = system.viewTask(taskId);
        assertEquals("Task B", retrieved.getContent());
    }

    @Test
    public void testGetFeedback_CrossCheck() {
        String taskId = extractTaskId(system.submitTask(studentId, "Task C"));
        system.addFeedback(taskId, "Great job!");
        assertEquals("Great job!", system.getFeedback(taskId));
    }

    @Test
    public void testSendMessage_Error_EmptyContent() {
        String taskId = extractTaskId(system.submitTask(studentId, "Task D"));
        String result = system.sendMessage(studentId, "tutor001", " ", taskId);
        assertEquals("Message cannot be empty.", result);
    }

    @Test
    public void testSendMessage_Performance() {
        String taskId = extractTaskId(system.submitTask(studentId, "Task E"));
        long start = System.nanoTime();
        system.sendMessage(studentId, "tutor001", "Quick message", taskId);
        long end = System.nanoTime();
        assertTrue((end - start) < 1_000_000); // < 1ms
    }

    private String extractTaskId(String response) {
        return response.replace("Task submitted with ID: ", "").trim();
    }
}

package sit707_week9;


import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class ViewTaskFeedbackTest {
	
//	required tests

    @Test
    public void testValidFeedback() {
        ViewTaskFeedback service = new ViewTaskFeedback();
        ViewTaskFeedback.FeedbackResult result = service.getTaskFeedback("student123", "task456");

        assertEquals("Great work!", result.getFeedback());
        List<String> expectedChat = Arrays.asList(
            "Tutor: Please check your code formatting.",
            "Student: Sure, I’ll fix that."
        );
        assertEquals(expectedChat, result.getChatHistory());
    }

    @Test
    public void testNoFeedback() {
        ViewTaskFeedback service = new ViewTaskFeedback();
        ViewTaskFeedback.FeedbackResult result = service.getTaskFeedback("student999", "task999");

        assertEquals("No feedback available.", result.getFeedback());
        assertTrue(result.getChatHistory().isEmpty());
    }
    
    @Test
    public void testEmptyStudentId() {
        ViewTaskFeedback service = new ViewTaskFeedback();
        ViewTaskFeedback.FeedbackResult result = service.getTaskFeedback("", "task456");

        assertEquals("No feedback available.", result.getFeedback());
        assertTrue(result.getChatHistory().isEmpty());
    }
    
    @Test
    public void testNullTaskId() {
        ViewTaskFeedback service = new ViewTaskFeedback();
        ViewTaskFeedback.FeedbackResult result = service.getTaskFeedback("student123", null);

        assertEquals("No feedback available.", result.getFeedback());
        assertTrue(result.getChatHistory().isEmpty());
    }


}

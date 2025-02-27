
import org.example.AikidoPracticeTracker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AikidoPracticeTrackerTest {

    @Test
    public void testAddSession() {
        AikidoPracticeTracker tracker = new AikidoPracticeTracker();
        tracker.addSession("2023-10-01", 2);
        assertEquals(2, tracker.getTotalPracticeTime());
    }

    @Test
    public void testGetTotalPracticeTime() {
        AikidoPracticeTracker tracker = new AikidoPracticeTracker();
        tracker.addSession("2023-10-01", 2);
        tracker.addSession("2023-10-02", 3);
        assertEquals(5, tracker.getTotalPracticeTime());
    }

    @Test
    public void testIsEligibleForGraduation() {
        AikidoPracticeTracker tracker = new AikidoPracticeTracker();
        tracker.addSession("2023-10-01", 50);
        tracker.addSession("2023-10-02", 50);
        assertTrue(tracker.isEligibleForGraduation());
    }
}
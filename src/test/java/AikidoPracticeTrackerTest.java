
import org.example.AikidoPracticeTracker;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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

    @Test
    public void testIsEligibleForGraduationByMonths() {
        AikidoPracticeTracker tracker = new AikidoPracticeTracker();
        tracker.addSession("2023-01-01", 10);
        tracker.addSession("2023-02-01", 10);

        // Simulate the passage of time by setting the current date to 6 months later
        LocalDate firstSessionDate = LocalDate.parse("2023-01-01");
        LocalDate currentDate = firstSessionDate.plus(6, ChronoUnit.MONTHS);
        tracker.setCurrentDate(currentDate);

        assertTrue(tracker.isEligibleForGraduation());

    }
}
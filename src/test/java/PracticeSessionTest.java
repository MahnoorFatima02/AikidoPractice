import org.example.PracticeSession;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PracticeSessionTest {

    @Test
    public void testGetDate() {
        PracticeSession session = new PracticeSession("2023-10-01", 2);
        assertEquals("2023-10-01", session.getDate());
    }
}
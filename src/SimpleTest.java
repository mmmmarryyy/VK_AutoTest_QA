import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimpleTest {
    @Test
    public void testIsTrue() {
        SimpleMain repository = new SimpleMain();
        boolean result = repository.isTrue();
        Assertions.assertTrue(result);
    }

}

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UserTest {
    private User u1;
    private User u2;

    @Before
    public void setUp() {
        u1 = new User();
        u2 = new User();
    }

    @Test
    public void testEquals() {
        assertEquals(true, u1.equals(u2));
    }

    @Test
    public void testNullEquals() {
        assertEquals(false, u1.equals(null));
    }

    @Test
    public void testHashcode() {
        assertEquals(31, u1.hashCode());
    }

}

package test.java;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.java.User;

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
        assertTrue(u1.equals(u2) && u1.equals(u2));
    }

    @Test
    public void testHashcode() {
        assertTrue(u1.hashCode() == u2.hashCode());
    }

}

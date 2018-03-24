package test.java;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import main.java.Issue;
import main.java.User;

public class IssueTest {

    private Issue i1;
    private Issue i2;
    private User u1;
    private User u2;

    @Before
    public void setUp() {
        i1 = new Issue();
        i2 = new Issue();
        u1 = new User();
        u2 = new User();
    }

    @Test
    public void testEquals() {
        System.out.println(i1.hashCode() + ":::::" + i2.hashCode());
        System.out.println(i1.equals(i2));
        assertTrue(i1.equals(i2) && i1.equals(i2));
        assertTrue(u1.equals(u2) && u1.equals(u2));
    }

    @Test
    public void testHashcode() {
        assertTrue(i1.hashCode() == i2.hashCode());
        assertTrue(u1.hashCode() == u2.hashCode());
    }

    @Test
    public void testToString() {
        i1.setNumber(1);
        i1.setId(7067839);
        i1.setState("open");
        i1.setTitle("# Issue 1");
        i1.setBody("This is Issue 1");
        System.out.println(i1.toString());
        String str = "Issue [number=1, id=7067839, state=open, title=# Issue 1, body=This is Issue 1, createdAt=null, closedAt=null, user=null, assignee=null]";
        assertEquals(str, i1.toString());

    }

    @Test
    public void testCompareEq() {
        i1.setId(5);
        i2.setId(5);
        assertEquals(0, i1.compareTo(i2));
    }

    @Test
    public void testCompareGreater() {
        i1.setId(5);
        i2.setId(10);
        assertEquals(1, i1.compareTo(i2));
    }

    @Test
    public void testCompareLess() {
        i1.setId(10);
        i2.setId(5);
        assertEquals(-1, i1.compareTo(i2));
    }

}

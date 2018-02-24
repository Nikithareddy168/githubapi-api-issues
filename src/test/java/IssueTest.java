package test.java;

import static org.junit.Assert.*;

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
         // System.out.println(i1.hashCode()+":::::"+i2.hashCode());
        //  System.out.println(i1.equals(i2));
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
            String toString = i1.toString();
         
            //assertTrue(toString.contains("Number=" + state));
        
    }
    

}

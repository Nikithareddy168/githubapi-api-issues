package test.java;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.Issue;

public class IssueTest {

    @Test
    public void testEqualsAndHashcode() {
        Issue aObject = new Issue();
        Issue bObject = new Issue();
       System.out.println(aObject.hashCode()+":::::"+bObject.hashCode());
       System.out.println(aObject.equals(bObject));
        
        
        assertTrue(aObject.equals(bObject) && bObject.equals(aObject));
        assertTrue(aObject.hashCode() == bObject.hashCode());
    }
    
    

}

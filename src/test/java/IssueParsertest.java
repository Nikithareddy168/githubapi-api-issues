package test.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.java.Issue;
import main.java.IssueParser;

public class IssueParsertest {
    String key = "";

    @Before
    public void setUp() throws IOException {
        {
            FileReader file = new FileReader("sample-output.txt");
            BufferedReader reader = new BufferedReader(file);
            String line = null;
            try {
                line = reader.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }

            while (line != null) {
                key += "\n" + line;
                line = reader.readLine();
            }
        }
    }

    @Test
    public void collectionSizetest() throws IOException {
        IssueParser isp = new IssueParser();
        List<Issue> ls1 = new ArrayList<Issue>();
        ls1 = isp.parseIssues(key);
        System.out.println(ls1);
        assertEquals(3, ls1.size());
    }

    @Test
    public void issuePropertiesTest() throws IOException {
        IssueParser isp = new IssueParser();
        List<Issue> ls1 = new ArrayList<Issue>();
        ls1 = isp.parseIssues(key);
        for (int i = 0; i < ls1.size(); i++) {
            Issue aName = ls1.get(i);
            assertNull(aName.getClosedAt());
            assertEquals("open", aName.getState());
        }

    }

}

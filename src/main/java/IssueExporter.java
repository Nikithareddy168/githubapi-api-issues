package main.java;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class IssueExporter {

    public static void main(String[] args) {
         IssueExporter writeToFile = new IssueExporter();
         Scanner scanner = new Scanner(System.in);
         System.out.println("Enter  username : ");
         String userName = scanner.next();
         System.out.println("Enter  password : ");
         String password = scanner.next();
         Issue issue1 = new Issue();
         Issue issue2 = new Issue();
         Issue issue3 = new Issue();
         User user = new User();

         User assignee = new User();
         user.setLogin("Nikithareddy168");
         assignee.setLogin("ms-o");
         List<Issue> issuesList = new ArrayList<>();
        // System.out.println(issuesList.size());
         issue1.setNumber(1);
         issue1.setId(7067839);
        
         issue1.setUser(user);
         issue1.setAssignee(assignee);
         issue1.setId(7067839);
         issue1.setState("open");
         issue1.setTitle("# Issue 1");
         issue1.setBody("This is Issue 1");
        // issue1.setUser1("NikithaReddy168");
         issue1.setCreatedAt(new Date());
         issue1.setClosedAt(new Date());
         issuesList.add(issue1);
         
         
         issue2.setNumber(2);
         issue2.setId(7067839);
         issue2.setUser(user);
         issue2.setAssignee(assignee);
         issue2.setState("closed");
         issue2.setTitle("# Issue 2");
         issue2.setBody("This is Issue 2");
         issue2.setCreatedAt(new Date());
         issue2.setClosedAt(new Date());
         
         issuesList.add(issue2);
         issue3.setNumber(3);
         issue3.setId(7067839);
         issue3.setUser(user);
         issue3.setAssignee(assignee);
         issue3.setState("open");
         issue3.setTitle("# Issue 3");
         issue3.setBody("This is Issue 3");
         issue3.setCreatedAt(new Date());
         issue3.setClosedAt(new Date());
         issuesList.add(issue3);
         
         System.out.println("Collection Size : "+issuesList.size());
         System.out.println(issuesList);
         
    }

}

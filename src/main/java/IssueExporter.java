package main.java;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class IssueExporter {

    public static void main(String[] args) throws IOException {
        IssueExporter writeToFile = new IssueExporter();
        writeToFile.run();
    }

    private void run() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter  username : ");
        String userName = scanner.next();
        System.out.println("Enter  password : ");
        String password = scanner.next();

        Issue issue1 = new Issue();
        Issue issue2 = new Issue();
        Issue issue3 = new Issue();
        User user1 = new User();
        user1.setLogin("Nikithareddy168");
        user1.setId(7067839);

        List<Issue> issuesList = new ArrayList<Issue>();

        issue1.setNumber(1);
        issue1.setId(7067839);
        issue1.setUser(user1);
        issue1.setAssignee(user1);
        issue1.setId(4554);
        issue1.setState("open");
        issue1.setTitle("# Issue 1");
        issue1.setBody("This is Issue 1");
        issue1.setCreatedAt(new Date());
        issue1.setClosedAt(new Date());
        issuesList.add(issue1);

        issue2.setNumber(2);
        issue2.setId(7067839);
        issue2.setUser(user1);
        issue2.setAssignee(user1);
        issue2.setState("closed");
        issue2.setTitle("# Issue 2");
        issue2.setBody("This is Issue 2");
        issue2.setCreatedAt(new Date());
        issue2.setClosedAt(new Date());
        issuesList.add(issue2);

        issue3.setNumber(3);
        issue3.setId(7067839);
        issue3.setUser(user1);
        issue3.setAssignee(user1);
        issue3.setState("open");
        issue3.setTitle("# Issue 3");
        issue3.setBody("This is Issue 3");
        issue3.setCreatedAt(new Date());
        issue3.setClosedAt(new Date());
        issuesList.add(issue3);

        System.out.println("Number of Issues : " + issuesList.size());

        File f1 = new File("d:\\issues.txt");
        if (f1.exists()) {
            f1.delete();
        }
        File f = new File("d:\\issues.txt");
        if (f.exists()) {
            f.createNewFile();
        }

        for (Issue i : issuesList) {
            FileWriter fw = new FileWriter(f, true);
            BufferedWriter bw = new BufferedWriter(fw);
            try {
                bw.append(i.toString());
                bw.newLine();

            }
            catch (IOException e) {

                e.printStackTrace();

            }
            finally {

                try {

                    if (bw != null)
                        bw.close();

                    if (fw != null)
                        fw.close();

                }
                catch (IOException ex) {

                    ex.printStackTrace();

                }

            }
        }
    }

}

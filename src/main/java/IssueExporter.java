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
        GitHubRestClient client = new GitHubRestClient();
        IssueParser closedParser = new IssueParser();
        System.out.println("Enter  username : ");
        String userName = scanner.next();
        System.out.println("Enter  password : ");
        String password = scanner.next();
        String closedJson = client.requestIssues(userName, password, "closed");
        System.out.println("closed issues size  :" + closedJson);
        List<Issue> closedIssuesList = closedParser.parseIssues(closedJson);
        System.out.println("closed issues size  :" + closedIssuesList.size());

        String openJson = client.requestIssues(userName, password, "open");
        System.out.println("open issues size  :" + openJson);
        List<Issue> openIssuesList = closedParser.parseIssues(openJson);
        System.out.println("open  issues size  :" + openIssuesList.size());
        closedIssuesList.addAll(openIssuesList);
        System.out.println(
                "==========closed issues size  :" + closedIssuesList.size());

    }

}

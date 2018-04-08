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
        // System.out.println("closed issues size :" + closedJson);
        List<Issue> closedIssues = closedParser.parseIssues(closedJson);
        // System.out.println("closed issues size :" + closedIssues.size());

        String openJson = client.requestIssues(userName, password, "open");
        System.out.println("open issues  :" + openJson);
        List<Issue> openIssues = closedParser.parseIssues(openJson);
        System.out.println("open  issues size  :" + openIssues.size());
        closedIssues.addAll(openIssues);
        // System.out.println("==========closed issues size :" +
        // closedIssues.size());
        File f1 = new File("issues.txt");
        if (f1.exists()) {
            f1.delete();
        }
        File f = new File("issues.txt");
        if (f.exists()) {
            f.createNewFile();
        }

        for (Issue i : closedIssues) {
            FileWriter fw = new FileWriter(f, true); // true is for append
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

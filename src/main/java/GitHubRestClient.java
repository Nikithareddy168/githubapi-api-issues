package main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * A quick and dirty prototype of a GET request for GitHub issues. Based on
 * Apache HttpClient sample class ClientPreemptiveBasicAuthentication.java. You
 * will obviously need to improve this messy code to properly complete Lab #4.
 * There is a main() method available for you to run this prototype. You're
 * welcome to change the code to use a different authentication approach as
 * well. Note the TODOs in the code. Be sure that httpcore & httpclient jars are
 * on the classpath.
 */
public class GitHubRestClient {

    public static void main(String[] args) {
        GitHubRestClient prototype = new GitHubRestClient();
        // IMPORTANT: don't commit your username and password to your repo!!!
        String json = prototype.requestIssues("Nikithareddy168", "Nikitha168",
                "open");
        System.out.println(json);
    }

    public String requestIssues(String username, String password,
            String state) {
        String jsonContent = null;

        HttpHost target = new HttpHost("api.github.com", 443, "https");
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(
                new AuthScope(target.getHostName(), target.getPort()),
                new UsernamePasswordCredentials(username, password));

        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCredentialsProvider(credsProvider).build();

        AuthCache authCache = new BasicAuthCache();
        BasicScheme basicAuth = new BasicScheme();
        authCache.put(target, basicAuth);

        HttpClientContext localContext = HttpClientContext.create();
        localContext.setAuthCache(authCache);

        // TODO adjust the URI to match your repo name
        String str1 = "/repos/SoftwareStudioSpring2018/githubapi-issues-Nikithareddy168/issues";
        String str2 = "?state=";
        // System.out.println(str1+str2);
        HttpGet httpget = new HttpGet(str1 + str2 + state);

        try {
            CloseableHttpResponse response = httpclient.execute(target, httpget,
                    localContext);
            System.out.println(response.getStatusLine());
            // TODO check for status 200 before proceeding

            HttpEntity entity = response.getEntity();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(entity.getContent()));

            jsonContent = reader.readLine();

            EntityUtils.consume(entity);
        }
        catch (ClientProtocolException e) {
            // TODO properly handle exception
            e.printStackTrace();
        }
        catch (IOException e) {
            // TODO properly handle exception
            e.printStackTrace();
        }
        finally {
            // TODO close all resources
           httpget.abort();
           
        }
        return jsonContent;
    }

}
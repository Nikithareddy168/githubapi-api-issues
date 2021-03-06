package main.java;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class IssueParser {

    public List<Issue> parseIssues(String str) throws IOException {

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
                .setFieldNamingPolicy(
                        FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        // Gson gson = new Gson();
        List<Issue> issues = new ArrayList<Issue>();
        Type collectionType = new TypeToken<List<Issue>>() {
        }.getType();
        issues = gson.fromJson(str, collectionType);
        return issues;
    }
}

package com.example.myplugin;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

public class ScheduleServlet extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws IOException {
    StringBuilder jsonBuffer = new StringBuilder();
    try (BufferedReader reader = req.getReader()) {
      String line;
      while ((line = reader.readLine()) != null) {
        jsonBuffer.append(line);
      }
    }

    String requestBody = jsonBuffer.toString();
    System.out.println("✅ Task Scheduler received: " + requestBody);

    // (Optional) parse JSON
    JsonObject json = JsonParser.parseString(requestBody).getAsJsonObject();
    String commitId = json.get("commitId").getAsString();
    System.out.println("Commit: " + commitId);

    resp.setContentType("text/plain");
    resp.getWriter().write("Received");
  }
}

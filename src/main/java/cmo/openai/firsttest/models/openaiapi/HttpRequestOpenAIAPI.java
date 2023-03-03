package cmo.openai.firsttest.models.openaiapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HttpRequestOpenAIAPI {
    private String url;
    private String token;

    public HttpRequestOpenAIAPI(String url, String token) {
        this.url = url;
        this.token = token;
    }

    public String get(String requestBody) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Authorization", "Bearer " + token);

        if (requestBody != null && !requestBody.isEmpty()) {
            connection.setDoOutput(true);
            byte[] postData = requestBody.getBytes();
            connection.getOutputStream().write(postData);
        }

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            in.close();
            return response.toString();
        } else {
            System.out.println("GET request failed with response code: " + responseCode);
            return null;
        }
    }

    public String post(String requestBody) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Authorization", "Bearer " + token);

        if (requestBody != null && !requestBody.isEmpty()) {
            connection.setDoOutput(true);
            byte[] postData = requestBody.getBytes();
            connection.getOutputStream().write(postData);
        }

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            in.close();
            return response.toString();
        } else {
            System.out.println("POST request failed with response code: " + responseCode);
            return null;
        }
    }

}

package cmo.openai.firsttest.models.services;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cmo.openai.firsttest.models.dto.RequestCompletionOpenAi;
import cmo.openai.firsttest.models.openaiapi.HttpRequestOpenAIAPI;

@Service
public class OpenAiCompletionService {

    private static final String URL = "https://api.openai.com/v1/completions";
    private static final String TOKEN = "";

    public String requestOpenAiApi(RequestCompletionOpenAi completionOpenAi, String method) {
        HttpRequestOpenAIAPI openAiApi = new HttpRequestOpenAIAPI(URL, TOKEN);
        String jsonRequestBody;
        String result = "";
        try {
            jsonRequestBody = new ObjectMapper().writeValueAsString(completionOpenAi);
            if (HttpMethod.GET.matches(method)) {
                result = new String(openAiApi.get(jsonRequestBody));
            } else {
                result = new String(openAiApi.post(jsonRequestBody));
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;

    }

}

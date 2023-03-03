package cmo.openai.firsttest.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class RequestCompletionOpenAi {

    private String model;
    private String prompt;
    private Float temperature;
    @JsonProperty("max_tokens")
    private Short maxTokens;
    /*
     * 
     * @JsonProperty("top_p")
     * private Short topP;
     * 
     * @JsonProperty("n")
     * private Short numberCompletions;
     * private Boolean stream;
     * private Object logprobs;
     * private String stop;
     */

}

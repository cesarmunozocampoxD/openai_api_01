package cmo.openai.firsttest.controllers;

import org.springframework.web.bind.annotation.RestController;
import cmo.openai.firsttest.models.dto.RequestCompletionOpenAi;
import cmo.openai.firsttest.models.services.OpenAiCompletionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin("*")
public class CompletionController {

    @Autowired
    OpenAiCompletionService completionService;

    @PostMapping(path = { "/v1/completions" }, produces = { "application/json" })
    public ResponseEntity<Object> postCompletions(@RequestBody RequestCompletionOpenAi request) {
        String result = completionService.requestOpenAiApi(request, "POST");

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}

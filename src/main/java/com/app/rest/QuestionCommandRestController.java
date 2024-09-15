package com.app.rest;

import com.app.domian.application.QuestionApplicationService;
import com.app.domian.application.convert.QuestionMapper;
import com.app.domian.application.command.CreateQuestionCommand;
import com.app.domian.application.command.QueryQuestionCommand;
import com.app.domian.application.result.CreateQuestionResult;
import com.app.rest.request.CreateQuestionRequest;
import com.app.rest.request.QueryQuestionRequest;
import com.app.rest.response.QuestionCreateResponse;
import com.app.rest.response.QuestionQueryResponse;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @program: Code_Style
 * @description:
 * @author: quliang
 * @create: 2022-06-16 17:17
 **/

@RestController
@RequestMapping(value = "/questions")
public class QuestionCommandRestController {

    private final QuestionApplicationService questionApplicationService;

    public QuestionCommandRestController(QuestionApplicationService questionApplicationService) {
        this.questionApplicationService = questionApplicationService;
    }

    @PostMapping("/create-question")
    public QuestionCreateResponse createQuestion(@RequestBody CreateQuestionRequest request){
        CreateQuestionCommand createQuestionCommand = new CreateQuestionCommand(
                request.getQuestionId(), request.getTitle(), request.getDetail());
        CreateQuestionResult question = questionApplicationService.createQuestion(createQuestionCommand);
        return new QuestionCreateResponse(question.getQuestionId());
    }

    @GetMapping("/query-question")
    public Page<QuestionQueryResponse> queryQuestion(QueryQuestionRequest request) {
        QueryQuestionCommand queryQuestionCommand = QuestionMapper.INSTANCE
                .convertToQueryCommand(request);
        return questionApplicationService.queryQuestion(queryQuestionCommand);
    }
}

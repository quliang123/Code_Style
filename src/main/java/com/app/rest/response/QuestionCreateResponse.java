package com.app.rest.response;

/**
 * @program: Code_Style
 * @description:
 * @author: quliang
 * @create: 2022-06-16 17:26
 **/

public class QuestionCreateResponse {
    private String questionId;

    public String getQuestionId() {
        return questionId;
    }

    public QuestionCreateResponse(String questionId) {
        this.questionId = questionId;
    }
}

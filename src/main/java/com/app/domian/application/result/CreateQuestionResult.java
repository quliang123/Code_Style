package com.app.domian.application.result;

/**
 * @program: Code_Style
 * @description:
 * @author: quliang
 * @create: 2022-06-16 17:05
 **/

public class CreateQuestionResult {
   private String questionId;

    public CreateQuestionResult(String questionId) {
        this.questionId = questionId;
    }

    public String getQuestionId() {
        return questionId;
    }
}

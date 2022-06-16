package com.app.rest.request;

/**
 * @program: Code_Style
 * @description:
 * @author: quliang
 * @create: 2022-06-16 17:21
 **/

public class CreateQuestionRequest {
    private String questionId;
    private String title;
    private String detail;

    public String getQuestionId() {
        return questionId;
    }

    public String getTitle() {
        return title;
    }

    public String getDetail() {
        return detail;
    }
}

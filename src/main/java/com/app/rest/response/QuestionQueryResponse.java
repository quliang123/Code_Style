package com.app.rest.response;

import java.io.Serializable;

/**
 * @description:
 * @author: quliang
 * @create: 2022-11-07 18:51
 **/

public class QuestionQueryResponse{
    private String questionId;
    private String title;
    private String detail;

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}

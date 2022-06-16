package com.app.domian.application.command;

/**
 * @program: Code_Style
 * @description:
 * @author: quliang
 * @create: 2022-06-16 17:04
 **/

public class CreateQuestionCommand {
    private String questionId;
    private String title;
    private String detail;

    public CreateQuestionCommand(String questionId, String title, String detail) {
        this.questionId = questionId;
        this.title = title;
        this.detail = detail;
    }

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

package com.app.domian.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @program: Code_Style
 * @description:
 * @author: quliang
 * @create: 2022-06-15 17:26
 **/
@Entity
@Table(name = "question")
@GenericGenerator(name = "question-uuid", strategy = "uuid")
public class Question {

    @Id
    @GeneratedValue(generator = "question-uuid")
    private String id;
    private String questionId;
    private String title;
    private String detail;

    protected Question() {
    }

    public Question(String questionId, String title, String detail) {
        this.questionId = questionId;
        this.title = title;
        this.detail = detail;
    }

    public String getId() {
        return id;
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

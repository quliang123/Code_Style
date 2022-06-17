package com.app.domian.model.entity;

import com.app.domian.model.vo.QuestionUpdatedRecord;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


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

    @OrderBy("updatedAt")
    @ElementCollection
    @CollectionTable(name = "question_updated_record")
    private List<QuestionUpdatedRecord> updatedRecords;

    @PersistenceConstructor
    protected Question() {
    }

    public Question(String questionId, String title, String detail) {
        this.questionId = questionId;
        this.title = title;
        this.detail = detail;
        this.updatedRecords = new ArrayList<>();
        updatedRecords.add(QuestionUpdatedRecord.ofCreated(questionId, title, detail));
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

    public List<QuestionUpdatedRecord> getUpdatedRecords() {
        return Collections.unmodifiableList(updatedRecords);
    }

    public void editTitle(String editorId,String reason, String title) {
        this.updatedRecords.add(QuestionUpdatedRecord.ofTitleEdited(editorId,
                reason, this.title, title));
        this.title = title;
    }

    public void editDetail(String editorId, String reason, String detail) {
        this.updatedRecords.add(QuestionUpdatedRecord.ofDetailEdited(editorId,
                reason, this.detail, detail));
        this.detail = detail;
    }
}

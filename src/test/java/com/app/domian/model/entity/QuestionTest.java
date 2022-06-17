package com.app.domian.model.entity;


import com.app.domian.model.vo.QuestionUpdatedRecord;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.app.domian.model.vo.QuestionUpdatedRecord.UpdateType.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

class QuestionTest {

    @Test
    void should_generate_created_record_after_question_created() {
        Question question = new Question("UID_0001", "A test title", "A test detail");
        List<QuestionUpdatedRecord> updatedRecords = question.getUpdatedRecords();
        assertThat(updatedRecords, hasSize(1));
        QuestionUpdatedRecord questionCreatedRecord = updatedRecords.get(0);
        assertThat(questionCreatedRecord.getUpdateType(), is(CREATED));
        assertThat(questionCreatedRecord.getCreatedTitle(), is(question.getTitle()));
        assertThat(questionCreatedRecord.getCreatedDetail(), is(question.getDetail()));
    }

    @Test
    void should_generate_edit_record_after_question_edited() {
        String originalTitle = "A test title";

        String originalDetail = "A test detail";
        Question question = new Question("UID_0001", originalTitle, originalDetail);
        String editedTitle = "A new test title";
        question.editTitle("UID_00002", "for Test", editedTitle);
        String editedDetail = "A new test detail";
        question.editDetail("UID_00003", "for Test", editedDetail);
        List<QuestionUpdatedRecord> updatedRecords = question.getUpdatedRecords();
        assertThat(updatedRecords, hasSize(3));
        QuestionUpdatedRecord questionCreatedRecord = updatedRecords.get(0);
        assertThat(questionCreatedRecord.getUpdateType(), is(CREATED));
        assertThat(questionCreatedRecord.getCreatedTitle(), is(originalTitle));
        assertThat(questionCreatedRecord.getCreatedDetail(), is(originalDetail));

        QuestionUpdatedRecord questionTitleEditedRecord = updatedRecords.get(1);
        assertThat(questionTitleEditedRecord.getUpdateType(), is(TITLE_EDITED));
        assertThat(questionTitleEditedRecord.getUneditedTitle(), is(originalTitle));
        assertThat(questionTitleEditedRecord.getEditedTitle(), is(editedTitle));

        QuestionUpdatedRecord questionDetailEditedRecord = updatedRecords.get(2);
        assertThat(questionDetailEditedRecord.getUpdateType(), is(DETAIL_EDITED));
        assertThat(questionDetailEditedRecord.getUneditedDetail(), is(originalDetail));
        assertThat(questionDetailEditedRecord.getEditedDetail(), is(editedDetail));

        assertThat(question.getTitle(), is(editedTitle));
        assertThat(question.getDetail(), is(editedDetail));
    }
}
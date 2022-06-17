package com.app.domian.model.vo;

import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.time.OffsetDateTime;
import java.util.Objects;

import static com.app.domian.model.vo.QuestionUpdatedRecord.UpdateType.*;

/**
 * @program: Code_Style
 * @description:
 * @author: quliang
 * @create: 2022-06-17 11:23
 **/
@Embeddable
public class QuestionUpdatedRecord {
    @Enumerated(EnumType.STRING)
    private UpdateType updateType;
    private String updateId;
    private OffsetDateTime updatedAt;
    private String reason;
    private String createdTitle;
    private String createdDetail;
    private String uneditedTitle;
    private String editedTitle;
    private String uneditedDetail;
    private String editedDetail;

    public static QuestionUpdatedRecord ofCreated(String updateId, String createdTitle,
                                                  String createdDetail) {
        return new QuestionUpdatedRecord(CREATED, updateId, OffsetDateTime.now(),
                null, createdTitle, createdDetail, null, null, null,
                null);
    }

    public static QuestionUpdatedRecord ofTitleEdited(String updateId, String reason, String uneditedTitle,
                                                      String editedTitle) {
        return new QuestionUpdatedRecord(TITLE_EDITED, updateId, OffsetDateTime.now(),
                reason, null, null, uneditedTitle, editedTitle, null,
                null);
    }

    public static QuestionUpdatedRecord ofDetailEdited(String updateId, String reason, String uneditedDetail,
                                                       String editedDetail) {
        return new QuestionUpdatedRecord(DETAIL_EDITED, updateId, OffsetDateTime.now(),
                reason, null, null, null, null, uneditedDetail,
                editedDetail);
    }

    @PersistenceConstructor
    protected QuestionUpdatedRecord() {
    }

    private QuestionUpdatedRecord(UpdateType updateType, String updateId, OffsetDateTime updatedAt, String reason,
                                  String createdTitle, String createdDetail,
                                  String uneditedTitle, String editedTitle,
                                  String uneditedDetail, String editedDetail) {
        this.updateType = updateType;
        this.updateId = updateId;
        this.updatedAt = updatedAt;
        this.reason = reason;
        this.createdTitle = createdTitle;
        this.createdDetail = createdDetail;
        this.uneditedTitle = uneditedTitle;
        this.editedTitle = editedTitle;
        this.uneditedDetail = uneditedDetail;
        this.editedDetail = editedDetail;
    }

    public UpdateType getUpdateType() {
        return updateType;
    }

    public String getUpdateId() {
        return updateId;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public String getReason() {
        return reason;
    }

    public String getCreatedTitle() {
        return createdTitle;
    }

    public String getCreatedDetail() {
        return createdDetail;
    }

    public String getUneditedTitle() {
        return uneditedTitle;
    }

    public String getEditedTitle() {
        return editedTitle;
    }

    public String getUneditedDetail() {
        return uneditedDetail;
    }

    public String getEditedDetail() {
        return editedDetail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QuestionUpdatedRecord)) return false;
        QuestionUpdatedRecord that = (QuestionUpdatedRecord) o;
        return getUpdateType() == that.getUpdateType() &&
                Objects.equals(getUpdateId(), that.getUpdateId()) &&
                Objects.equals(getUpdatedAt(), that.getUpdatedAt()) &&
                Objects.equals(getReason(), that.getReason()) &&
                Objects.equals(getCreatedTitle(), that.getCreatedTitle()) &&
                Objects.equals(getCreatedDetail(), that.getCreatedDetail()) &&
                Objects.equals(getUneditedTitle(), that.getUneditedTitle()) &&
                Objects.equals(getEditedTitle(), that.getEditedTitle()) &&
                Objects.equals(getUneditedDetail(), that.getUneditedDetail()) &&
                Objects.equals(getEditedDetail(), that.getEditedDetail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUpdateType(), getUpdateId(), getUpdatedAt(), getReason(),
                getCreatedTitle(), getCreatedDetail(), getUneditedTitle(), getEditedTitle(),
                getUneditedDetail(), getEditedDetail());
    }

    public enum UpdateType {
        CREATED, TITLE_EDITED, DETAIL_EDITED
    }
}

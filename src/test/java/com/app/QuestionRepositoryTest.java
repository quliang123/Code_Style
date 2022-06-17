package com.app;

import com.app.core.JpaRepositoryTest;
import com.app.domian.model.entity.Question;
import com.app.domian.repository.QuestionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;


/**
 * @program: Code_Style
 * @description:
 * @author: quliang
 * @create: 2022-06-15 10:10
 **/
@JpaRepositoryTest
public class QuestionRepositoryTest {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    void repositiry_should_successful_save_question() {
        Question question = new Question("UID_0001", "A test title", "A test detail");
        question.editTitle("UID_0002","for test","A new test title");
        Question save = questionRepository.save(question);

        //Assertions.assertNull(save.getId());
        Assertions.assertNotNull(save.getId());
        Assertions.assertEquals(save.getId(),question.getId());
    }

    @Test
    void repositiry_should_successful_find_question_by_id() throws Throwable {
        Question question = new Question(
                "UID_0001", "A test title", "A test detail");
        question.editTitle("UID_0002","for test","A new test title");
        Question saveQuestion = questionRepository.saveAndFlush(question);
        entityManager.detach(saveQuestion);
        Question findQuestion = questionRepository.findById(saveQuestion.getId())
                .orElseThrow(AssertionFailedError::new);

        Assertions.assertNotNull(findQuestion.getId());
        Assertions.assertEquals(findQuestion.getId(),question.getId());
    }
}

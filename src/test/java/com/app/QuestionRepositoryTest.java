package com.app;

import com.app.core.JpaRepositoryTest;
import com.app.domian.model.Question;
import com.app.domian.repository.QuestionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


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

    @Test
    void repositiry_should_successful_question() {
        Question question = new Question("UID_0001", "A test title", "A test detail");
        Question save = questionRepository.save(question);
        System.out.println("save = " + save);

        //Assertions.assertNull(save.getId());
        Assertions.assertNotNull(save.getId());
        Assertions.assertEquals(save.getId(),question.getId());
    }
}

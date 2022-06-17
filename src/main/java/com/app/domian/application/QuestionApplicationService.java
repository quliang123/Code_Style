package com.app.domian.application;

import com.app.domian.application.command.CreateQuestionCommand;
import com.app.domian.application.result.CreateQuestionResult;
import com.app.domian.model.entity.Question;
import com.app.domian.repository.QuestionRepository;
import org.springframework.stereotype.Service;

/**
 * @program: Code_Style
 * @description:
 * @author: quliang
 * @create: 2022-06-16 17:02
 **/
@Service
//@Transactional
public class QuestionApplicationService {

    private final QuestionRepository questionRepository;

    public QuestionApplicationService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public CreateQuestionResult createQuestion(CreateQuestionCommand command){
        Question question = new Question(command.getQuestionId(), command.getTitle(),
                command.getDetail());
        questionRepository.save(question);
        return new CreateQuestionResult(question.getQuestionId());
    }
}

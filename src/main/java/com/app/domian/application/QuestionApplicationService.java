package com.app.domian.application;

import com.app.domian.application.command.CreateQuestionCommand;
import com.app.domian.application.command.QueryQuestionCommand;
import com.app.domian.application.convert.QuestionMapper;
import com.app.domian.application.result.CreateQuestionResult;
import com.app.domian.model.entity.Question;
import com.app.domian.repository.QuestionRepository;
import com.app.rest.response.QuestionQueryResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    public CreateQuestionResult createQuestion(CreateQuestionCommand command) {
        Question question = new Question(command.getQuestionId(), command.getTitle(),
                command.getDetail());
        questionRepository.save(question);
        return new CreateQuestionResult(question.getQuestionId());
    }

    public Page<QuestionQueryResponse> queryQuestion(QueryQuestionCommand queryQuestionCommand) {
        PageRequest requestPage = PageRequest.of(queryQuestionCommand.getPage(),
                queryQuestionCommand.getSize());
        Page<Question> questionPage = questionRepository.findAll(requestPage);
        Page<QuestionQueryResponse> responsePage = questionPage.map((q)
                -> QuestionMapper.INSTANCE.convertToPageResponse(q));
        return responsePage;
    }
}

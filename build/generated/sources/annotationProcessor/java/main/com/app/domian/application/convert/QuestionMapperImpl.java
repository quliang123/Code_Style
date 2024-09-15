package com.app.domian.application.convert;

import com.app.domian.application.command.QueryQuestionCommand;
import com.app.domian.model.entity.Question;
import com.app.rest.request.QueryQuestionRequest;
import com.app.rest.response.QuestionQueryResponse;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-07T23:22:32+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_251 (Oracle Corporation)"
)
@Component
public class QuestionMapperImpl implements QuestionMapper {

    @Override
    public QuestionQueryResponse convertToPageResponse(Question question) {
        if ( question == null ) {
            return null;
        }

        QuestionQueryResponse questionQueryResponse = new QuestionQueryResponse();

        questionQueryResponse.setQuestionId( question.getQuestionId() );
        questionQueryResponse.setTitle( question.getTitle() );
        questionQueryResponse.setDetail( question.getDetail() );

        return questionQueryResponse;
    }

    @Override
    public QueryQuestionCommand convertToQueryCommand(QueryQuestionRequest request) {
        if ( request == null ) {
            return null;
        }

        QueryQuestionCommand queryQuestionCommand = new QueryQuestionCommand();

        queryQuestionCommand.setPage( request.getPage() );
        queryQuestionCommand.setSize( request.getSize() );

        return queryQuestionCommand;
    }
}

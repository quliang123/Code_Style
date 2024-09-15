package com.app.domian.application.convert;

import com.app.domian.application.command.QueryQuestionCommand;
import com.app.domian.model.entity.Question;
import com.app.rest.request.QueryQuestionRequest;
import com.app.rest.response.QuestionQueryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @description:
 * @author: quliang
 * @create: 2022-11-07 20:44
 **/
@Mapper(componentModel = "spring")
public interface QuestionMapper {

    QuestionMapper INSTANCE =  Mappers.getMapper(QuestionMapper.class);

    /**
     * 将实体类转换成分页响应类
     * @param question
     * @return
     */
    QuestionQueryResponse convertToPageResponse(Question question);

    /**
     * 将请求对象转换成命令对象
     * @param request
     * @return
     */
    QueryQuestionCommand convertToQueryCommand(QueryQuestionRequest request);
}

package com.app.question.rest;

import com.app.domian.application.QuestionApplicationService;
import com.app.domian.application.result.CreateQuestionResult;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.mockito.ArgumentMatchers.any;
 import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * @program: Code_Style
 * @description:
 * @author: quliang
 * @create: 2022-06-16 17:35
 **/
@WebMvcTest
public class QuestionCommandRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuestionApplicationService questionApplicationService;

    @Test
    void  should_return_ok_when_create_question() throws Exception {
        String questionId="1";
        BDDMockito
                .given(questionApplicationService.createQuestion(any()))
                .willReturn(new CreateQuestionResult(questionId));

        mockMvc
                .perform(
                        post("/questions/create-question")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{\"questionId\":\"UId_00001\",\n" +
                                        "\"title\":\"A title for test.\",\n" +
                                        "\"detail\":\"A detail for test.\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.questionId").value(questionId))
                ;

    }

}

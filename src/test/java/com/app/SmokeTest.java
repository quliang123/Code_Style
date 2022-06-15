package com.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @program: Code_Style
 * @description:
 * @author: quliang
 * @create: 2022-06-15 10:10
 **/
@SpringBootTest
@AutoConfigureMockMvc
public class SmokeTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void should_return_ok_when_request_endpoint_of_health() throws Exception {
        mockMvc
                .perform(get("/actuator/health"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("UP"))
                ;
    }
}

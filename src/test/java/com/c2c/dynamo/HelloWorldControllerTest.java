package com.c2c.dynamo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.c2c.dynamo.HelloWorldController;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ComponentScan
@WebMvcTest(controllers = HelloWorldController.class)
public class HelloWorldControllerTest {

    @Autowired
    private MockMvc mvc;
    
    @Test
    public void checkMessage() throws Exception {
        String result = mvc.perform(get("/hello")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
        .andReturn().getResponse().getContentAsString();
        assertThat(result).isEqualTo("Hello World");
    }

    @Test
    public void checkMessageWithParam() throws Exception {
        String result = mvc.perform(get("/hello/john")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        assertThat(result).isEqualTo("Hello john");
    }
}
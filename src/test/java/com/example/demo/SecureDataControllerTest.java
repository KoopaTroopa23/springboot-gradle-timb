package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SecureDataController.class)
class SecureDataControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void login_validCredentials_returns200() throws Exception {
        mockMvc.perform(post("/api/login")
                       .param("username", "kw")
                       .param("password", "bigT"))
               .andExpect(status().isOk())
               .andExpect(content().string(containsString("Access granted")));
    }

    @Test
    void login_wrongPassword_returns401() throws Exception {
        mockMvc.perform(post("/api/login")
                       .param("username", "kw")
                       .param("password", "wrongPass"))
               .andExpect(status().isUnauthorized())
               .andExpect(content().string(containsString("Invalid credentials")));
    }

    @Test
    void login_wrongUsername_returns401() throws Exception {
        mockMvc.perform(post("/api/login")
                       .param("username", "nobody")
                       .param("password", "bigT"))
               .andExpect(status().isUnauthorized());
    }

    @Test
    void profile_returns200() throws Exception {
        mockMvc.perform(get("/api/profile"))
               .andExpect(status().isOk());
    }

    @Test
    void welcome_returnsMessage() throws Exception {
        mockMvc.perform(get("/api/"))
               .andExpect(status().isOk())
               .andExpect(content().string(containsString("welcome")));
    }
}

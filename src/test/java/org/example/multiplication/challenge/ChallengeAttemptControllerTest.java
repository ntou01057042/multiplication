package org.example.multiplication.challenge;

import org.example.multiplication.user.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@AutoConfigureJsonTesters
@ExtendWith(SpringExtension.class)
@WebMvcTest(ChallengeAttemptController.class)
class ChallengeAttemptControllerTest {

    @MockBean
    private ChallengeService challengeService;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<ChallengeAttemptDTO> jsonRequestAttemptDTO;
    @Autowired
    private JacksonTester<ChallengeAttempt> jsonResultAttempt;

    @Test
    void postValidAttempt() throws Exception {
        // given
        ChallengeAttemptDTO challengeAttemptDTO =
                new ChallengeAttemptDTO(50, 70, "john", 3500);
        User user = new User(1L, "john");
        ChallengeAttempt expectedResponse =
                new ChallengeAttempt(1L, user, 50, 70, 3500, true);
        given(challengeService
                .verifyAttempt(eq(challengeAttemptDTO)))
                .willReturn(expectedResponse);

        // when
        MockHttpServletResponse response = mvc.perform(
                        post("/attempts")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(jsonRequestAttemptDTO.write(challengeAttemptDTO).getJson()))
                .andReturn().getResponse();

        // then
        then(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        then(response.getContentAsString()).isEqualTo(jsonResultAttempt.write(expectedResponse).getJson());
    }

    @Test
    void postInvalidAttempt() throws Exception {
        // given an attempt with invalid input data
        ChallengeAttemptDTO challengeAttemptDTO =
                new ChallengeAttemptDTO(2000, -70, "john", 1);

        // when
        MockHttpServletResponse response = mvc.perform(
                        post("/attempts")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(jsonRequestAttemptDTO.write(challengeAttemptDTO).getJson()))
                .andReturn().getResponse();

        // then
        then(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }
}
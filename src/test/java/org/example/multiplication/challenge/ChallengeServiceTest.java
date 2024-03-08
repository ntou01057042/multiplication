package org.example.multiplication.challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.*;

class ChallengeServiceTest {

    private ChallengeService challengeService;

    @BeforeEach
    void setUp() {
        challengeService = new ChallengeServiceImpl();
    }

    @Test
    void verifyCorrectAttempt() {
        // given
        ChallengeAttemptDTO challengeAttemptDTO =
                new ChallengeAttemptDTO(50, 60, "john_doe", 3000);

        // when
        ChallengeAttempt challengeAttempt = challengeService.verifyAttempt(challengeAttemptDTO);

        // then
        then(challengeAttempt.isCorrect()).isTrue();
    }

    @Test
    void verifyWrongAttempt() {
        // given
        ChallengeAttemptDTO challengeAttemptDTO =
                new ChallengeAttemptDTO(50, 60, "john_doe", 5000);

        // when
        ChallengeAttempt challengeAttempt = challengeService.verifyAttempt(challengeAttemptDTO);

        // then
        then(challengeAttempt.isCorrect()).isFalse();
    }
}
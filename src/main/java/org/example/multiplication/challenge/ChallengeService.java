package org.example.multiplication.challenge;

public interface ChallengeService {

    /**
     * Verifies if an attempt coming from the presentation layer is correct or not.
     * @return the resulting ChallengeAttempt object
     */
    ChallengeAttempt verifyAttempt(ChallengeAttemptDTO challengeAttemptDTO);
}

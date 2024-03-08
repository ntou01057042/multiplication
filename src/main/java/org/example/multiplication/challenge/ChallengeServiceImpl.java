package org.example.multiplication.challenge;

import org.example.multiplication.user.User;
import org.springframework.stereotype.Service;

@Service
public class ChallengeServiceImpl implements ChallengeService {

    @Override
    public ChallengeAttempt verifyAttempt(ChallengeAttemptDTO challengeAttemptDTO) {

        User user = new User(null, challengeAttemptDTO.getUserAlias());

        boolean isCorrect = challengeAttemptDTO.getResultAttempt() ==
                challengeAttemptDTO.getFactorA() * challengeAttemptDTO.getFactorB();

        // Builds the domain object. Null id for now.
        return new ChallengeAttempt(null,
                user,
                challengeAttemptDTO.getFactorA(),
                challengeAttemptDTO.getFactorB(),
                challengeAttemptDTO.getResultAttempt(),
                isCorrect);
    }
}

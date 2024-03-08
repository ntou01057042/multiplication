package org.example.multiplication.challenge;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.example.multiplication.user.User;

/**
 * Identifies the attempt from a {@link User} to solve a challenge.
 */
@AllArgsConstructor
@Getter
@ToString
public class ChallengeAttempt {

    private long id;

    private long userId;

    private int factorA;

    private int factorB;

    private int resultAttempt;

    private boolean correct;
}

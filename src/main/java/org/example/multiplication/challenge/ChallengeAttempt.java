package org.example.multiplication.challenge;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.example.multiplication.user.User;

/**
 * Identifies the attempt from a {@link User} to solve a challenge.
 */
@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class ChallengeAttempt {
    private Long id;
    private User user;
    private int factorA;
    private int factorB;
    private int resultAttempt;
    private boolean correct;
}

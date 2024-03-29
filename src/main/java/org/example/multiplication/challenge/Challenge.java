package org.example.multiplication.challenge;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * This class represents a Challenge to solve a multiplication (a * b).
 */
@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class Challenge {
    private int factorA;
    private int factorB;
}

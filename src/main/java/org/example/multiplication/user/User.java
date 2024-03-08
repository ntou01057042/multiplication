package org.example.multiplication.user;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Stores information to identify the user.
 */
@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class User {
    private Long id;
    private String alias;
}

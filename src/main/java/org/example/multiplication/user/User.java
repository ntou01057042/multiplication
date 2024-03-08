package org.example.multiplication.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * Stores information to identify the user.
 */
@AllArgsConstructor
@Getter
@ToString
public class User {

    private long id;

    private String alias;
}

package com.specific.group.multiplication.user;

import lombok.*;

import javax.persistence.*;

/**
 * Stores information to identify the user.
 */
@Entity
@Data
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String alias;

    public User(final String userAlias) {
        this(null, userAlias);
    }
}

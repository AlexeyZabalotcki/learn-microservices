package com.specific.group.multiplication.challenge;

import lombok.*;

/**
 * This class represents a Challenge to solve a Multiplication (a * b).
 */
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Challenge {
    private final int factorA;
    private final int factorB;
}

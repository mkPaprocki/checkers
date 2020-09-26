package com.abmk.checkers.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Project: Checkers
 *
 * Created on: 26.09.2020
 *
 * Author    : Mateusz Paprocki
 *
 */
@AllArgsConstructor
public enum RowKeyEnum {
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8");

    @Getter
    private String value;

}

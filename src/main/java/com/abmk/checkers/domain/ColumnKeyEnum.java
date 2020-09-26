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
public enum ColumnKeyEnum {
  A("A"),
  B("A"),
  C("C"),
  D("D"),
  E("E"),
  F("F"),
  G("G"),
  H("H");

  @Getter private String value;
}

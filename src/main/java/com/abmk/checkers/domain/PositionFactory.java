package com.abmk.checkers.domain;

/**
 * Project: Checkers
 *
 * Created on: 23.10.2020
 *
 * Author    : Mateusz Paprocki
 */
public class PositionFactory {

  private PositionFactory() {

  }

  public static Position createPosition(int row, int column) {
    if (row > 7 || column > 7 || row < 0 || column < 0) {
      return null;
    }

    return new Position(row, column);
  }
}


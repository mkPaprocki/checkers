package com.abmk.checkers.domain;

import java.util.Objects;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Project: Checkers
 *
 * Created on: 15.10.2020
 *
 * Author    : Mateusz Paprocki
 *
 */
@Data
@AllArgsConstructor
public class Position {

  @Size(min = 0, max = 7)
  int row;

  @Size(min = 0, max = 7)
  int column;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Position position = (Position) o;
    return row == position.row &&
        column == position.column;
  }

  @Override
  public int hashCode() {
    return Objects.hash(row, column);
  }
}

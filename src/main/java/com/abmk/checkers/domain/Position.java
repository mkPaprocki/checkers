package com.abmk.checkers.domain;

import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import lombok.AllArgsConstructor;
import lombok.Data;
import javax.validation.constraints.NotNull;

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

  @Valid
  @NotNull
  @Min(0)
  @Max(7)
  Integer row;

  @Valid
  @NotNull
  @Min(0)
  @Max(7)
  Integer column;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Position position = (Position) o;
    return row.equals(position.row) &&
        column.equals(position.column);
  }

  @Override
  public int hashCode() {
    return Objects.hash(row, column);
  }

  public Integer getRow() {
    return row;
  }

  public void setRow(@Valid Integer row) {
    this.row = row;
  }
}

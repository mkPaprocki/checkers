package com.abmk.checkers.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Project: Checkers
 *
 * Created on: 16.09.2020
 *
 * Author    : Mateusz Paprocki
 */
@Data
@AllArgsConstructor
public class Piece {

  private String id;
  private PieceColoru colour;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public PieceColoru getColour() {
    return colour;
  }

  public void setColour(PieceColoru colour) {
    this.colour = colour;
  }
}

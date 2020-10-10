package com.abmk.checkers.domain;

import java.util.UUID;

/**
 * Project: Checkers
 *
 * Created on: 10.10.2020
 *
 * Author    : Mateusz Paprocki
 *
 */
public class PieceFactory {

  private PieceFactory(){

  }

  public static Piece createWhitePiece() {
    return new Piece(UUID.randomUUID().toString(), PieceColoru.WHITE);
  }

  public static Piece createBlackPiece() {
    return new Piece(UUID.randomUUID().toString(), PieceColoru.BLACK);
  }

}

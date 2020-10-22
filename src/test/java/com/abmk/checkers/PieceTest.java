package com.abmk.checkers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.abmk.checkers.domain.Piece;
import com.abmk.checkers.domain.PieceColoru;
import com.abmk.checkers.domain.PieceFactory;
import org.junit.jupiter.api.Test;

/**
 * Project: Checkers
 *
 * Created on: 10.10.2020
 *
 * Author    : Mateusz Paprocki
 */
class PieceTest {

  @Test
  void testShouldCreateWhitePiece() {
    Piece blackPiece = PieceFactory.createWhitePiece();
    assertEquals(PieceColoru.WHITE, blackPiece.getColour());
  }

  @Test
  void testShouldCreateBlackPiece() {
    Piece blackPiece = PieceFactory.createBlackPiece();
    assertEquals(PieceColoru.BLACK, blackPiece.getColour());
  }

  @Test
  void testShouldCreatePiecesWithDifferentIdAndSameColours() {
    Piece piece1 = PieceFactory.createWhitePiece();
    Piece piece2 = PieceFactory.createWhitePiece();

    assertNotEquals(piece1.getId(), piece2.getId());
    assertEquals(piece1.getColour(), piece2.getColour());

    Piece piece3 = PieceFactory.createBlackPiece();
    Piece piece4 = PieceFactory.createBlackPiece();

    assertNotEquals(piece1.getId(), piece2.getId());
    assertEquals(piece1.getColour(), piece2.getColour());
  }

}

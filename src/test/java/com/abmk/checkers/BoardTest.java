package com.abmk.checkers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.abmk.checkers.domain.Board;
import com.abmk.checkers.domain.Piece;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Project: Checkers
 *
 * Created on: 16.09.2020
 *
 * Author    : Mateusz Paprocki
 *
 */
@RunWith(SpringRunner.class)
class BoardTest {

  private Board board;

  @BeforeEach
  void initializeBoard() {
    Board board = new Board(UUID.randomUUID().toString(), 8, new Piece[8][8]);
    this.board = board;
  }

  @Test
  void boardHasValidDimensions() {
    Board board = new Board(UUID.randomUUID().toString(), 8, new Piece[8][8]);
    assertEquals(8, board.getSize());
  }

  @Test
  void boardShouldTakeAndReturnChecker() {
    Piece piece = new Piece(UUID.randomUUID().toString());
    this.board.putCheckerOnPosition(piece, 0, 0);
    assertEquals(piece, board.getCheckerFromPosition(0, 0));
  }

  @Test
  void checkersShouldBePresentWhereTheyWereInitialized() {
    createFullBoard();
    assertNotNull(board.getCheckerFromPosition(0, 0));
    assertNotNull(board.getCheckerFromPosition(2, 0));
    assertNotNull(board.getCheckerFromPosition(1, 0));
    assertNotNull(board.getCheckerFromPosition(0, 2));
    assertNotNull(board.getCheckerFromPosition(2, 2));
    assertNotNull(board.getCheckerFromPosition(1, 3));
    assertNotNull(board.getCheckerFromPosition(0, 4));
    assertNotNull(board.getCheckerFromPosition(2, 4));
    assertNotNull(board.getCheckerFromPosition(1, 5));
    assertNotNull(board.getCheckerFromPosition(0, 6));
    assertNotNull(board.getCheckerFromPosition(2, 6));
    assertNotNull(board.getCheckerFromPosition(1, 7));
  }

  private void createFullBoard() {
    this.board.putCheckerOnPosition(new Piece(UUID.randomUUID().toString()), 0, 0);
    this.board.putCheckerOnPosition(new Piece(UUID.randomUUID().toString()), 2, 0);
    this.board.putCheckerOnPosition(new Piece(UUID.randomUUID().toString()), 1, 0);
    this.board.putCheckerOnPosition(new Piece(UUID.randomUUID().toString()), 0, 2);
    this.board.putCheckerOnPosition(new Piece(UUID.randomUUID().toString()), 2, 2);
    this.board.putCheckerOnPosition(new Piece(UUID.randomUUID().toString()), 1, 3);
    this.board.putCheckerOnPosition(new Piece(UUID.randomUUID().toString()), 0, 4);
    this.board.putCheckerOnPosition(new Piece(UUID.randomUUID().toString()), 2, 4);
    this.board.putCheckerOnPosition(new Piece(UUID.randomUUID().toString()), 1, 5);
    this.board.putCheckerOnPosition(new Piece(UUID.randomUUID().toString()), 0, 6);
    this.board.putCheckerOnPosition(new Piece(UUID.randomUUID().toString()), 2, 6);
    this.board.putCheckerOnPosition(new Piece(UUID.randomUUID().toString()), 1, 7);
  }
}
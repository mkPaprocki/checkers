package com.abmk.checkers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.abmk.checkers.domain.Board;
import com.abmk.checkers.domain.Checker;
import com.abmk.checkers.domain.ColumnKeyEnum;
import com.abmk.checkers.domain.RowKeyEnum;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Project: Checkers
 *
 * Created on: 16.09.2020
 *
 * Author    : Mateusz Paprocki
 *
 */
class BoardTest {

  private Board board;

  @BeforeEach
  void initializeBoard() {
    Board board = new Board("someId", 8);
    this.board = board;
  }

  @Test
  void boardHasValidDimensions() {
    Board board = new Board("someId", 8);
    assertEquals(8, board.getSize());
  }

  @Test
  void boardShouldTakeAndRemoveChecker() {
    Checker checker = new Checker(UUID.randomUUID().toString());
    this.board.putCheckerOnPosition(checker, RowKeyEnum.ONE, ColumnKeyEnum.A);
    assertEquals(checker, board.getCheckerFromPosition(RowKeyEnum.ONE, ColumnKeyEnum.A));
  }

  @Test
  void checkersShouldBePresentWhereTheyWereInitialized() {
    createFullBoard();
    assertNotNull(board.getCheckerFromPosition(RowKeyEnum.ONE, ColumnKeyEnum.A));
    assertNotNull(board.getCheckerFromPosition(RowKeyEnum.THREE, ColumnKeyEnum.A));
    assertNotNull(board.getCheckerFromPosition(RowKeyEnum.TWO, ColumnKeyEnum.B));
    assertNotNull(board.getCheckerFromPosition(RowKeyEnum.ONE, ColumnKeyEnum.C));
    assertNotNull(board.getCheckerFromPosition(RowKeyEnum.THREE, ColumnKeyEnum.C));
    assertNotNull(board.getCheckerFromPosition(RowKeyEnum.TWO, ColumnKeyEnum.D));
    assertNotNull(board.getCheckerFromPosition(RowKeyEnum.ONE, ColumnKeyEnum.E));
    assertNotNull(board.getCheckerFromPosition(RowKeyEnum.THREE, ColumnKeyEnum.E));
    assertNotNull(board.getCheckerFromPosition(RowKeyEnum.TWO, ColumnKeyEnum.F));
    assertNotNull(board.getCheckerFromPosition(RowKeyEnum.ONE, ColumnKeyEnum.G));
    assertNotNull(board.getCheckerFromPosition(RowKeyEnum.THREE, ColumnKeyEnum.G));
    assertNotNull(board.getCheckerFromPosition(RowKeyEnum.TWO, ColumnKeyEnum.H));
  }

  private void createFullBoard() {
    this.board.putCheckerOnPosition(new Checker(UUID.randomUUID().toString()), RowKeyEnum.ONE, ColumnKeyEnum.A);
    this.board.putCheckerOnPosition(new Checker(UUID.randomUUID().toString()), RowKeyEnum.THREE, ColumnKeyEnum.A);
    this.board.putCheckerOnPosition(new Checker(UUID.randomUUID().toString()), RowKeyEnum.TWO, ColumnKeyEnum.B);
    this.board.putCheckerOnPosition(new Checker(UUID.randomUUID().toString()), RowKeyEnum.ONE, ColumnKeyEnum.C);
    this.board.putCheckerOnPosition(new Checker(UUID.randomUUID().toString()), RowKeyEnum.THREE, ColumnKeyEnum.C);
    this.board.putCheckerOnPosition(new Checker(UUID.randomUUID().toString()), RowKeyEnum.TWO, ColumnKeyEnum.D);
    this.board.putCheckerOnPosition(new Checker(UUID.randomUUID().toString()), RowKeyEnum.ONE, ColumnKeyEnum.E);
    this.board.putCheckerOnPosition(new Checker(UUID.randomUUID().toString()), RowKeyEnum.THREE, ColumnKeyEnum.E);
    this.board.putCheckerOnPosition(new Checker(UUID.randomUUID().toString()), RowKeyEnum.TWO, ColumnKeyEnum.F);
    this.board.putCheckerOnPosition(new Checker(UUID.randomUUID().toString()), RowKeyEnum.ONE, ColumnKeyEnum.G);
    this.board.putCheckerOnPosition(new Checker(UUID.randomUUID().toString()), RowKeyEnum.THREE, ColumnKeyEnum.G);
    this.board.putCheckerOnPosition(new Checker(UUID.randomUUID().toString()), RowKeyEnum.TWO, ColumnKeyEnum.H);
  }
}
package com.abmk.checkers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.abmk.checkers.domain.Board;
import com.abmk.checkers.domain.BoardFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Project: Checkers
 *
 * Created on: 16.09.2020
 *
 * Author    : Mateusz Paprocki
 *
 */
@SpringBootTest
class BoardTest {

  @Test
  void boardHasValidDimensions() {
    Board board = BoardFactory.createNewBoardWithPieces();
    assertEquals(8, board.getSize());
  }
}
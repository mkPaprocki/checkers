package com.abmk.checkers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.abmk.checkers.domain.Board;
import com.abmk.checkers.domain.Piece;
import com.abmk.checkers.domain.PieceColoru;
import com.abmk.checkers.domain.PieceFactory;
import com.abmk.checkers.domain.Position;
import com.abmk.checkers.domain.PositionFactory;
import com.abmk.checkers.service.BoardService;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Project: Checkers
 *
 * Created on: 15.10.2020
 *
 * Author    : Mateusz Paprocki
 */
@SpringBootTest
class BoardServiceTest {

  @Autowired
  BoardService boardService;

  private Board board;

  @BeforeEach
  void initializeBoard() {
    this.board = boardService.initializeNewBoardState();
  }

  @Test
  void testPieceShouldMoveToPosition() {
    //create board and set piece on position
    final Piece piece = PieceFactory.createWhitePiece();
    this.board.getBoardState()[0][0] = piece;

    //move piece to new position, check if it's in right place
    boardService.movePieceToPosition(board, piece, PositionFactory.createPosition(1, 1));
    assertEquals(piece, this.board.getBoardState()[1][1]);
  }

  @Test
  void testShouldNotMoveNotExistingPieceToNewPosition() {
    //create board and set piece
    final Piece piece = PieceFactory.createWhitePiece();

    //move piece to new position, should return false
    assertFalse(boardService.movePieceToPosition(board, piece, PositionFactory.createPosition(1, 1)));
    assertNotEquals(piece, this.board.getBoardState()[1][1]);
  }

  @Test
  void checkersShouldBePresentWhereTheyWereInitialized() {
    Board board = boardService.initializeNewBoardState();
    Piece[][] boardState = board.getBoardState();
    assertNotNull(boardState[0][0]);
    assertNotNull(boardState[2][0]);
    assertNotNull(boardState[1][0]);
    assertNotNull(boardState[0][2]);
    assertNotNull(boardState[2][2]);
    assertNotNull(boardState[1][3]);
    assertNotNull(boardState[0][4]);
    assertNotNull(boardState[2][4]);
    assertNotNull(boardState[1][5]);
    assertNotNull(boardState[0][6]);
    assertNotNull(boardState[2][6]);
    assertNotNull(boardState[1][7]);
  }

  @Test
  void testShouldContainAllIdsOfPieces() {
    Set<String> allExpectedId = new HashSet<>();
    Map<Piece, Position> allPiecesWithPositions = boardService.getAllPiecesWithPositions(board);
    List<String> allIds = allPiecesWithPositions.keySet().stream().map(Piece::getId).collect(Collectors.toList());
    allExpectedId.add("1");
    allExpectedId.add("2");
    allExpectedId.add("3");
    allExpectedId.add("4");
    allExpectedId.add("5");
    allExpectedId.add("6");
    allExpectedId.add("7");
    allExpectedId.add("8");
    allExpectedId.add("9");
    allExpectedId.add("10");
    allExpectedId.add("11");
    allExpectedId.add("12");
    allExpectedId.add("13");
    allExpectedId.add("14");
    allExpectedId.add("15");
    allExpectedId.add("16");
    allExpectedId.add("17");
    allExpectedId.add("18");
    allExpectedId.add("19");
    allExpectedId.add("20");
    allExpectedId.add("21");
    allExpectedId.add("22");
    allExpectedId.add("23");
    allExpectedId.add("24");
    assertTrue("Should contain all expected ids", allIds.containsAll(allExpectedId));
  }

  @Test
  void testShouldReturnAll24PiecesWithPositions() {
    Map<Piece, Position> allPiecesWithPositions = boardService.getAllPiecesWithPositions(board);
    Collection<Position> allPositions = allPiecesWithPositions.values();
    Collection<Piece> allPieces = allPiecesWithPositions.keySet();
    assertEquals(24, allPieces.size());
    assertEquals(24, allPositions.size());
  }

  @Test
  void testShouldContainCorrectPositions() {
    Map<Piece, Position> allPiecesWithPositions = boardService.getAllPiecesWithPositions(board);
    assertEquals(PositionFactory.createPosition(0, 0), allPiecesWithPositions.get(new Piece("1", PieceColoru.WHITE)));
    assertEquals(PositionFactory.createPosition(2, 0), allPiecesWithPositions.get(new Piece("2", PieceColoru.WHITE)));
    assertEquals(PositionFactory.createPosition(1, 0), allPiecesWithPositions.get(new Piece("3", PieceColoru.WHITE)));
    assertEquals(PositionFactory.createPosition(0, 2), allPiecesWithPositions.get(new Piece("4", PieceColoru.WHITE)));
    assertEquals(PositionFactory.createPosition(2, 2), allPiecesWithPositions.get(new Piece("5", PieceColoru.WHITE)));
    assertEquals(PositionFactory.createPosition(1, 3), allPiecesWithPositions.get(new Piece("6", PieceColoru.WHITE)));
    assertEquals(PositionFactory.createPosition(0, 4), allPiecesWithPositions.get(new Piece("7", PieceColoru.WHITE)));
    assertEquals(PositionFactory.createPosition(2, 4), allPiecesWithPositions.get(new Piece("8", PieceColoru.WHITE)));
    assertEquals(PositionFactory.createPosition(1, 5), allPiecesWithPositions.get(new Piece("9", PieceColoru.WHITE)));
    assertEquals(PositionFactory.createPosition(0, 6), allPiecesWithPositions.get(new Piece("10", PieceColoru.WHITE)));
    assertEquals(PositionFactory.createPosition(2, 6), allPiecesWithPositions.get(new Piece("11", PieceColoru.WHITE)));
    assertEquals(PositionFactory.createPosition(1, 7), allPiecesWithPositions.get(new Piece("12", PieceColoru.WHITE)));
    assertEquals(PositionFactory.createPosition(6, 0), allPiecesWithPositions.get(new Piece("13", PieceColoru.BLACK)));
    assertEquals(PositionFactory.createPosition(5, 1), allPiecesWithPositions.get(new Piece("14", PieceColoru.BLACK)));
    assertEquals(PositionFactory.createPosition(7, 1), allPiecesWithPositions.get(new Piece("15", PieceColoru.BLACK)));
    assertEquals(PositionFactory.createPosition(6, 2), allPiecesWithPositions.get(new Piece("16", PieceColoru.BLACK)));
    assertEquals(PositionFactory.createPosition(5, 3), allPiecesWithPositions.get(new Piece("17", PieceColoru.BLACK)));
    assertEquals(PositionFactory.createPosition(7, 3), allPiecesWithPositions.get(new Piece("18", PieceColoru.BLACK)));
    assertEquals(PositionFactory.createPosition(6, 4), allPiecesWithPositions.get(new Piece("19", PieceColoru.BLACK)));
    assertEquals(PositionFactory.createPosition(7, 5), allPiecesWithPositions.get(new Piece("20", PieceColoru.BLACK)));
    assertEquals(PositionFactory.createPosition(5, 5), allPiecesWithPositions.get(new Piece("21", PieceColoru.BLACK)));
    assertEquals(PositionFactory.createPosition(6, 6), allPiecesWithPositions.get(new Piece("22", PieceColoru.BLACK)));
    assertEquals(PositionFactory.createPosition(7, 7), allPiecesWithPositions.get(new Piece("23", PieceColoru.BLACK)));
    assertEquals(PositionFactory.createPosition(5, 7), allPiecesWithPositions.get(new Piece("24", PieceColoru.BLACK)));
  }

  @Test
  void testShouldMovePieceToNewPosition() {

    final Position oldPosition = PositionFactory.createPosition(2, 0);
    assertEquals(oldPosition, boardService.findPiecePosition(board, "2"));

    final Position newPosition = PositionFactory.createPosition(4, 2);
    assertTrue(boardService.movePieceToPosition(board, new Piece("2", PieceColoru.WHITE), newPosition));
    assertEquals(newPosition, boardService.findPiecePosition(board, "2"));
  }

  @Test
  void testShouldReturnFalseFromNewNullPosition() {
    assertFalse(boardService.movePieceToPosition(board, new Piece("2", PieceColoru.WHITE), null));
  }

  @Test
  void testShouldFailForOutOfRangePosition() {
    Position outOfIndexPosition_Large = PositionFactory.createPosition(200, 300);
    assertFalse(boardService.movePieceToPosition(board, new Piece("2", PieceColoru.WHITE), outOfIndexPosition_Large));
    Position outOfIndexPosition_NegativeRow = PositionFactory.createPosition(-2, 3);
    assertFalse(boardService.movePieceToPosition(board, new Piece("2", PieceColoru.WHITE), outOfIndexPosition_NegativeRow));
    Position outOfIndexPosition_NegativeColumn = PositionFactory.createPosition(200, 300);
    assertFalse(boardService.movePieceToPosition(board, new Piece("2", PieceColoru.WHITE), outOfIndexPosition_NegativeColumn));
    Position outOfIndexPosition_LargeNegative = PositionFactory.createPosition(200, 300);
    assertFalse(boardService.movePieceToPosition(board, new Piece("2", PieceColoru.WHITE), outOfIndexPosition_LargeNegative));
  }
}

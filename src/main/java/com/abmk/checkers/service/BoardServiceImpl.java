package com.abmk.checkers.service;

import com.abmk.checkers.domain.Board;
import com.abmk.checkers.domain.BoardFactory;
import com.abmk.checkers.domain.Piece;
import com.abmk.checkers.domain.Position;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * Project: Checkers
 *
 * Created on: 29.09.2020
 *
 * Author    : Mateusz Paprocki
 */
@Service
public class BoardServiceImpl implements BoardService {

  public Board initializeNewBoardState() {

    return BoardFactory.createNewBoardWithPieces();
  }

  @Override
  public Map<Piece, Position> getAllPiecesWithPositions(final Board board) {
    Piece[][] boardState = board.getBoardState();
    Map<Piece, Position> allPiecesWithPositions = new HashMap<>();
    for (int i = 0; boardState.length > i; i++) {
      for (int j = 0; boardState.length > j; j++) {
        if (boardState[i][j] != null) {
          allPiecesWithPositions.put(boardState[i][j], new Position(i, j));
        }
      }
    }
    return allPiecesWithPositions;
  }

  //TODO resolve issue with move and put piece on position. Issue with empty fields. Do I need those methods??
  @Override
  public Boolean movePieceToPosition(Board board, Piece piece, Position position) {
    if (board.getBoardState().length > 0 && isEmptyPosition(board, position)) {
      final Position currentPosition = findPiecePosition(board, piece.getId());
      if (currentPosition != null) {
        board.getBoardState()[position.getRow()][position.getColumn()] = board.getBoardState()[currentPosition
            .getRow()][currentPosition.getColumn()];
        board.getBoardState()[currentPosition.getRow()][currentPosition.getColumn()] = null;
      }
      return true;
    } else {
      return false;
    }
  }

  public Position findPiecePosition(final Board board, final String pieceId) {
    final Piece[][] boardState = board.getBoardState();
    for (int i = 0; boardState.length > i; i++) {
      for (int j = 0; boardState.length > j; j++) {
        if (boardState[i][j] != null && pieceId.equals(boardState[i][j].getId())) {
          return new Position(i, j);
        }
      }
    }
    return null;
  }

  @Override
  public Map<Piece, Position> getPieceWithPositionById(Board board, String id) {
    final Position position = findPiecePosition(board, id);
    final Piece piece = board.getBoardState()[position.getRow()][position.getColumn()];
    final Map<Piece, Position> pieceWithPosition = new HashMap<>();
    pieceWithPosition.put(piece, position);
    return pieceWithPosition;
  }

  private boolean isEmptyPosition(Board board, Position position) {
    return null == board.getBoardState()[position.getRow()][position.getColumn()];
  }
}

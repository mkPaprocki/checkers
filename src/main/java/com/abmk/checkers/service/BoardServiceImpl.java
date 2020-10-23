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

  @Override
  public Boolean movePieceToPosition(final Board board, Piece piece, final Position newPosition) {
    if (newPosition != null && board.getBoardState().length > 0) {
      final Position currentPosition = findPiecePosition(board, piece.getId());
      return movePieceToNewPositionEmptyOld(board, newPosition, currentPosition);
    } else {
      return false;
    }
  }

  private boolean movePieceToNewPositionEmptyOld(Board board, Position newPosition, Position currentPosition) {
    if (currentPosition != null) {
      board.getBoardState()[newPosition.getRow()][newPosition.getColumn()] = board.getBoardState()[currentPosition
          .getRow()][currentPosition.getColumn()];
      board.getBoardState()[currentPosition.getRow()][currentPosition.getColumn()] = null;
      return true;
    }
    return false;
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
  public Map<Piece, Position> getPieceWithPositionById(final Board board, final String id) {
    final Position position = findPiecePosition(board, id);
    final Piece piece = board.getBoardState()[position.getRow()][position.getColumn()];
    final Map<Piece, Position> pieceWithPosition = new HashMap<>();
    pieceWithPosition.put(piece, position);
    return pieceWithPosition;
  }
}

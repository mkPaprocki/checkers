package com.abmk.checkers.service;

import com.abmk.checkers.domain.Board;
import com.abmk.checkers.domain.Piece;
import com.abmk.checkers.domain.Position;
import java.util.Map;

/**
 * Project: Checkers
 *
 * Created on: 29.09.2020
 *
 * Author    : Mateusz Paprocki
 */
public interface BoardService {
  Board initializeNewBoardState();

  Map<Piece, Position> getAllPiecesWithPositions(final Board board);

  Boolean movePieceToPosition(Board board, Piece piece, Position position);

  Position findPiecePosition(Board board, String pieceId);

  Map<Piece, Position> getPieceWithPositionById(Board board, String id);
}

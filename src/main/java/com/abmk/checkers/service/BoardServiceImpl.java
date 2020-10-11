package com.abmk.checkers.service;

import com.abmk.checkers.domain.Piece;
import com.abmk.checkers.domain.PieceColoru;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * Project: Checkers
 *
 * Created on: 29.09.2020
 *
 * Author    : Mateusz Paprocki
 *
 */
@Service
public class BoardServiceImpl implements BoardService {
  public Piece[][] initializeNewBoardState() {
    Piece[][] board = new Piece[8][8];
    board[0][0] = new Piece("1", PieceColoru.WHITE);
    board[2][0] = new Piece("2", PieceColoru.WHITE);
    board[1][0] = new Piece("3", PieceColoru.WHITE);
    board[0][2] = new Piece("4", PieceColoru.WHITE);
    board[2][2] = new Piece("5", PieceColoru.WHITE);
    board[1][3] = new Piece("6", PieceColoru.WHITE);
    board[0][4] = new Piece("7", PieceColoru.WHITE);
    board[2][4] = new Piece("8", PieceColoru.WHITE);
    board[1][5] = new Piece("9", PieceColoru.WHITE);
    board[0][6] = new Piece("10", PieceColoru.WHITE);
    board[2][6] = new Piece("11", PieceColoru.WHITE);
    board[1][7] = new Piece("12", PieceColoru.WHITE);
    return board;
  }
}

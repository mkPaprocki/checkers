package com.abmk.checkers.domain;

import com.abmk.checkers.service.BoardService;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Project: Checkers
 *
 * Created on: 19.10.2020
 *
 * Author    : Mateusz Paprocki
 */
public class BoardFactory {

  private BoardFactory() {

  }

  public static Board createNewBoardWithPieces() {
    Piece[][] boardState = new Piece[8][8];
    boardState[0][0] = new Piece("1", PieceColoru.WHITE);
    boardState[2][0] = new Piece("2", PieceColoru.WHITE);
    boardState[1][0] = new Piece("3", PieceColoru.WHITE);
    boardState[0][2] = new Piece("4", PieceColoru.WHITE);
    boardState[2][2] = new Piece("5", PieceColoru.WHITE);
    boardState[1][3] = new Piece("6", PieceColoru.WHITE);
    boardState[0][4] = new Piece("7", PieceColoru.WHITE);
    boardState[2][4] = new Piece("8", PieceColoru.WHITE);
    boardState[1][5] = new Piece("9", PieceColoru.WHITE);
    boardState[0][6] = new Piece("10", PieceColoru.WHITE);
    boardState[2][6] = new Piece("11", PieceColoru.WHITE);
    boardState[1][7] = new Piece("12", PieceColoru.WHITE);

    boardState[6][0] = new Piece("13", PieceColoru.BLACK);
    boardState[5][1] = new Piece("14", PieceColoru.BLACK);
    boardState[7][1] = new Piece("15", PieceColoru.BLACK);
    boardState[6][2] = new Piece("16", PieceColoru.BLACK);
    boardState[5][3] = new Piece("17", PieceColoru.BLACK);
    boardState[7][3] = new Piece("18", PieceColoru.BLACK);
    boardState[6][4] = new Piece("19", PieceColoru.BLACK);
    boardState[7][5] = new Piece("20", PieceColoru.BLACK);
    boardState[5][5] = new Piece("21", PieceColoru.BLACK);
    boardState[6][6] = new Piece("22", PieceColoru.BLACK);
    boardState[7][7] = new Piece("23", PieceColoru.BLACK);
    boardState[5][7] = new Piece("24", PieceColoru.BLACK);
    return new Board(UUID.randomUUID().toString(), 8, boardState);
  }

}

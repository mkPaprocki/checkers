package com.abmk.checkers.service;

import com.abmk.checkers.domain.Piece;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * Project: Checkers
 *
 * Created on: 29.09.2020
 *
 * Author    : Mateusz Paprocki
 *
 * Copyright 2020 (C) Si-eCommerce sp. z o.o.
 */
@Service
public class BoardServiceImpl implements BoardService {
  public Piece[][] initializeNewBoardState() {
    Piece[][] board = new Piece[8][8];
    board[0][0] = new Piece(UUID.randomUUID().toString());
    board[2][0] = new Piece(UUID.randomUUID().toString());
    board[1][0] = new Piece(UUID.randomUUID().toString());
    board[0][2] = new Piece(UUID.randomUUID().toString());
    board[2][2] = new Piece(UUID.randomUUID().toString());
    board[1][3] = new Piece(UUID.randomUUID().toString());
    board[0][4] = new Piece(UUID.randomUUID().toString());
    board[2][4] = new Piece(UUID.randomUUID().toString());
    board[1][5] = new Piece(UUID.randomUUID().toString());
    board[0][6] = new Piece(UUID.randomUUID().toString());
    board[2][6] = new Piece(UUID.randomUUID().toString());
    board[1][7] = new Piece(UUID.randomUUID().toString());
    return board;
  }
}

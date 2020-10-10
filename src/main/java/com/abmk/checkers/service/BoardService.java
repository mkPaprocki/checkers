package com.abmk.checkers.service;

import com.abmk.checkers.domain.Piece;

/**
 * Project: Checkers
 *
 * Created on: 29.09.2020
 *
 * Author    : Mateusz Paprocki
 *
 */
public interface BoardService {
  Piece[][] initializeNewBoardState();
}

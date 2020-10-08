package com.abmk.checkers.service;

import com.abmk.checkers.domain.Piece;

/**
 * Project: Checkers
 *
 * Created on: 29.09.2020
 *
 * Author    : Mateusz Paprocki
 *
 * Copyright 2020 (C) Si-eCommerce sp. z o.o.
 */
public interface BoardService {
  Piece[][] initializeNewBoardState();
}

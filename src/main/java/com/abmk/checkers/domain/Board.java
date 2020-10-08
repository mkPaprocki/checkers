package com.abmk.checkers.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * Project: Checkers
 *
 * Created on: 16.09.2020
 *
 * Author    : Mateusz Paprocki
 */
@Data
@Document(collation = "board")
public class Board {

  @Id
  private final String id;
  private final Integer size;
  private Piece[][] boardState;

  @PersistenceConstructor
  public Board(String id, Integer size, Piece[][] boardState) {
    this.id = id;
    this.size = size;
    this.boardState = boardState;
  }

  public Board(final String id, final int size) {
    this.id = id;
    this.size = size;
    this.boardState = new Piece[size][size];
  }

  public void putCheckerOnPosition(Piece piece, Integer row, Integer column) {
    getBoardState()[row][column] = piece;
  }

  public Piece getCheckerFromPosition(Integer row, Integer column) {
    return getBoardState()[row][column];
  }
}
package com.abmk.checkers.domain;

import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.Map;
import lombok.Data;

/**
 * Project: Checkers
 *
 * Created on: 16.09.2020
 *
 * Author    : Mateusz Paprocki
 */
@Data
public class Board {

  private final String id;
  private final Integer size;
  private Map<RowKeyEnum, Map<ColumnKeyEnum, Checker>> boardState;

  public Board(final String id, final Integer size) {
    this.id = id;
    this.size = size;
    this.boardState = initializeNewBoardState();
  }

  private Map<RowKeyEnum, Map<ColumnKeyEnum, Checker>> initializeNewBoardState() {
    Map<RowKeyEnum, Map<ColumnKeyEnum, Checker>> boardMap = new LinkedHashMap<>();
    EnumSet.allOf(RowKeyEnum.class).forEach(rowKeyEnum -> boardMap.put(rowKeyEnum, null)
    );
    boardMap.forEach((rowKeyEnum, columnKeyEnumCheckerMap) -> {
      Map<ColumnKeyEnum, Checker> columnMap = new LinkedHashMap<>();
      EnumSet.allOf(ColumnKeyEnum.class).forEach(col -> columnMap.put(col, null));
      boardMap.put(rowKeyEnum, columnMap);
    });
    return boardMap;
  }

  public void putCheckerOnPosition(Checker checker, RowKeyEnum row, ColumnKeyEnum column) {
    this.boardState.get(row).put(column, checker);
  }

  public Checker getCheckerFromPosition(RowKeyEnum row, ColumnKeyEnum column){
    return getBoardState().get(row).get(column);
  }
}
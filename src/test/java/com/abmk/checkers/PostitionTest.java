package com.abmk.checkers;

import com.abmk.checkers.domain.Position;
import org.junit.jupiter.api.Test;

/**
 * Project: Checkers
 *
 * Created on: 17.10.2020
 *
 * Author    : Mateusz Paprocki
 */
public class PostitionTest {

  //TODO czemu walidacja nie wyłapuje nullowej wartosci tutaj?
  @Test
  void shouldNotCreateNullPostion() {
    Position postion = new Position(null, null);
    postion.setColumn(null);
  }
}

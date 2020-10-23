package com.abmk.checkers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.abmk.checkers.domain.Position;
import com.abmk.checkers.domain.PositionFactory;
import org.junit.jupiter.api.Test;

/**
 * Project: Checkers
 *
 * Created on: 17.10.2020
 *
 * Author    : Mateusz Paprocki
 */
class PositionTest {

  @Test
  void testPositionsWithSameValuesShouldBeEqual() {
    Position position1 = new Position(1, 1);
    Position position2 = new Position(1, 1);
    Position position3 = new Position(2, 1);
    Position position4 = new Position(1, 2);
    assertEquals(position1, position2);
    assertFalse(position1.equals(position3) || position1.equals(position4));
  }

  @Test
  void testShouldNotCreateNegativePosition() {
    assertNull(PositionFactory.createPosition(-1,-1));
    assertNull(PositionFactory.createPosition(1,-1));
    assertNull(PositionFactory.createPosition(-1,1));
    assertNull(PositionFactory.createPosition(7,8));
    assertNull(PositionFactory.createPosition(8,7));
    assertNull(PositionFactory.createPosition(8,-1));
    assertNull(PositionFactory.createPosition(8,8));
  }
}

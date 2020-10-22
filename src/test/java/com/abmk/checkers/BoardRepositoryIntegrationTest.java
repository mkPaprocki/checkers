package com.abmk.checkers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.abmk.checkers.domain.Board;
import com.abmk.checkers.repository.BoardRepository;
import com.abmk.checkers.service.BoardService;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * Project: Checkers
 *
 * Created on: 28.09.2020
 *
 * Author    : Mateusz Paprocki
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class BoardRepositoryIntegrationTest {

  @Autowired
  private BoardRepository boardRepository;

  @Autowired
  private BoardService boardService;

  private String id;
  private int size;

  @BeforeEach
  void init() {
    this.id = UUID.randomUUID().toString();
    this.size = 8;
  }

  @Test
  void testShouldSaveEmptyBoardToMongoDB() {
    Board board = new Board(this.id, this.size);
    Board saved = boardRepository.save(board);
    assertNotNull(saved);
    assertNotNull(saved.getId());
    assertNotNull(saved.getSize());
    assertNotNull(saved.getBoardState());
    assertEquals(this.id, saved.getId());
    assertEquals(this.size, saved.getSize());
  }

  @Test
  void testShouldSaveInitializedBoardToMongoDB() {
    Board board = boardService.initializeNewBoardState();
    Board saved = boardRepository.save(board);
    Optional<Board> loadedOpt = boardRepository.findById(board.getId());
    assertTrue(loadedOpt.isPresent());
    assertTrue(loadedOpt.get() instanceof Board);
    Board loaded = loadedOpt.get();
    assertNotNull(loaded);
    assertNotNull(loaded.getId());
    assertNotNull(loaded.getSize());
    assertEquals(board.getId(), saved.getId());
    assertEquals(board.getSize(), saved.getSize());
    assertNotNull(saved.getBoardState());
    assertEquals(board.getBoardState(), saved.getBoardState());
    assertEquals(board.getBoardState()[0][0], saved.getBoardState()[0][0]);
  }
}

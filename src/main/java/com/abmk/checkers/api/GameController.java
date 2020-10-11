package com.abmk.checkers.api;

import com.abmk.checkers.domain.Board;
import com.abmk.checkers.repository.BoardRepository;
import com.abmk.checkers.service.BoardService;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GameController {

  @Autowired
  private final BoardRepository boardRepository;

  @Autowired
  BoardService boardService;

  public GameController(BoardRepository boardRepository) {
    this.boardRepository = boardRepository;
  }

  @MessageMapping("/hello")
  @SendTo("/move/piece")
  public String greeting(String message) throws JsonProcessingException, InterruptedException {
    Thread.sleep(1000); // simulated delay
    Board board = new Board(UUID.randomUUID().toString(), 8, boardService.initializeNewBoardState());
    ObjectMapper mapper = new ObjectMapper();
    return mapper.writeValueAsString(boardRepository.save(board));
  }

  public static String stringify(Object object) {
    ObjectMapper jackson = new ObjectMapper();
    jackson.setSerializationInclusion(Include.NON_NULL);
    try {
      return jackson.writeValueAsString(object);
    } catch (Exception ex) {
      //LOG.log(Level.SEVERE, "Error while creating json: ", ex);
    }
    return null;
  }

//  @MessageMapping("/move")
//  @SendTo("/board")
//  public String moveChecker(String id) throws Exception {
//    //TODO remove test data
//
//    return "{ \"name\":\"John\", \"age\":30, \"car\":\"null\" }" ;
//  }
//
//  @MessageMapping("/game")
//  @SendTo("/board")
//  public String broadcastNews(@Payload String message) {
//    //TODO implement
//    return message;
//  }

}
package com.abmk.checkers.api;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GameController {

  @MessageMapping("/move")
  @SendTo("/board")
  public String moveChecker(String id) throws Exception {
    //TODO remove test data
    return "{ \"name\":\"John\", \"age\":30, \"car\":\"null\" }" ;
  }

  @MessageMapping("/game")
  @SendTo("/board")
  public String broadcastNews(@Payload String message) {
    //TODO implement
    return message;
  }

}
package com.abmk.checkers;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Project: Checkers
 *
 * Created on: 10.10.2020
 *
 * Author    : Mateusz Paprocki
 */
@Component
@ConfigurationProperties(prefix = "websocket")
@Data
public class WebSocetProps {

  private String brokerDestination;
  private String applicationDestination;
  private String stompEndpoint;
}

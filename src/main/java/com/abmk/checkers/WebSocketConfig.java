package com.abmk.checkers;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * Project: Checkers
 *
 * Created on: 26.09.2020
 *
 * Author    : Mateusz Paprocki
 *
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

  private WebSocetProps props;

  public WebSocketConfig(WebSocetProps props) {
    this.props = props;
  }

  @Override
  public void configureMessageBroker(MessageBrokerRegistry config) {
    config.enableSimpleBroker(props.getBrokerDestination());
    config.setApplicationDestinationPrefixes(props.getApplicationDestination());
  }

  @Override
  public void registerStompEndpoints(StompEndpointRegistry registry) {
    registry.addEndpoint(props.getStompEndpoint()).setAllowedOrigins("*").withSockJS();
  }
}
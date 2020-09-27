package com.abmk.checkers;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Project: Checkers
 *
 * Created on: 27.09.2020
 *
 * Author    : Mateusz Paprocki
 *
 * Copyright 2020 (C) Si-eCommerce sp. z o.o.
 */
//TODO figure out wheter embedded redis server is possible to  implement
@Configuration
@PropertySource("classpath:application.properties")
public class RedisProperties {

  private int redisPort;
  private String redisHost;

  public RedisProperties(
      @Value("${spring.redis.port}") int redisPort,
      @Value("${spring.redis.host}") String redisHost) {
    this.redisPort = redisPort;
    this.redisHost = redisHost;
  }
}

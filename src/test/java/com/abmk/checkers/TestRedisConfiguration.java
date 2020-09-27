package com.abmk.checkers;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.data.redis.connection.RedisServer;


/**
 * Project: Checkers
 *
 * Created on: 27.09.2020
 *
 * Author    : Mateusz Paprocki
 *
 * Copyright 2020 (C) Si-eCommerce sp. z o.o.
 */

@TestConfiguration
public class TestRedisConfiguration {

  private final RedisServer redisServer;

  public TestRedisConfiguration(final RedisProperties redisProperties) {
    this.redisServer = new RedisServer("localhost", 6379);
  }
}

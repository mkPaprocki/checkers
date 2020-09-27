package com.abmk.checkers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

/**
 * Project: Checkers
 *
 * Created on: 27.09.2020
 *
 * Author    : Mateusz Paprocki
 *
 */
@Configuration
@EnableRedisRepositories
public class RedisConfiguration {

  @Bean
  public LettuceConnectionFactory redisConnectionFactory(
      RedisProperties redisProperties) {
    //TODO change so configuration is loaded either from file or server
    return new LettuceConnectionFactory(
        "localhost",
        6379);
  }

  @Bean
  public RedisTemplate<?, ?> redisTemplate(LettuceConnectionFactory connectionFactory) {
    RedisTemplate<byte[], byte[]> template = new RedisTemplate<>();
    template.setConnectionFactory(connectionFactory);
    return template;
  }
}

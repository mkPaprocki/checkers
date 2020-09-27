package com.abmk.checkers;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.abmk.checkers.repository.User;
import com.abmk.checkers.repository.UserRepository;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * Project: Checkers
 *
 * Created on: 27.09.2020
 *
 * Author    : Mateusz Paprocki
 *
 * Copyright 2020 (C) Si-eCommerce sp. z o.o.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestRedisConfiguration.class)
public class UserRepositoryIntegrationTest {

  @Autowired
  private UserRepository userRepository;

  @Test
  public void shouldSaveUser_toRedis() {
    UUID id = UUID.randomUUID();
    User user = new User(id, "name");

    User saved = userRepository.save(user);

    assertNotNull(saved);
  }
}

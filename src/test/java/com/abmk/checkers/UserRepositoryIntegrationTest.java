package com.abmk.checkers;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.abmk.checkers.repository.User;
import com.abmk.checkers.repository.UserRepository;
import java.util.Optional;
import java.util.UUID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Project: Checkers
 *
 * Created on: 08.10.2020
 *
 * Author    : Mateusz Paprocki
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryIntegrationTest {

  @Autowired
  UserRepository userRepository;

  @Test
  public void testUser() {
    String uuid = UUID.randomUUID().toString();
    User user = new User(uuid, "Ziomek");
    userRepository.save(user);
    Optional<User> user1 = userRepository.findById(uuid);
    assertEquals(user1.get().getId(), user.getId());
  }
}

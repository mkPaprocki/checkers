package com.abmk.checkers.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

/**
 * Project: Checkers
 *
 * Created on: 16.09.2020
 *
 * Author    : Mateusz Paprocki
 *
 */
@RedisHash("checker")
@Data
@AllArgsConstructor
public class Piece {

  private String id;

}

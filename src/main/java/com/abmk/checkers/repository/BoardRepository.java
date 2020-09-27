package com.abmk.checkers.repository;

import com.abmk.checkers.domain.Board;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

/**
 * Project: Checkers
 *
 * Created on: 27.09.2020
 *
 * Author    : Mateusz Paprocki
 *
 */
public interface BoardRepository extends CrudRepository<Board, UUID> {

}

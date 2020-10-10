package com.abmk.checkers.repository;


import com.abmk.checkers.domain.Board;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Project: Checkers
 *
 * Created on: 27.09.2020
 *
 * Author    : Mateusz Paprocki
 */
@Repository
public interface BoardRepository extends MongoRepository<Board, String> {
  List<Board> findBySize(int size);
}

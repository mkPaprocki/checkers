package com.abmk.checkers.repository;

/**
 * Project: Checkers
 *
 * Created on: 27.09.2020
 *
 * Author    : Mateusz Paprocki
 *
 */

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {

}
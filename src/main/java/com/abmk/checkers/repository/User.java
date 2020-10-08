package com.abmk.checkers.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document (collation = "user")
@AllArgsConstructor
public class User {
  @Id
  private String id;
  private String name;
}
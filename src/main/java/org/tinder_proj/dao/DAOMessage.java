package org.tinder_proj.dao;

import org.tinder_proj.entity.Message;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class DAOMessage implements DAO<Message> {
  private final Connection CONNECTION;

  public DAOMessage(Connection connection) {
    this.CONNECTION = connection;
  }


  @Override
  public List<Message> getAll() {
    return null;
  }

  @Override
  public List<Message> getBy(Predicate<Message> p) {
    return null;
  }

  @Override
  public Optional<Message> get(int id) {
    return Optional.empty();
  }

  @Override
  public void insert(Message message) {

  }

  @Override
  public void delete(int id) {

  }

  @Override
  public void update(Message message) {

  }
}

package org.tinder_proj.dao;

import org.tinder_proj.entity.User;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class DAOUser implements DAO<User> {
  private final Connection CONNECTION;

  public DAOUser(Connection connection) {
    this.CONNECTION = connection;
  }

  @Override
  public List<User> getAll() {
    return null;
  }

  @Override
  public List<User> getBy(Predicate<User> p) {
    return null;
  }

  @Override
  public Optional<User> get(int id) {
    return Optional.empty();
  }

  @Override
  public void insert(User user) {

  }

  @Override
  public void delete(int id) {

  }

  @Override
  public void update(User user) {

  }
}

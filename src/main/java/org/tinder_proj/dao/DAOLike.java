package org.tinder_proj.dao;

import org.tinder_proj.entity.Like;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class DAOLike implements DAO<Like> {
  private final Connection CONNECTION;

  public DAOLike(Connection connection) {
    this.CONNECTION = connection;
  }


  @Override
  public List<Like> getAll() {
    return null;
  }

  @Override
  public List<Like> getBy(Predicate<Like> p) {
    return null;
  }

  @Override
  public Optional<Like> get(int id) {
    return Optional.empty();
  }

  @Override
  public void insert(Like like) {

  }

  @Override
  public void delete(int id) {

  }

  @Override
  public void update(Like like) {

  }
}

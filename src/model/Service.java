package model;

import javafx.geometry.Pos;

import java.util.List;

public interface Service <T> {
    List<T> get();
    T get(long id);
    boolean add(T entity);
    boolean delete(long id);
    boolean edit(long id, T entity);
}

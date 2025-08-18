package dao;

import model.Cake;

import java.util.List;

public interface CakeDAO {
    List<Cake> getAll();

    void add(Cake c);

    void update(Cake c);

    void delete(String id);

    List<Cake> findByName(String keyword);

    void loadFromFile();

    void saveToFile();
}

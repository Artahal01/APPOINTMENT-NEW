package springboot.interfaces;

import java.sql.SQLException;
import java.util.List;

import springboot.model.Place;

public interface PlaceDAOInterface {
    void insert(Place toInsert) throws SQLException;
    List<Place> getAll() throws SQLException;
    List<Place> getById(int id);
    void update(Place toUpdate) throws SQLException;
    void delete(int id) throws SQLException;
}
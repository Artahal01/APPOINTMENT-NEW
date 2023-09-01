package springboot.interfaces;

import java.sql.SQLException;
import java.util.List;

import springboot.model.Rdv;

public interface RdvDAOInterface {
    void insert(Rdv toInsert) throws SQLException;
    List<Rdv> getAll() throws SQLException;
    List<Rdv> getById(int id);
    void update(Rdv toUpdate) throws SQLException;
    void delete(int id) throws SQLException;
}

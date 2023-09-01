package springboot.interfaces;

import java.sql.SQLException;
import java.util.List;

import springboot.model.Client;

public interface ClientDAOInterface {
    void insert(Client toInsert) throws SQLException;
    List<Client> getAll() throws SQLException;
    List<Client> getById(int id);
    void update(Client toUpdate) throws SQLException;
    void delete(int id) throws SQLException;
}

package springboot.service;

import org.springframework.stereotype.Service;

import springboot.model.Client;
import springboot.repository.ClientDAO;

import java.sql.SQLException;
import java.util.List;

@Service
public class ClientService {
    private ClientDAO dao;

    public ClientService(ClientDAO dao) {
        this.dao = dao;
    }

    public List<Client> getAllClients() throws SQLException {
        return dao.getAll();
    }

    public List<Client> getClientById(int id) {
        return dao.getById(id);
    }

    public void insertClient(Client client) throws SQLException {
        dao.insert(client);
    }

    public void updateClient(Client client) throws SQLException {
        dao.update(client);
    }

    public void deleteClient(int id) throws SQLException {
        dao.delete(id);
    }
}

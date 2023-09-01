package springboot.repository;

import org.springframework.stereotype.Repository;

import springboot.interfaces.ClientDAOInterface;
import springboot.model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ClientDAO implements ClientDAOInterface {
    private Connection connection;

    public ClientDAO(Connection connection) {
        this.connection = connection;
    }

    //INSERER DES CLIENTS
    @Override
    public void insert(Client toInsert) throws SQLException {
        String sql = "INSERT INTO client (id_client, name, phone_number, address, email, password) VALUES (?, ?, ?, ?, ?, ?);";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, toInsert.getName());
            preparedStatement.setString(2, toInsert.getPhone_number());
            preparedStatement.setString(3, toInsert.getAddress());
            preparedStatement.setString(4, toInsert.getEmail());
            preparedStatement.setString(5, toInsert.getPassword());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //AFFICHER TOUS LES CLIENTS
    @Override
    public List<Client> getAll() throws SQLException {
        List<Client> allClients = new ArrayList<>();
        String sql = "SELECT * FROM client";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                convertToList(allClients, result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allClients;
    }

    //AFFICHER UN CLIENT EN LE RETROUVANT PAS SON ID
    @Override
    public List<Client> getById(int id) {
        List<Client> allClients = new ArrayList<>();
        String sql = "SELECT * FROM client WHERE id_client = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                convertToList(allClients, result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allClients;
    }

    //METTRE A JOUR LES VALEURS DE LA TABLE CLIENT
    @Override
    public void update(Client toUpdate) throws SQLException {
        String sql = "UPDATE client SET name = ?, phone_number = ?, address = ?, email = ?, password = ? WHERE id_client = ?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, toUpdate.getName());
            preparedStatement.setString(2, toUpdate.getPhone_number());
            preparedStatement.setString(3, toUpdate.getAddress());
            preparedStatement.setString(4, toUpdate.getEmail());
            preparedStatement.setString(5, toUpdate.getPassword());
            preparedStatement.setInt(6, toUpdate.getId_client());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Supprimer un CLIENT
    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM client WHERE id_client = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void convertToList(List<Client> allClients, ResultSet result) throws SQLException {
        allClients.add(new Client(
                result.getInt("id_client"),
                result.getString("name"),
                result.getString("phone_number"),
                result.getString("address"),
                result.getString("email"),
                result.getString("password")));
    }

}

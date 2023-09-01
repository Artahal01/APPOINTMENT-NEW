package springboot.repository;

import org.springframework.stereotype.Repository;

import springboot.interfaces.PlaceDAOInterface;
import springboot.model.Place;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PlaceDAO implements PlaceDAOInterface {
    private Connection connection;

    public PlaceDAO(Connection connection) {
        this.connection = connection;
    }

    // INSERER DES PLACES
    @Override
    public void insert(Place toInsert) throws SQLException {
        String sql = "INSERT INTO place (id_place, place_name, address) VALUES (?, ?, ?);";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, toInsert.getId_place());
            preparedStatement.setString(2, toInsert.getPlace_name());
            preparedStatement.setString(3, toInsert.getAddress());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // AFFICHER TOUTES LES PLACES
    @Override
    public List<Place> getAll() throws SQLException {
        List<Place> allPlaces = new ArrayList<>();
        String sql = "SELECT * FROM place";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                convertPlaceToList(allPlaces, result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allPlaces;
    }

    // AFFICHER UNE PLACE EN LA RETROUVANT PAR SON ID
    @Override
    public List<Place> getById(int id) {
        List<Place> allPlaces = new ArrayList<>();
        String sql = "SELECT * FROM place WHERE id_place = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                convertPlaceToList(allPlaces, result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allPlaces;
    }

    // METTRE A JOUR LES VALEURS DE LA TABLE PLACE
    @Override
    public void update(Place toUpdate) throws SQLException {
        String sql = "UPDATE place SET place_name = ?, address = ? WHERE id_place = ?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, toUpdate.getPlace_name());
            preparedStatement.setString(2, toUpdate.getAddress());
            preparedStatement.setInt(3, toUpdate.getId_place());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Supprimer une Place
    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM place WHERE id_place = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void convertPlaceToList(List<Place> allPlaces, ResultSet result) throws SQLException {
        allPlaces.add(new Place(
                result.getInt("id_place"),
                result.getString("place_name"),
                result.getString("address")));
    }
}

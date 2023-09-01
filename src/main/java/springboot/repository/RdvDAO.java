package springboot.repository;

import org.springframework.stereotype.Repository;

import springboot.interfaces.RdvDAOInterface;
import springboot.model.Rdv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RdvDAO implements RdvDAOInterface {
    private Connection connection;

    public RdvDAO(Connection connection) {
        this.connection = connection;
    }

    // INSERER DES RDVS
    @Override
    public void insert(Rdv toInsert) throws SQLException {
        String sql = "INSERT INTO rdv (id_appointment, appointment_request, appointment_date, description, id_client, id_place) VALUES (?, ?, ?, ?, ?, ?);";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, toInsert.getId_appointment());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(toInsert.getAppointment_request()));
            preparedStatement.setTimestamp(3, Timestamp.valueOf(toInsert.getAppointment_date()));
            preparedStatement.setString(4, toInsert.getDescription());
            preparedStatement.setInt(5, toInsert.getId_client());
            preparedStatement.setInt(6, toInsert.getId_place());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // AFFICHER TOUS LES RDVS
    @Override
    public List<Rdv> getAll() throws SQLException {
        List<Rdv> allRdvs = new ArrayList<>();
        String sql = "SELECT * FROM rdv";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                convertAppointmentToList(allRdvs, result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allRdvs;
    }

    // AFFICHER UN RDV EN LE RETROUVANT PAS SON ID
    @Override
    public List<Rdv> getById(int id) {
        List<Rdv> allRdvs = new ArrayList<>();
        String sql = "SELECT * FROM rdv WHERE id_appointment = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                convertAppointmentToList(allRdvs, result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allRdvs;
    }

    // METTRE A JOUR LES VALEURS DE LA TABLE RDV
    @Override
    public void update(Rdv appointmentToUpdate) throws SQLException {
        String sql = "UPDATE rdv SET appointment_request = ?, appointment_date = ?, description = ?, id_client = ?, id_place = ? WHERE id_appointment = ?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setTimestamp(1, Timestamp.valueOf(appointmentToUpdate.getAppointment_request()));
            preparedStatement.setTimestamp(2, Timestamp.valueOf(appointmentToUpdate.getAppointment_date()));
            preparedStatement.setString(3, appointmentToUpdate.getDescription());
            preparedStatement.setInt(4, appointmentToUpdate.getId_client());
            preparedStatement.setInt(5, appointmentToUpdate.getId_place());
            preparedStatement.setInt(6, appointmentToUpdate.getId_appointment());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Supprimer une RDV
    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM rdv WHERE id_appointment = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void convertAppointmentToList(List<Rdv> allAppointments, ResultSet result) throws SQLException {
        allAppointments.add(new Rdv(
                result.getInt("id_appointment"),
                result.getTimestamp("appointment_request").toLocalDateTime(),
                result.getTimestamp("appointment_date").toLocalDateTime(),
                result.getString("description"),
                result.getInt("id_client"),
                result.getInt("id_place")));
    }

}

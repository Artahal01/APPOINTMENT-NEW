package springboot.service;

import org.springframework.stereotype.Service;

import springboot.model.Place;
import springboot.repository.PlaceDAO;

import java.sql.SQLException;
import java.util.List;

@Service
public class PlaceService {
    private PlaceDAO dao;

    public PlaceService(PlaceDAO dao) {
        this.dao = dao;
    }

    public List<Place> getAllPlaces() throws SQLException {
        return dao.getAll();
    }

    public List<Place> getPlaceById(int id) {
        return dao.getById(id);
    }

    public void insertPlace(Place place) throws SQLException {
        dao.insert(place);
    }

    public void updatePlace(Place place) throws SQLException {
        dao.update(place);
    }

    public void deletePlace(int id) throws SQLException {
        dao.delete(id);
    }
}

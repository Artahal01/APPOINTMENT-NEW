package springboot.controller;

import springboot.model.Place;
import springboot.service.PlaceService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
public class PlaceController {
    private PlaceService service;

    public PlaceController(PlaceService service) {
        this.service = service;
    }

    @GetMapping("/places")
    public List<Place> getAllPlaces() throws SQLException {
        return service.getAllPlaces();
    }

    @GetMapping("/places/{id}")
    public List<Place> getPlaceById(@PathVariable int id) {
        return service.getPlaceById(id);
    }

    @PostMapping("/places")
    public void insertPlace(@RequestBody Place place) throws SQLException {
        service.insertPlace(place);
    }

    @PutMapping("/place/update/{id}")
    public void updatePlace(@PathVariable int id, @RequestBody Place place) throws SQLException {
        place.setId_place(id);
        service.updatePlace(place);
    }

    @DeleteMapping("/place/delete/{id}")
    public void deletePlace(@PathVariable int id) throws SQLException {
        service.deletePlace(id);
    }
}

package springboot.controller;

import springboot.model.Rdv;
import springboot.service.RdvService;

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
public class RdvController {
    private RdvService service;

    public RdvController(RdvService service) {
        this.service = service;
    }

    //Afficher tous les rdvs
    @GetMapping("/rdvs")
    public List<Rdv> getAllRdvs() throws SQLException {
        return service.getAllRdvs();
    }

    //Afficher un rdv grace à son ID
     @GetMapping("/rdvs/{id}")
    public List<Rdv> getRdvById(@PathVariable int id) {
        return service.getRdvById(id);
    }

    //Inserer un rdv
    @PostMapping("/rdvs")
    public void insertRdv (@RequestBody Rdv rdv) throws SQLException {
        service.insertRdv (rdv);
    }

    //Mettre à jour un rdv
    @PutMapping("/rdv/update/{id}")
    public void updateRdv(@PathVariable int id, @RequestBody Rdv rdv) throws SQLException {
        rdv.setId_appointment(id);
        service.updateRdv(rdv);
    }

    //Supprimer un rdv
     @DeleteMapping("/rdv/delete/{id}")
    public void deleteRdv(@PathVariable int id) throws SQLException {
        service.deleteRdv(id);
    }
}

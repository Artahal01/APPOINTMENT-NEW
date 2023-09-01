package springboot.controller;

import springboot.model.Client;
import springboot.service.ClientService;

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
public class ClientController {
    private ClientService service;

    public ClientController(ClientService service) {
        System.out.println("Appel du constructeur de controller");
        this.service = service;
    }

    //Afficher tous les clients
    @GetMapping("/clients")
    public List<Client> getAllClients() throws SQLException {
        return service.getAllClients();
    }

    //Afficher un client grace à son ID
     @GetMapping("/clients/{id}")
    public List<Client> getClientById(@PathVariable int id) {
        return service.getClientById(id);
    }

    //Inserer un client
    @PostMapping("/clients")
    public void insertClient(@RequestBody Client client) throws SQLException {
        service.insertClient(client);
    }

    //Mettre à jour un client
    @PutMapping("/client/update/{id}")
    public void updateClient(@PathVariable int id, @RequestBody Client client) throws SQLException {
        client.setId_client(id);
        service.updateClient(client);
    }

    //Supprimer un client
     @DeleteMapping("/client/delete/{id}")
    public void deleteClient(@PathVariable int id) throws SQLException {
        service.deleteClient(id);
    }
}

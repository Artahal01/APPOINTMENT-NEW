package springboot.service;

import org.springframework.stereotype.Service;

import springboot.model.Rdv;
import springboot.repository.RdvDAO;

import java.sql.SQLException;
import java.util.List;

@Service
public class RdvService {
    private RdvDAO dao;

    public RdvService(RdvDAO dao) {
        this.dao = dao;
    }

    public List<Rdv> getAllRdvs() throws SQLException {
        return dao.getAll();
    }

    public List<Rdv> getRdvById(int id) {
        return dao.getById(id);
    }

    public void insertRdv(Rdv rdv) throws SQLException {
        dao.insert(rdv);
    }

    public void updateRdv(Rdv rdv) throws SQLException {
        dao.update(rdv);
    }

    public void deleteRdv(int id) throws SQLException {
        dao.delete(id);
    }
}

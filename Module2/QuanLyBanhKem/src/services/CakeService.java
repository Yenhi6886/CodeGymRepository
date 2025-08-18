package services;

import dao.CakeDAO;
import model.Cake;

import java.util.List;

public class CakeService {
    private CakeDAO cakeDAO;

    public CakeService(CakeDAO dao) {
        this.cakeDAO = dao;
        dao.loadFromFile();
    }

    public List<Cake> listAll() {
        return cakeDAO.getAll();
    }

    public void addCake(Cake c) {
        cakeDAO.add(c);
        cakeDAO.saveToFile();
    }

    public void updateCake(Cake c) {
        cakeDAO.update(c);
        cakeDAO.saveToFile();
    }

    public void deleteCake(String id) {
        cakeDAO.delete(id);
        cakeDAO.saveToFile();
    }

    public List<Cake> search(String kw) {
        return cakeDAO.findByName(kw);
    }

    public Cake getCakeById(String id) {
        for (Cake c : cakeDAO.getAll()) if (c.getId().equals(id)) return c;
        return null;
    }
}
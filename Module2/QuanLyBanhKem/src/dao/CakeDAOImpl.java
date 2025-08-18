package dao;

import model.Cake;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CakeDAOImpl implements CakeDAO {
    private List<Cake> cakes = new ArrayList<>();
    private final String filePath = "cakes.txt";

    @Override
    public void loadFromFile() {
        cakes.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                cakes.add(Cake.fromCSV(line));
            }
        } catch (IOException e) {
            // File chưa tồn tại, sẽ tạo khi lưu
        }
    }

    @Override
    public void saveToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filePath))) {
            for (Cake c : cakes) {
                pw.println(c.toCSV());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Cake> getAll() {
        return cakes;
    }

    @Override
    public void add(Cake c) {
        cakes.add(c);
    }

    @Override
    public void update(Cake c) {
        delete(c.getId());
        cakes.add(c);
    }

    @Override
    public void delete(String id) {
        cakes.removeIf(c -> c.getId().equals(id));
    }

    @Override
    public List<Cake> findByName(String kw) {
        List<Cake> res = new ArrayList<>();
        for (Cake c : cakes) {
            if (c.getName().toLowerCase().contains(kw.toLowerCase())) res.add(c);
        }
        return res;
    }
}
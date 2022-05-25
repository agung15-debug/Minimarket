package dao;

import model.Kategori;
import java.util.List;

public interface interfaceKategori {
     public void insert(Kategori kategori);

    public void update(Kategori kategori);

    public void delete(int id);

    public List<Kategori> getData();
}

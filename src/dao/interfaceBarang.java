package dao;

import model.Barang;
import model.Kategori;
import java.util.List;
import java.util.ArrayList;

public interface interfaceBarang {
    public void insert(Barang barang);
    public void update(Barang barang);
    public void delete(int id);
    public List<Barang> getData();
    public ArrayList<String> getKategori();
}

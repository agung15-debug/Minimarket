package dao;

import model.Barang;
import java.util.List;

public interface interfaceBarang {
    public void insert(Barang barang);
    public void update(Barang barang);
    public void delete(int id);
    public List<Barang> getData();
}

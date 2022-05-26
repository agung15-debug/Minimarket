package dao;

import model.Pegawai;
import java.util.List;
import java.sql.*;

public interface interfacePegawai {
    public void insert(Pegawai kUser);

    public void update(Pegawai kUser);

    public void delete(int id);
    
    public Pegawai loadUser(String username);
    
    public List<Pegawai> getData();
}

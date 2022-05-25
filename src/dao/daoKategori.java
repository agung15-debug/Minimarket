package dao;

import controller.ConnectorMinimarket;
import model.Kategori;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class daoKategori implements interfaceKategori{
    Connection connection;
    final String insert ="INSERT INTO `kategori` (nama_kategori) VALUES (?);";
    final String update ="UPDATE kategori SET nama_kategori=? WHERE id_kategori=?;";
    final String delete = "DELETE FROM kategori WHERE id_kategori =?;";
    final String select ="SELECT * FROM kategori ORDER BY id_kategori ASC;";

    public daoKategori() {
        connection = ConnectorMinimarket.connection();
    }

    
    @Override
    public void insert(Kategori kategori) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1, kategori.getNamaKategori());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(Kategori kategori) {
         PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, kategori.getNamaKategori());
            statement.setInt(2, kategori.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<Kategori> getData() {
       List<Kategori> listKategori = null;
        try {
            listKategori = new ArrayList<Kategori>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                Kategori kategori = new Kategori();
                kategori.setId(rs.getInt("id_kategori"));
                kategori.setNamaKategori(rs.getString("nama_kategori"));
                listKategori.add(kategori);
            }
        } catch (SQLException ex) {
            Logger.getLogger(daoKategori.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listKategori;
    }
}

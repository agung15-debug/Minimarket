package dao;

import controller.ConnectorMinimarket;
import model.Barang;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class daoBarang implements interfaceBarang{
    Connection connection;
    final String insert = "INSERT INTO `barang` (nama_barang, id_kategori, deskripsi, stok, harga) VALUES (?,?,?,?,?);";
    final String update = "UPDATE barang SET nama_barang=?, id_kategori=?, deskripsi =?, stok=?, harga=? WHERE id_barang=?;";
    final String delete = "DELETE FROM barang WHERE id_barang = ?;";
    final String select = "SELECT barang.*, kategori.nama_kategori FROM `barang` INNER JOIN kategori ON barang.id_kategori = kategori.id_kategori ORDER BY id_barang DESC";

    public daoBarang(){
        connection = ConnectorMinimarket.connection();
    }
    public void insert(Barang barang){
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1, barang.getNamaBarang());
            statement.setInt(2, barang.getKategori());
            statement.setString(3, barang.getDeskripsi());
            statement.setInt(5, barang.getStok());
            statement.setInt(5, barang.getHarga());
            statement.executeUpdate();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        finally{
            try {
                statement.close();
            }
            catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(Barang barang) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, barang.getNamaBarang());
            statement.setInt(2, barang.getKategori());
            statement.setString(3, barang.getDeskripsi());
            statement.setInt(5, barang.getStok());
            statement.setInt(5, barang.getHarga());
            statement.setInt(6, barang.getId());
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
    public List<Barang> getData() {
        List<Barang> listBarang = null;
        try{
            listBarang = new ArrayList<Barang>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                Barang barang = new Barang();
                barang.setId(rs.getInt("id_barang"));
                barang.setNamaBarang(rs.getString("nama_barang"));
                barang.setKategori(rs.getInt("id_kategori"));
                barang.setDeskripsi(rs.getString("deskripsi"));
                barang.setStok(rs.getInt("stok"));
                barang.setHarga(rs.getInt("harga"));
                barang.setnKategori(rs.getString("nama_kategori"));
                listBarang.add(barang);
            }
        }
        catch (SQLException ex){
            Logger.getLogger(daoBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listBarang;
    }
}

package dao;

import controller.ConnectorMinimarket;
import model.Pegawai;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class daoPegawai implements interfacePegawai{
    Connection connection;
    final String insert = "INSERT INTO `pegawai` (`username`, `password`, `nama_pegawai`, `no_hp`, `alamat`, `role`) VALUES (?, ?, ?, ?,?, ?); ";
    final String update = "UPDATE `pegawai` SET `username`=?,`password`=?,`nama_pegawai`=?,`no_hp`=?,`alamat`=?,`role`=? WHERE id_pegawai= ?;";
    final String delete = "DELETE FROM `pegawai` WHERE id_pegawai=?;";
    final String selectUser = "SELECT * FROM `pegawai` WHERE username=?;";
    final String select = "SELECT * FROM `pegawai` ORDER BY username ASC;";

    public daoPegawai() {
        connection = ConnectorMinimarket.connection();
    }
  
    @Override
    public void insert(Pegawai kUser) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1, kUser.getUsername());
            statement.setString(2, kUser.getPassword());
            statement.setString(3, kUser.getNamaPegawai());
            statement.setString(4, kUser.getNoHp());
            statement.setString(5, kUser.getAlamat());
            statement.setInt(6,kUser.getPrivilage());
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
    public void update(Pegawai kUser) {
       PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, kUser.getUsername());
            statement.setString(2, kUser.getPassword());
            statement.setString(3, kUser.getNamaPegawai());
            statement.setString(4, kUser.getNoHp());
            statement.setString(5, kUser.getAlamat());
            statement.setInt(6,kUser.getPrivilage());
            statement.setInt(7, kUser.getId());
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
    public Pegawai loadUser(String username) {
        PreparedStatement statement = null;
        Pegawai kUser = new Pegawai();
        try {
             statement = connection.prepareStatement(selectUser);
             statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
            kUser.setId(rs.getInt("id_pegawai"));
            kUser.setUsername(rs.getString("username"));
            kUser.setPassword(rs.getString("password"));
            kUser.setNamaPegawai(rs.getString("nama_pegawai"));
            kUser.setNoHp(rs.getString("no_hp"));
            kUser.setAlamat(rs.getString("alamat"));
            kUser.setPrivilage(rs.getInt("role"));
        }
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return kUser;
    }

    @Override
    public List<Pegawai> getData() {
        List<Pegawai> listUser = null;
        try {
            listUser = new ArrayList<Pegawai>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                Pegawai kUser = new Pegawai();
                kUser.setId(rs.getInt("id_pegawai"));
                kUser.setUsername(rs.getString("username"));
                kUser.setPassword(rs.getString("password"));
                kUser.setNamaPegawai(rs.getString("nama_pegawai"));
                kUser.setNoHp(rs.getString("no_hp"));
                kUser.setAlamat(rs.getString("alamat"));
                kUser.setnPrivilage(rs.getInt("role"));
                listUser.add(kUser);
            }
        } catch (SQLException ex) {
            Logger.getLogger(daoPegawai.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listUser;
    }
}

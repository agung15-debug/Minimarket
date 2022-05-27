/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import controller.ConnectorMinimarket;
import model.Order;
import model.Pegawai;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class daoOrder implements interfaceOrder{
    Connection connection;
    final String insert = "INSERT INTO `order` (id_pegawai) VALUES (?);";
    final String update = "UPDATE order SET id_pegawai=? WHERE id_order=?;";
    final String delete = "DELETE FROM order WHERE id_order=?;";
    final String select = "SELECT order.id_pegawai, pegawai.id_pegawai FROM `order` INNER JOIN pegawai ON order.id_pegawai = pegawai.id_pegawai ORDER BY id_order DESC;";
                          
    public daoOrder() {
        connection = ConnectorMinimarket.connection();
    }

    @Override
    public void insert(Pegawai pegawai) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert);
            statement.setInt(1, pegawai.getId());
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

    public void update(Order order) {
         PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setInt(1, order.getIdPegawai());
            statement.setInt(2, order.getIdOrder());
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
    public List<Order> getData() {
       List<Order> listOrder = null;
        try {
            listOrder = new ArrayList<Order>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                Order order = new Order();
                order.setIdOrder(rs.getInt("id_order"));
                order.setIdPegawai(rs.getInt("id_pegawai"));
                listOrder.add(order);
            }
        } catch (SQLException ex) {
            Logger.getLogger(daoKategori.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listOrder;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import controller.ConnectorMinimarket;
import model.OrderDetail;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class daoOrderDetail implements interfaceOrderDetail{
    Connection connection;
    final String insert = "INSERT INTO `order_detail` (id_order, id_barang, jumlah, total) VALUES (?,?,?,?);";
    final String update = "UPDATE order_detail SET jumlah=?, total=? WHERE id_detail=?;";
    final String delete = "DELETE FROM order_detail WHERE id_detail = ?;";
    final String select = "SELECT order_detail.*, barang.nama_barang, `order`.id_pegawai, pegawai.nama_pegawai FROM order_detail INNER JOIN `order` ON order_detail.id_order = `order`.`id_order` INNER JOIN barang ON order_detail.id_barang = barang.id_barang INNER JOIN pegawai ON `order`.`id_pegawai` = pegawai.id_pegawai ORDER BY id_detail ASC;";
   // final String select = "SELECT * FROM order_detail";
    
    public daoOrderDetail() {
        this.connection = ConnectorMinimarket.connection();
    }

    @Override
    public void insert(OrderDetail orderdetail) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert);
        //    statement.setInt(1, orderdetail.getIdDetail());
            statement.setInt(1, orderdetail.getIdOrder());
            statement.setInt(2, orderdetail.getIdBarang());
            statement.setInt(3, orderdetail.getJumlah());
            statement.setInt(4, orderdetail.getTotal());
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
    public void update(OrderDetail orderdetail) {
         PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
        //    statement.setInt(1, orderdetail.getIdDetail());
            statement.setInt(1, orderdetail.getIdOrder());
            statement.setInt(2, orderdetail.getIdBarang());
            statement.setInt(3, orderdetail.getJumlah());
            statement.setInt(4, orderdetail.getTotal());
            statement.setInt(5, orderdetail.getIdDetail());
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
    public List<OrderDetail> getData() {
       List<OrderDetail> listOrderDetail = null;
        try {
            listOrderDetail = new ArrayList<OrderDetail>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setIdDetail(rs.getInt("id_detail"));
                orderDetail.setIdOrder(rs.getInt("id_order"));
                orderDetail.setIdBarang(rs.getInt("id_barang"));
                orderDetail.setJumlah(rs.getInt("jumlah"));
                orderDetail.setTotal(rs.getInt("total"));
                orderDetail.setNamaBarang(rs.getString("nama_barang"));
                orderDetail.setIdPegawai(rs.getInt("id_pegawai"));
                orderDetail.setNamaPegawai(rs.getString("nama_pegawai"));
                listOrderDetail.add(orderDetail);
            }
        } catch (SQLException ex) {
            Logger.getLogger(daoKategori.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listOrderDetail;
    }
}

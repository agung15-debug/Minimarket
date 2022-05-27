/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import model.Order;
import model.Pegawai;
import java.util.List;

public interface interfaceOrder {
    public void insert(Pegawai pegawai);

    public void update(Order order);

    public void delete(int id);

    public List<Order> getData();

    //public void insert(Order order, int idPegawai);
}

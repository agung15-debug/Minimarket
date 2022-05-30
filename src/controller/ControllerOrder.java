/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.swing.JOptionPane;
import java.util.List;
import dao.daoOrder;
import dao.interfaceOrder;
import model.Order;
import model.Pegawai;
import model.tableModelOrder;
import view.kasirUtama;
import view.viewOrder;
import view.detailListOrder;

public class ControllerOrder {
    viewOrder frame;
    interfaceOrder infcOrder;
    Pegawai pegawai;
    int id;
    List<Order> list_order;
    
    public ControllerOrder(viewOrder frame) {
        this.frame = frame;
        infcOrder = new daoOrder();
        list_order = infcOrder.getData();
    }
    
    public void Order(Pegawai arg){
        Order order = new Order();
        pegawai = arg;
        order.setIdPegawai(frame.getId());
        infcOrder.insert(order);
        JOptionPane.showMessageDialog(frame, "Berhasil membuat pesanan baru");
        restart(pegawai);
    }
    public void loadTable(){
        tableModelOrder tmo = new tableModelOrder(list_order);
        frame.getOrder().setModel(tmo);
    }
    
    public void restart(Pegawai pegawai){
        frame.dispose();
        new viewOrder(pegawai).setVisible(true);
    }
    public void kembali(Pegawai pegawai){
         frame.dispose();
        new kasirUtama(pegawai).setVisible(true);
    }
    public void halamanDetail(int row, Pegawai pegawai){
        Order order = list_order.get(row);
        frame.dispose();
        new detailListOrder(order, pegawai).setVisible(true);
    }
}

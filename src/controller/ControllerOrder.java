/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.swing.JOptionPane;
import dao.daoOrder;
import dao.interfaceOrder;
import model.Order;
import model.Pegawai;
import view.kasirUtama;

public class ControllerOrder {
    kasirUtama frame;
    interfaceOrder infcOrder;

    public ControllerOrder(kasirUtama frame) {
        this.frame = frame;
        infcOrder = new daoOrder();
    }
    
    public void Order(Pegawai pegawai){
        Order order = new Order();
        order.setIdPegawai(pegawai.getId());
        infcOrder.insert(order);
        JOptionPane.showMessageDialog(frame, "Berhasil membuat pesanan baru");
        kembali();
    }
    
    public void kembali(){
         frame.dispose();
        new kasirUtama().setVisible(true);
    }
}

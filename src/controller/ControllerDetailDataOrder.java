/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.daoOrderDetail;
import dao.interfaceOrderDetail;
import javax.swing.JOptionPane;
import model.Pegawai;
import model.OrderDetail;
import view.detailDataOrder;
import view.viewOrderDetail;

public class ControllerDetailDataOrder {
    detailDataOrder frame;
    interfaceOrderDetail infcOrderDetail;
    Pegawai pegawai;
    
    public ControllerDetailDataOrder(detailDataOrder frame) {
        this.frame = frame;
        infcOrderDetail = new daoOrderDetail();
    }

    public void tampilkanData(OrderDetail orderDetail){
        frame.setIdDetail(Integer.toString(orderDetail.getIdDetail()));
        frame.setIdOrder(Integer.toString(orderDetail.getIdOrder()));
        frame.setNamaPegawai(orderDetail.getNamaPegawai());
        frame.setNamaKategori(orderDetail.getNamaKategori());
        frame.setNamaBarang(orderDetail.getNamaBarang());
        frame.setJumlah(orderDetail.getJumlah());
        frame.setTotal(orderDetail.getTotal());
    }
    
    public void kembali(Pegawai pegawai){
        this.pegawai = pegawai;
        frame.dispose();
        new viewOrderDetail(pegawai).setVisible(true);
    }
    
    public void hapusData(int id, Pegawai pegawai){
        infcOrderDetail.delete(id);
        this.pegawai = pegawai;
        kembali(pegawai);
        JOptionPane.showMessageDialog(frame, "Data orderan berhasil dihapus!");
    }
}

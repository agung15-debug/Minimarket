/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.daoOrderDetail;
import dao.interfaceOrderDetail;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.OrderDetail;
import model.Pegawai;
import view.lihatBarang;
import view.tambahOrder;
import view.viewOrderDetail;

public class ControllerTambahOrder {
    tambahOrder frame;
    ArrayList<String> idPegawai;
    ArrayList<String> idOrder;
    ArrayList<String> idBarang;
    interfaceOrderDetail infcOrderDetail;
    lihatBarang lihatbarang;
    Pegawai pegawai;
        
    public ControllerTambahOrder(tambahOrder frame) {
        this.frame = frame;
        infcOrderDetail = new daoOrderDetail();
        idOrder = infcOrderDetail.getIdOrder();
        idBarang = infcOrderDetail.getIdBarang();
        for(int i = 0; i < idOrder.size(); i++){
            this.frame.setIdOrder(idOrder.get(i));
        }
        for(int i = 0; i < idBarang.size(); i++){
            this.frame.setIdBarang(idBarang.get(i));
        }
    }
    public void tambahOrder(Pegawai arg){
        pegawai = arg;
        String id_order = frame.getIdOrder().getSelectedItem().toString();
        String id_barang = frame.getIdBarang().getSelectedItem().toString();
        int jumlah = (int) frame.getJumlah().getValue();
        int harga = (int) frame.getHarga().getValue();
        int total = jumlah*harga;
        if(id_order.equals("")||id_barang.equals("")||jumlah==0){
            JOptionPane.showMessageDialog(frame, "Gagal membuat order baru, tidak boleh ada kolom yang kosong!");
        }else{
            infcOrderDetail.insert(id_order, id_barang, jumlah, total);
            JOptionPane.showMessageDialog(frame, "Berhasil membuat order terbaru");
            kembali(pegawai);
        }
    }
    public void kembali(Pegawai pegawai){
        frame.dispose();
        new viewOrderDetail(pegawai).setVisible(true);
    }
    public void resetForm(Pegawai pegawai){
        frame.setIdOrder(-1);
        frame.setIdBarang(-1);
        frame.setJumlah(0);
        frame.setHarga(0);
    }
    public void lihatBarang(Pegawai pegawai){
        lihatbarang = new lihatBarang();
        lihatbarang.setVisible(true);
    }
}

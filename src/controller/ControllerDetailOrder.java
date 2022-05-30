/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.daoOrderDetail;
import dao.interfaceOrderDetail;
import java.util.List;
import model.OrderDetail;
import model.Pegawai;
import model.tableModelOrderDetail;
import view.detailDataOrder;
import view.viewOrderDetail;
import view.kasirUtama;

public class ControllerDetailOrder {

    viewOrderDetail frame;
    interfaceOrderDetail infcOrderDetail;
    List<OrderDetail> list_orderDetail;
    Pegawai pegawai;
    
    public ControllerDetailOrder(viewOrderDetail frame){
        this.frame = frame;
        infcOrderDetail = new daoOrderDetail();
        list_orderDetail = infcOrderDetail.getData();
    }
    
    public void tampilkanData(){
       tableModelOrderDetail tmod = new tableModelOrderDetail(list_orderDetail);
       frame.getTableOrderDetail().setModel(tmod);
    }
    
    public void kembali(Pegawai pegawai){
        frame.dispose();
        new kasirUtama(pegawai).setVisible(true);
    }
    
    public void halamanDetail(int row, Pegawai args){
        OrderDetail oDetail = list_orderDetail.get(row);
        pegawai = args;
        frame.dispose();
        new detailDataOrder(oDetail, pegawai).setVisible(true);
    }
}

package controller;

import dao.daoOrder;
import dao.interfaceOrder;
import model.Order;
import model.Pegawai;
import view.viewOrder;
import view.detailListOrder;

public class ControllerDetailPerOrder {
    detailListOrder frame;
    interfaceOrder infcOrder;
    Pegawai pegawai;

    public ControllerDetailPerOrder(detailListOrder frame) {
        this.frame = frame;
        infcOrder = new daoOrder();
    }
    public void tampilkanData(Order order){
        frame.setData(Integer.toString(order.getIdOrder()), Integer.toString(order.getIdPegawai()));
    }
    public void kembali(Pegawai args){
        frame.dispose();
        pegawai = args;
        new viewOrder(pegawai).setVisible(true);
    }
    public void hapusData(int id, Pegawai args){
        pegawai = args;
        infcOrder.delete(id);
        kembali(pegawai);
    }
}

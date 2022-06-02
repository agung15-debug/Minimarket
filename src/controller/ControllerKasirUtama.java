package controller;

import dao.interfaceOrder;
import dao.daoOrder;
import view.kasirUtama;
import model.Pegawai;
import view.viewLogin;
import view.viewOrder;
import view.viewOrderDetail;

public class ControllerKasirUtama {
    kasirUtama frame;
    interfaceOrder infcOrder;
    
    public ControllerKasirUtama(kasirUtama frame){
        this.frame = frame;
        infcOrder = new daoOrder();
    }
    
    public void halamanDetail(Pegawai pegawai){
        frame.dispose();
        new viewOrder(pegawai).setVisible(true);
    }
    
    public void halamanOrderDetail(Pegawai pegawai){
        frame.dispose();
        new viewOrderDetail(pegawai).setVisible(true);
    }
    
    public void halamanLogin(){
        frame.dispose();
        new viewLogin().setVisible(true);
    }
}

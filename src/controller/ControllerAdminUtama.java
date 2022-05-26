package controller;

import view.adminUtama;
import view.viewBarang;
import view.viewKategori;
import view.viewLogin;
import view.viewPegawai;

public class ControllerAdminUtama {
    adminUtama frame;
    
    public ControllerAdminUtama(adminUtama frame){
        this.frame = frame;
    }
    public void halamanKelolaBarang(){
        frame.dispose();
        new viewBarang().setVisible(true);
    }
    public void halamanKelolaKategori(){
        frame.dispose();
        new viewKategori().setVisible(true);
    }
    public void halamanKelolaPegawai(){
        frame.dispose();
        new viewPegawai().setVisible(true);
    }
    public void halamanLogin(){
        frame.dispose();
        new viewLogin().setVisible(true);
    }
}

package controller;

import dao.daoPegawai;
import dao.interfacePegawai;
import model.Pegawai;
import view.detailPegawai;
import view.editPegawai;
import view.viewPegawai;

public class ControllerDetailPegawai {
    detailPegawai frame;
    interfacePegawai infcPegawai;

    public ControllerDetailPegawai(detailPegawai frame) {
        this.frame = frame;
        infcPegawai = new daoPegawai();
    }
    
    public void tampilkanData(Pegawai pegawai){
        frame.setOutUsername(pegawai.getUsername());
        frame.setOutPassword(pegawai.getPassword());
        frame.setOutNamaPegawai(pegawai.getNamaPegawai());
        frame.setOutNoHp(pegawai.getNoHp());
        frame.setOutAlamat(pegawai.getAlamat());
        frame.setOutHakAkses(pegawai.getnPrivilage());
    }
    
    public void kembali(){
        frame.dispose();
        new viewPegawai().setVisible(true);
    }
    public void halamanEdit(Pegawai pegawai){
        frame.dispose();
        new editPegawai(pegawai).setVisible(true);
    }
    public void hapusData(int id){
        infcPegawai.delete(id);
        kembali();
    }
}

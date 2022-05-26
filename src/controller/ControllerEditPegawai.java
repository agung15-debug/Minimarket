package controller;

import javax.swing.JOptionPane;
import dao.daoPegawai;
import dao.interfacePegawai;
import model.Pegawai;
import view.editPegawai;
import view.viewPegawai;

public class ControllerEditPegawai {
    editPegawai frame;
    interfacePegawai infcPegawai;

    public ControllerEditPegawai(editPegawai frame) {
        this.frame = frame;
        infcPegawai = new daoPegawai();
    }
    
    public void tampilkanData(Pegawai pegawai){
        frame.setTxtUsername(pegawai.getUsername());
        frame.setTxtPassword(pegawai.getPassword());
        frame.setTxtNamaPegawai(pegawai.getNamaPegawai());
        frame.setTxtNoHp(pegawai.getNoHp());
        frame.setTxtAlamat(pegawai.getAlamat());
        frame.setIndexHakAkses(pegawai.getnPrivilage());
    }
    public void simpanEdit(int id){
        Pegawai pegawai = new Pegawai();
        pegawai.setUsername(frame.getTxtUsername().getText());
        pegawai.setPassword(frame.getTxtPassword().getText());
        pegawai.setNamaPegawai(frame.getTxtNamaPegawai().getText());
        pegawai.setNoHp(frame.getTxtNoHp().getText());
        pegawai.setAlamat(frame.getTxtAlamat().getText());
        pegawai.setPrivilage(frame.getHakAkses());
        pegawai.setId(id);
        infcPegawai.update(pegawai);
        JOptionPane.showMessageDialog(frame, "Berhasil Mengedit Data");
        
        kembali();
    }
    
     public void kembali(){
         frame.dispose();
        new viewPegawai().setVisible(true);
    }
}

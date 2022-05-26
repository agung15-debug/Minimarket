package controller;

import javax.swing.JOptionPane;
import dao.daoPegawai;
import dao.interfacePegawai;
import model.Pegawai;
import view.viewPegawai;
import view.tambahPegawai;
 
public class ControllerTambahPegawai {
    tambahPegawai frame;
    interfacePegawai infcPegawai;

    public ControllerTambahPegawai(tambahPegawai frame) {
        this.frame = frame;
        infcPegawai = new daoPegawai();
    }
    
   public void tambahPegawai(){
       Pegawai pegawai = new Pegawai();
       pegawai.setUsername(frame.gettUsername().getText());
       pegawai.setPassword(frame.gettPassword().getText());
       pegawai.setNamaPegawai(frame.gettNamaPegawai().getText());
       pegawai.setNoHp(frame.gettNoHp().getText());
       pegawai.setAlamat(frame.gettAlamat().getText());
       pegawai.setPrivilage(frame.getHakAkses());
       infcPegawai.insert(pegawai);
       JOptionPane.showMessageDialog(frame, "Berhasil menambahkan pegawai baru");
       kembali();
   }
   public void kembali(){
         frame.dispose();
        new viewPegawai().setVisible(true);
    }
    public void resetForm(){
        frame.settUsername("");
        frame.settPassword("");
        frame.settNamaPegawai("");
        frame.settNoHp("");
        frame.settAlamat("");
        frame.setHakAkses(0);
    }
}

package controller;

import java.util.List;
import javax.swing.JOptionPane;

import dao.daoKategori;
import dao.interfaceKategori;
import model.Kategori;
import view.viewKategori;
import view.tambahKategori;

public class ControllerTambahKategori {
    tambahKategori frame;
    interfaceKategori infcKategori;

    public ControllerTambahKategori(tambahKategori frame) {
        this.frame = frame;
        infcKategori = new daoKategori();
    }
    
    public void tambahKategori(){
        Kategori kategori = new Kategori();
        kategori.setNamaKategori(frame.getNamaKategori().getText());
        infcKategori.insert(kategori);
        JOptionPane.showMessageDialog(frame, "Berhasil menambahkan kategori baru");
        kembali();
    }
     public void kembali(){
         frame.dispose();
        new viewKategori().setVisible(true);
    }
     public void resetForm(){
         frame.setNamaKategori("");
     }
}

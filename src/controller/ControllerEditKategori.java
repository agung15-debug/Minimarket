package controller;

import javax.swing.JOptionPane;

import dao.daoKategori;
import dao.interfaceKategori;
import model.Kategori;
import view.editKategori;
import view.viewKategori;

public class ControllerEditKategori {
    editKategori frame;
    interfaceKategori infcKategori;

    public ControllerEditKategori(editKategori frame) {
        this.frame = frame;
        infcKategori = new daoKategori();
    }
    public void tampilkanData(Kategori kategori){
        frame.setTxtNamaKategori(kategori.getNamaKategori());
    }
    public void simpanEdit(int id){
        Kategori kategori = new Kategori();
        kategori.setNamaKategori(frame.getTxtNamaKategori().getText());
        kategori.setId(id);
        infcKategori.update(kategori);
        JOptionPane.showMessageDialog(frame, "Berhasil Mengedit Data");
        
        kembali();
    }
    public void kembali(){
        frame.dispose();
        new viewKategori().setVisible(true);
    }
}

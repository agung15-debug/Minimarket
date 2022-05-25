package controller;

import java.util.List;

import dao.daoKategori;
import dao.interfaceKategori;
import model.Kategori;
import view.detailKategori;
import view.editKategori;
import view.viewKategori;

public class ControllerDetailKategori {
    detailKategori frame;
    interfaceKategori infcKategori;

    public ControllerDetailKategori(detailKategori frame) {
        this.frame = frame;
        infcKategori = new daoKategori();
    }
    public void tampilkanData(Kategori kategori){
        frame.setOutId(kategori.getId());
        frame.setOutNamaKategori(kategori.getNamaKategori());
    }
    public void kembali(){
        frame.dispose();
        new viewKategori().setVisible(true);
    }
    public void halamanEdit(Kategori kategori){
        frame.dispose();
        new editKategori(kategori).setVisible(true);
    }
    public void hapusData(int id){
        infcKategori.delete(id);
        kembali();
    }
}

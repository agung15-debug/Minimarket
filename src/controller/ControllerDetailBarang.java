package controller;

import dao.daoBarang;
import dao.interfaceBarang;
import model.Barang;
import view.detailBarang;
import view.viewBarang;
import view.editBarang;

public class ControllerDetailBarang {
    detailBarang frame;
    interfaceBarang infcBarang;

    public ControllerDetailBarang(detailBarang frame) {
        this.frame = frame;
        infcBarang = new daoBarang();
    }
    public void tampilkanData(Barang barang){
        frame.setOutId(barang.getId());
        frame.setOutNamaBarang(barang.getNamaBarang());
        frame.setOutKategori(barang.getnKategori());
        frame.setOutDeskripsi(barang.getDeskripsi());
        frame.setOutStok(barang.getStok());
        frame.setOutHarga(barang.getHarga());
    }
    public void kembali(){
        frame.dispose();
        new viewBarang().setVisible(true);
    }
    public void halamanEdit(Barang barang){
        frame.dispose();
        new editBarang(barang).setVisible(true);
    }
    public void hapusData(int idBarang){
        infcBarang.delete(idBarang);
        kembali();
    }
}

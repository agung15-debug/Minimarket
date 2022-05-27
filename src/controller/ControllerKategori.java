package controller;

import java.util.List;

import dao.daoKategori;
import dao.interfaceKategori;
import model.Kategori;
import model.tableModelKategori;
import view.adminUtama;
import view.viewKategori;
import view.lihatKategoriBarang;
import view.tambahKategori;
import view.detailKategori;

public class ControllerKategori {
    viewKategori frame;
    lihatKategoriBarang frame2;
    interfaceKategori infcKategori;
    List<Kategori> list_kategori;

    public ControllerKategori(viewKategori frame) {
        this.frame = frame;
        infcKategori = new daoKategori();
        list_kategori = infcKategori.getData();
    }

    public ControllerKategori(lihatKategoriBarang frame2) {
        this.frame2 = frame2;
        infcKategori = new daoKategori();
        list_kategori = infcKategori.getData();
    }
    
    public void loadTable(){
        tableModelKategori tmk = new tableModelKategori(list_kategori);
            frame.getTableKategori().setModel(tmk);
    }
    public void loadTableKategoriBarang(){
        tableModelKategori tmk = new tableModelKategori(list_kategori);
         frame2.getTableKategori().setModel(tmk);
    }
    public void halamanTambah(){
        frame.dispose();
        new tambahKategori().setVisible(true);
    }
    public void halamanDetail(int row){
        Kategori kategori = list_kategori.get(row);
        frame.dispose();
        new detailKategori(kategori).setVisible(true);
    }
    public void halamanAdmin(){
        frame.dispose();
        new adminUtama().setVisible(true);
    }
}

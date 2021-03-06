package controller;

import java.util.List;

import dao.daoBarang;
import dao.interfaceBarang;
import model.Barang;
import model.tableModelBarang;
import view.viewBarang;
import view.tambahBarang;
import view.detailBarang;
import view.adminUtama;
import view.lihatBarang;

public class ControllerBarang {
    viewBarang frame;
    lihatBarang frame2;
    interfaceBarang infcBarang;
    List<Barang> list_barang;

    public ControllerBarang(viewBarang frame) {
        this.frame = frame;
        infcBarang = new daoBarang();
        list_barang = infcBarang.getData();
    }
    public ControllerBarang(lihatBarang frame2) {
        this.frame2 = frame2;
        infcBarang = new daoBarang();
        list_barang = infcBarang.getData();
    }
    public void loadTable(){
        tableModelBarang tmb = new tableModelBarang(list_barang);
        frame.getTableBarang().setModel(tmb);
    }
    public void loadTableBarang(){
        tableModelBarang tmb = new tableModelBarang(list_barang);
        frame2.getTableBarang().setModel(tmb);
    }
    public void halamanTambah(){
        frame.dispose();
        new tambahBarang().setVisible(true);
    }
    public void halamanDetail(int row){
        Barang barang = list_barang.get(row);
        frame.dispose();
        new detailBarang(barang).setVisible(true);
    }
    public void halamanAdmin(){
        frame.dispose();
        new adminUtama().setVisible(true);
    }
} 

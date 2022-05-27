package controller;

import javax.swing.JOptionPane;
import dao.daoBarang;
import dao.interfaceBarang;
import java.util.ArrayList;
import model.Barang;
import view.viewBarang;
import view.editBarang;
import view.lihatKategoriBarang;

public class ControllerEditBarang {
    editBarang frame;
    interfaceBarang infcBarang;
    ArrayList<String> kategori;
    lihatKategoriBarang lKategori;

    public ControllerEditBarang(editBarang frame) {
        this.frame = frame;
        infcBarang = new daoBarang();
        kategori = infcBarang.getKategori();
        for(int i = 0; i < kategori.size(); i++){
            this.frame.setjKategori(kategori.get(i));
        }
    }
    
    public void tampilkanData(Barang barang){
        frame.setTxtNama(barang.getNamaBarang());
        frame.setKategori(Integer.toString(barang.getKategori()));
        frame.setTxtDeskripsi(barang.getDeskripsi());
        frame.setStok(barang.getStok());
        frame.setHarga(barang.getHarga());
    }
    public void simpanEdit(int id){
         Barang barang = new Barang();
        barang.setNamaBarang(frame.getTxtNama().getText());
        barang.setKategori(Integer.parseInt(frame.getjKategori().getSelectedItem().toString()));
        barang.setDeskripsi(frame.getTxtDeskripsi().getText());
        barang.setStok((Integer)frame.getStok().getValue());
        barang.setHarga((Integer)frame.getHarga().getValue());
        barang.setId(id);
        infcBarang.update(barang);
        JOptionPane.showMessageDialog(frame, "Berhasil menambahkan kategori baru");
        kembali();
    }
    public void kembali(){
        frame.dispose();
        new viewBarang().setVisible(true);
        lKategori.setVisible(false);
       }
    
    public void lihatKategori(){
        lKategori = new lihatKategoriBarang();
        lKategori.setVisible(true);
    }
}

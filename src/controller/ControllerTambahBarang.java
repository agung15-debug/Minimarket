package controller;

import dao.daoBarang;
import dao.interfaceBarang;
import model.Barang;
import view.tambahBarang;
import view.viewBarang;
import view.lihatKategoriBarang;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControllerTambahBarang {
    tambahBarang frame;
    ArrayList<String> kategori;
    interfaceBarang infcBarang;
    lihatKategoriBarang lKategori;
        
    public ControllerTambahBarang(tambahBarang frame) {
        this.frame = frame;
        infcBarang = new daoBarang();
        kategori = infcBarang.getKategori();
        for(int i = 0; i < kategori.size(); i++){
            this.frame.setjKategori(kategori.get(i));
        }
    }
    public void tambahkanBarang(){
        Barang barang = new Barang();
        barang.setNamaBarang(frame.getTxtNama().getText());
        barang.setKategori(Integer.parseInt(frame.getjKategori().getSelectedItem().toString()));
        barang.setDeskripsi(frame.getTxtDeskripsi().getText());
        barang.setStok((Integer)frame.getStok().getValue());
        barang.setHarga((Integer)frame.getHarga().getValue());
        infcBarang.insert(barang);
        JOptionPane.showMessageDialog(frame, "Berhasil menambahkan kategori baru");
        kembali();
    }
    public void kembali(){
         frame.dispose();
        new viewBarang().setVisible(true);
        lKategori.dispose();
    }
     public void resetForm(){
         frame.setTxtNama("");
         frame.setjKategori(-1);
         frame.setTxtDeskripsi("");
         frame.setStok(0);
         frame.setHarga(0);
     }
     public void lihatKategori(){
         lKategori = new lihatKategoriBarang();
         lKategori.setVisible(true);
     }
}

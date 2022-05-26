package controller;

import java.util.List;
import dao.daoPegawai;
import model.Pegawai;
import model.tableModelPegawai;
import view.viewPegawai;
import dao.interfacePegawai;
import view.tambahPegawai;
import view.detailPegawai;
import view.adminUtama;

public class ControllerPegawai {
    viewPegawai frame;
    interfacePegawai infcPegawai;
    List<Pegawai> list_pegawai;

    public ControllerPegawai(viewPegawai frame) {
        this.frame = frame;
        infcPegawai = new daoPegawai();
        list_pegawai = infcPegawai.getData();
    }
    
    public void loadTable(){
        tableModelPegawai tmp = new tableModelPegawai(list_pegawai);
        frame.getTablePegawai().setModel(tmp);
    }
    public void halamanTambah(){
        frame.dispose();
        new tambahPegawai().setVisible(true);
    }
    public void halamanDetail(int row){
        Pegawai pegawai = list_pegawai.get(row);
        frame.dispose();
        new detailPegawai(pegawai).setVisible(true);
    }
     public void kembali(){
         frame.dispose();
         new adminUtama().setVisible(true);
     }
}

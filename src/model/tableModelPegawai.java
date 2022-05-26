package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class tableModelPegawai extends AbstractTableModel{
   
    List<Pegawai> list_pegawai;
    
    public tableModelPegawai(List<Pegawai> list_pegawai){
        this.list_pegawai = list_pegawai;
    }
    
    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public int getRowCount() {
        return list_pegawai.size();
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 -> "Username";
            case 1 -> "Password";
            case 2 -> "Nama Pegawai";
            case 3 -> "No Handphone";
            case 4 -> "Alamat";
            case 5 -> "Privilage";
            default -> null;
        };
    }

    @Override
    public Object getValueAt(int row, int column) {
        return switch (column) {
            case 0 -> list_pegawai.get(row).getUsername();
            case 1 -> list_pegawai.get(row).getPassword();
            case 2 -> list_pegawai.get(row).getNamaPegawai();
            case 3 -> list_pegawai.get(row).getNoHp();
            case 4 -> list_pegawai.get(row).getAlamat();
            case 5 -> list_pegawai.get(row).getnPrivilage();
            default -> null;
        };
    }
}

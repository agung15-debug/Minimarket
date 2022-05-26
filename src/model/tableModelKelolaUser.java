package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class tableModelKelolaUser extends AbstractTableModel{
   
    List<kelolaUser> list_user;
    
    public tableModelKelolaUser(List<kelolaUser> list_user){
        this.list_user = list_user;
    }
    
    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public int getRowCount() {
        return list_user.size();
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
            case 0 -> list_user.get(row).getUsername();
            case 1 -> list_user.get(row).getPassword();
            case 2 -> list_user.get(row).getNamaPegawai();
            case 3 -> list_user.get(row).getNoHp();
            case 4 -> list_user.get(row).getAlamat();
            case 5 -> list_user.get(row).getPrivilage();
            default -> null;
        };
    }
}

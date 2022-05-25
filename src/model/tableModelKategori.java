package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class tableModelKategori extends AbstractTableModel{
    List<Kategori> list_kategori;

    public tableModelKategori(List<Kategori> list_kategori) {
        this.list_kategori = list_kategori;
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public int getRowCount() {
        return list_kategori.size();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID Kategori";
            case 1:
                return "Nama";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return list_kategori.get(row).getId();
            case 1:
                return list_kategori.get(row).getNamaKategori();
            default:
                return null;
        }
    }
}

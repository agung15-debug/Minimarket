package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class tableModelBarang extends AbstractTableModel{
    List<Barang> list_barang;

    public tableModelBarang(List<Barang> list_barang) {
        this.list_barang = list_barang;
    }

     @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public int getRowCount() {
        return list_barang.size();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "id_barang";
            case 1:
                return "Nama Barang";
            case 2:
                return "Deskripsi";
            case 3:
                return "Stok";
            case 4:
                return "Harga";
            case 5:
                return "Kategori";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return list_barang.get(row).getId();
            case 1:
                return list_barang.get(row).getNamaBarang();
            case 2:
                return list_barang.get(row).getDeskripsi();
            case 3:
                return list_barang.get(row).getStok();
            case 4:
                return list_barang.get(row).getHarga();
            case 5:
                return list_barang.get(row).getnKategori();
            default:
                return null;
        }
    }
    
}

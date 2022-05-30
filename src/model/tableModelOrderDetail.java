/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class tableModelOrderDetail extends AbstractTableModel{
    List<OrderDetail> list_orderdetail;

    public tableModelOrderDetail(List<OrderDetail> list_orderdetail) {
        this.list_orderdetail = list_orderdetail;
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public int getRowCount() {
        return list_orderdetail.size();
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 -> "ID Detail";
            case 1 -> "ID Pegawai";
            case 2 -> "ID Order";
            case 3 -> "ID Barang";
            case 4 -> "Jumlah";
            case 5 -> "Total";
            default -> null;
        };
    }

    @Override
    public Object getValueAt(int row, int column) {
        return switch (column) {
            case 0 -> list_orderdetail.get(row).getIdDetail();
            case 1 -> list_orderdetail.get(row).getIdPegawai();
            case 2 -> list_orderdetail.get(row).getIdOrder();
            case 3 -> list_orderdetail.get(row).getIdBarang();
            case 4 -> list_orderdetail.get(row).getJumlah();
            case 5 -> list_orderdetail.get(row).getTotal();
            default -> null;
        };
    }
}

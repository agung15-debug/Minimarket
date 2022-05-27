/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class tableModelOrder extends AbstractTableModel{
    List<Order> list_order;

    public tableModelOrder(List<Order> list_order) {
        this.list_order = list_order;
    }

     @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public int getRowCount() {
        return list_order.size();
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 -> "Id Order";
            case 1 -> "Id Pegawai";
            default -> null;
        };
    }

    @Override
    public Object getValueAt(int row, int column) {
        return switch (column) {
            case 0 -> list_order.get(row).getIdOrder();
            case 1 -> list_order.get(row).getIdPegawai();
            default -> null;
        };
    }
}

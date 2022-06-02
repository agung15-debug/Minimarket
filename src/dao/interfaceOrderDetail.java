package dao;

import java.util.ArrayList;
import model.OrderDetail;
import java.util.List;
        
public interface interfaceOrderDetail {
    public void insert(String id_order, String id_barang, int jumlah, int total);
    public void update(OrderDetail orderdetail);
    public void delete(int id);
    public List<OrderDetail> getData();
    public ArrayList<String> getIdOrder();
    public ArrayList<String> getIdBarang();
}

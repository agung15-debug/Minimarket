/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import model.OrderDetail;
import java.util.List;
        
public interface interfaceOrderDetail {
    public void insert(OrderDetail orderdetail);

    public void update(OrderDetail orderdetail);

    public void delete(int id);

    public List<OrderDetail> getData();
}

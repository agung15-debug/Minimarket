package dao;

import model.Order;
import java.util.List;

public interface interfaceOrder {
    public void insert(Order order);

    public void update(Order order);

    public void delete(int id);

    public List<Order> getData();
}

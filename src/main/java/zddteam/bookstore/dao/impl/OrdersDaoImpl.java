package zddteam.bookstore.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import zddteam.bookstore.dao.OrdersRepository;
import zddteam.bookstore.domain.Orders;

import java.util.List;

@Component
public class OrdersDaoImpl {

    @Autowired
    private OrdersRepository ordersRepository;

    public void add(Orders orders) {
        ordersRepository.save(orders);
    }

    public Orders find(String id) {
        return ordersRepository.findOne(id);
    }

    public List <Orders> getAll(boolean state) {
        return ordersRepository.getAllByState(state);
    }

    public List <Orders> getAll(boolean state, String id) {
        return ordersRepository.getAllByStateAndId(state, id);
    }

    public List <Orders> getAllOrders(String id) {
        return ordersRepository.getAllById(id);
    }

    public void update(Orders orders) {
        ordersRepository.update(orders);
    }
}

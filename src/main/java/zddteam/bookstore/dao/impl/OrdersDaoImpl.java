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

    public List <Orders> getAll(boolean state, String userid) {
        return ordersRepository.getAllByStateAndUserId(state, userid);
    }

    public List <Orders> getAllOrders(String userid) {
        return ordersRepository.getAllByUserId(userid);
    }

    public void update(boolean state,String ordersId) {
        ordersRepository.update(state,ordersId);
    }
}

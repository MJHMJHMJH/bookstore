package zddteam.bookstore.dao;

import org.springframework.data.repository.CrudRepository;
import zddteam.bookstore.domain.Orders;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface OrdersRepository extends CrudRepository<Orders,String> {
    List<Orders> getAllByState(boolean state);
    List<Orders> getAllByStateAndId(boolean state,String id);
    List<Orders> getAllById(String id);
    void update(Orders orders);
}

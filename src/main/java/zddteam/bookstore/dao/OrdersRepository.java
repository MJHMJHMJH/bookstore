package zddteam.bookstore.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import zddteam.bookstore.domain.Orders;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface OrdersRepository extends CrudRepository<Orders,String> {
    List<Orders> getAllByState(boolean state);
    List<Orders> getAllByStateAndId(boolean state,String id);
    List<Orders> getAllById(String id);
    @Query("update Orders as o set o.state=?1 where o.id=?2")
    void update(Orders orders);
}

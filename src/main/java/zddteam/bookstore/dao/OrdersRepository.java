package zddteam.bookstore.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import zddteam.bookstore.domain.Orders;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface OrdersRepository extends CrudRepository<Orders,String> {
    List<Orders> getAllByState(boolean state);
    List<Orders> getAllByStateAndUserId(boolean state,String UserId);
    List<Orders> getAllByUserId(String UserId);
    @Modifying
    @Query("update Orders as o set o.state=?1 where o.id=?2")
    void update(boolean state,String ordersId);
}

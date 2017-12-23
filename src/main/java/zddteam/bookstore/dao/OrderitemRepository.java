package zddteam.bookstore.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import zddteam.bookstore.domain.Orderitem;

import javax.transaction.Transactional;

@Transactional
@Component
public interface OrderitemRepository extends CrudRepository <Orderitem, String> {
    Orderitem findOrderitemByOrderId(String orderid);
}

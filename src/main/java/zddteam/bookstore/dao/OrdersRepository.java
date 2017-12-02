package zddteam.bookstore.dao;

import org.springframework.data.repository.CrudRepository;
import zddteam.bookstore.domain.Orders;

public interface OrdersRepository extends CrudRepository<Orders,String> {
}

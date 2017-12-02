package zddteam.bookstore.dao;

import org.springframework.data.repository.CrudRepository;
import zddteam.bookstore.domain.Orderitem;

public interface OrderitemRepository extends CrudRepository <Orderitem, String> {
}

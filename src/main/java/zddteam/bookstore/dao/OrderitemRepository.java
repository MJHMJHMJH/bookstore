package zddteam.bookstore.dao;

import org.springframework.data.repository.CrudRepository;
import zddteam.bookstore.domain.Orderitem;

import javax.transaction.Transactional;

@Transactional
public interface OrderitemRepository extends CrudRepository <Orderitem, String> {
}

package zddteam.bookstore.dao;

import org.springframework.data.repository.CrudRepository;
import zddteam.bookstore.domain.Category;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface CategoryRepository extends CrudRepository <Category, String> {
    List<Category> findAll();
}

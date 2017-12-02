package zddteam.bookstore.dao;

import org.springframework.data.repository.CrudRepository;
import zddteam.bookstore.domain.Category;

import java.util.List;

public interface CategoryRepository extends CrudRepository <Category, String> {
    List<Category> findAll();
}

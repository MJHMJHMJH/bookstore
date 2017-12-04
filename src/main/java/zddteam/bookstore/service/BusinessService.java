package zddteam.bookstore.service;

import org.springframework.stereotype.Component;
import zddteam.bookstore.domain.Category;

import java.util.List;

@Component
public interface BusinessService {

    void addCategory(Category category);
    Category findCategory(String id);
    List<Category> getAllCategory();
}

package zddteam.bookstore.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import zddteam.bookstore.dao.CategoryRepository;
import zddteam.bookstore.domain.Category;

import java.util.List;

@Component
public class CategoryDaoImpl {

    @Autowired
    private CategoryRepository categoryRepository;

    public void addCategory(Category category){
        categoryRepository.save(category);
    }

    public  Category findCategory(String id){
        return categoryRepository.findOne(id);
    }

    public List<Category> getAll(){
        return categoryRepository.findAll();
    }
}

package zddteam.bookstore.testdao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import zddteam.bookstore.dao.impl.BookDaoImpl;
import zddteam.bookstore.dao.impl.CategoryDaoImpl;
import zddteam.bookstore.dao.impl.OrdersDaoImpl;
import zddteam.bookstore.domain.Book;
import zddteam.bookstore.domain.Category;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDaoImpl {

    @Autowired
    private BookDaoImpl bookDao;

    @Autowired
    private CategoryDaoImpl categoryDao;

    @Autowired
    private OrdersDaoImpl ordersDao;

    @Test
    public void testCategory(){
        Category category = new Category();
        category.setId("A004");
        category.setName("文学类");
        category.setDescription("文学作品");
        categoryDao.addCategory(category);
        System.out.println(categoryDao.findCategory("A002"));
        List<Category> categories = categoryDao.getAll();
        categories.forEach(System.out::println);
    }

    @Test
    public void testBook() {
        Book book = new Book();
        book.setId("A10005");
        book.setName("java核心编程II");
        book.setAuthor("未知");
        book.setPrice(35L);
        book.setDescription("java中级教程");
        book.setCategoryId("A001");

        System.out.println(bookDao.findBook("新视野"));
        System.out.println("-----------------------------------");
        List <Book> books = bookDao.getPageData(1, 2).getContent();
        books.forEach(System.out::println);
        System.out.println("-----------------------------------");
        List<Book> booksByCategory = bookDao.getPageDataByCategoryId(1, 5, "A001").getContent();
        booksByCategory.forEach(System.out::println);
        System.out.println("-----------------------------------");
        bookDao.addBook(book);
    }

    @Test
    public void testOrders(){

    }
}

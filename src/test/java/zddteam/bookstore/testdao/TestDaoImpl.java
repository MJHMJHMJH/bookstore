package zddteam.bookstore.testdao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import zddteam.bookstore.dao.impl.BookDaoImpl;
import zddteam.bookstore.dao.impl.CategoryDaoImpl;
import zddteam.bookstore.dao.impl.OrdersDaoImpl;
import zddteam.bookstore.dao.impl.UserDaoImpl;
import zddteam.bookstore.domain.Book;
import zddteam.bookstore.domain.Category;
import zddteam.bookstore.domain.Orders;
import zddteam.bookstore.domain.User;

import java.util.Date;
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

    @Autowired
    private UserDaoImpl userDao;

    @Test
    public void testCategory() {
        Category category = new Category();
        category.setId("A004");
        category.setName("文学类");
        category.setDescription("文学作品");
        categoryDao.addCategory(category);
        System.out.println(categoryDao.findCategory("A002"));
        List <Category> categories = categoryDao.getAll();
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
        List <Book> booksByCategory = bookDao.getPageDataByCategoryId(1, 5, "A001").getContent();
        booksByCategory.forEach(System.out::println);
        System.out.println("-----------------------------------");
        bookDao.addBook(book);
    }

    @Test
    public void testOrders() {
        Orders orders = new Orders();
        orders.setId("B0002");
        orders.setOrdertime(new Date());
        orders.setPrice(33L);
        orders.setState(false);
        orders.setUserId("100001");
        Orders orders1 = new Orders();
        orders1.setId("B0001");
        orders1.setOrdertime(new Date());
        orders1.setPrice(33L);
        orders1.setState(true);
        orders1.setUserId("100001");
//        ordersDao.add(orders);
        System.out.println(ordersDao.find("B0001"));
        System.out.println("-----------------------------------");
        List <Orders> ordersList = ordersDao.getAll(false);
        ordersList.forEach(System.out::println);
        System.out.println("-----------------------------------");
        List <Orders> ordersList1 = ordersDao.getAll(true, "100001");
        ordersList1.forEach(System.out::println);
        System.out.println("-----------------------------------");
        List <Orders> userOrders = ordersDao.getAllOrders("100001");
        userOrders.forEach(System.out::println);
        System.out.println("-----------------------------------");
        ordersDao.update(false, "B0001");
    }

    @Test
    public void testUser(){
//        User user = new User();
//        user.setId("100003");
//        user.setUsername("kangjiayu");
//        user.setPassword("123456");
//        user.setPhone("18089154713");
//        user.setEmail("1162669118@qq.com");
//        user.setAddress("陕西西安");
//        userDao.addUser(user);
        System.out.println(userDao.findUser("kangjiayu"));
        System.out.println(userDao.findUser("root","123"));
    }
}

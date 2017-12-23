package zddteam.bookstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import zddteam.bookstore.dao.OrderitemRepository;
import zddteam.bookstore.dao.impl.BookDaoImpl;
import zddteam.bookstore.dao.impl.CategoryDaoImpl;
import zddteam.bookstore.dao.impl.OrdersDaoImpl;
import zddteam.bookstore.dao.impl.UserDaoImpl;
import zddteam.bookstore.domain.*;
import zddteam.bookstore.service.BusinessService;
import zddteam.bookstore.util.OrderUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private CategoryDaoImpl categoryDao;
    @Autowired
    private BookDaoImpl bookDao;
    @Autowired
    private UserDaoImpl userDao;
    @Autowired
    private OrdersDaoImpl ordersDao;
    @Autowired
    private OrderitemRepository orderitemRepository;

    private final int pageSize = 5;

    @Override
    public void addCategory(Category category) {
        categoryDao.addCategory(category);
    }

    @Override
    public Category findCategory(String id) {
        return categoryDao.findCategory(id);
    }

    @Override
    public List <Category> getAllCategory() {
        return categoryDao.getAll();
    }

    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    public Book findBookByName(String name) {
        return bookDao.findBookByName(name);
    }

    public Book findBook(String id) {
        return bookDao.findBook(id);
    }

    /**
     * @param pagenum 图书页码
     * @return 图书分页
     */
    public List<Book> getBookPageData(int pagenum) {
        return bookDao.getPageData(pagenum, pageSize).getContent();
    }

    public List<Book> getBookPageData(int pagenum, String category_id) {
        return bookDao.getPageDataByCategoryId(pagenum, pageSize, category_id).getContent();
    }

    public void buyBook(Cart cart, Book book) {
        cart.add(book);
    }

    public void registerUser(User user) {
        userDao.addUser(user);
    }

    public User findUserById(Long id){
        return userDao.findUserById(id);
    }

    public User findUser(String name) {
        return userDao.findUser(name);
    }

    public User userLogin(String username, String password) {
        return findUser(username) != null ? userDao.findUser(username, password) : null;
    }

    public void createOrder(Cart cart, User user) {
        if (cart == null) {
            throw new RuntimeException("购物车里什么也没有！");
        }
        Orders orders = new Orders();
        orders.setId(OrderUtil.makeID());
        orders.setOrdertime(new Date());
        orders.setPrice((long) cart.getPrice());
        orders.setState(false);
        orders.setUserId(user.getId());
        for (Map.Entry <String, CartItem> me : cart.getMap().entrySet()) {
            CartItem cartItem = me.getValue();
            Orderitem oitem = new Orderitem();
            oitem.setBookId(cartItem.getBook().getId());
            oitem.setPrice((long) cartItem.getPrice());
            oitem.setId(OrderUtil.makeID());
            oitem.setQuantity(cartItem.getQuantity());
            oitem.setOrderId(orders.getId());
        }
        ordersDao.add(orders);
    }

    public List <Orders> ordersList(boolean state) {
        return ordersDao.getAll(state);
    }

    public Orders findOrder(String orderid) {
        return ordersDao.find(orderid);
    }

    public void confirmOrder(String orderid) {
        Orders orders = ordersDao.find(orderid);
        orders.setState(true);
        ordersDao.update(orders.getState(), orderid);
    }

    public List <Orders> ordersList(boolean state, String userid) {
        return ordersDao.getAll(state, userid);
    }

    public List<Orders> clientListOrder(String userid){
        return ordersDao.getAllOrders(userid);
    }

    public Orderitem findOrderitemByOrderId(String orderid){
        return orderitemRepository.findOrderitemByOrderId(orderid);
    }
}
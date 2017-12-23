package zddteam.bookstore.web.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import zddteam.bookstore.domain.Orderitem;
import zddteam.bookstore.domain.Orders;
import zddteam.bookstore.domain.User;
import zddteam.bookstore.service.impl.BusinessServiceImpl;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping(value = "/manager")
public class listOrderController {

    @Autowired
    private BusinessServiceImpl businessService;

    @GetMapping(value = "/orderList")
    public String orderList(Model model, String state) {
        boolean s = false;
        if (state == null || Objects.equals(state, "0")) s = false;
        if (state != null && state.equals("1")) s = true;
        System.out.println(s);
        List <Orders> orders = businessService.ordersList(s);
        model.addAttribute("orders", orders);
        return "/manager/listorder";
    }

    @GetMapping(value = "/toOrderDetail")
    public String toOrderDetail(String orderId, Model model) {
        Orderitem orderitem = businessService.findOrderitemByOrderId(orderId);
        Orders orders = businessService.findOrder(orderId);
        User user1 = businessService.findUserById(orders.getUserId());
        model.addAttribute("orderitem", orderitem);
        model.addAttribute("user1", user1);
        return "/manager/orderdetail";
    }
}

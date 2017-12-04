package zddteam.bookstore.web.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import zddteam.bookstore.domain.User;
import zddteam.bookstore.service.impl.BusinessServiceImpl;

@Controller
@RequestMapping(value = "/index")
public class RegisterController {

    @Autowired
    private BusinessServiceImpl businessService;

    @PostMapping(value = "/register")
    public String register(@ModelAttribute(name = "user") User user, Model model) {
        try {
            businessService.registerUser(user);
            model.addAttribute("message","注册成功！");
            return "redircte:index";
        }catch (Exception e){
            e.printStackTrace();
            model.addAttribute("message","注册失败！");
            return "index/register";
        }
    }
}

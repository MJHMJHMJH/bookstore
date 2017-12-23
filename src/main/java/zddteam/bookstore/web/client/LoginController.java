package zddteam.bookstore.web.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import zddteam.bookstore.domain.User;
import zddteam.bookstore.service.impl.BusinessServiceImpl;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/client")
public class LoginController {

    @Autowired
    private BusinessServiceImpl businessService;

    @GetMapping(value = "/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "/client/login";
    }

    @PostMapping(value = "/doLogin")
    public String login(User user, Model model, HttpSession session) {
        try {
            if (businessService.userLogin(user.getUsername(), user.getPassword()) != null) {
                model.addAttribute("message", "登录成功！");
                session.setAttribute("user",user);
                return "redirect:/";
            } else {
                model.addAttribute("message", "用户不存在！");
                return "client/login";
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "出现了意外请重试！");
            return "client/login";
        }
    }
}

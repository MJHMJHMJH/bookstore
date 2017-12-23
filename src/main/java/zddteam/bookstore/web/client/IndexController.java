package zddteam.bookstore.web.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import zddteam.bookstore.domain.User;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/")
public class IndexController {

    @GetMapping(value = "/")
    public String index() {
        return "client/index";
    }

    @GetMapping(value = "/client/header")
    public String header() {
        return "client/header";
    }

    @GetMapping(value = "/client/body")
    public String body() {
        return "client/body";
    }

    @GetMapping(value = "/client/footer")
    public String footer() {
        return "client/footer";
    }

    /**
     * 清除用户session退出登录
     * @param user
     * @param session
     * @return /
     */
    @GetMapping(value = "/client/signOut")
    public String signOut(User user, HttpSession session) {
        try {
            session.removeAttribute("user");
            return "redirect:/";
        } catch (Exception e) {
            return "/";
        }
    }
}

package zddteam.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/client")
public class RegisterController {
    @PostMapping(value = "/register")
    public String register(Model model){
        return "register";
    }
}

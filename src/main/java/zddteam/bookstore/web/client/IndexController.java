package zddteam.bookstore.web.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class IndexController {

    @GetMapping(value = "/")
    public String index(){
        return "client/index";
    }

    @GetMapping(value = "/client/header")
    public String header(){
        return "client/header";
    }

    @GetMapping(value = "/client/body")
    public String body(){
        return "client/body";
    }

    @GetMapping(value = "/client/footer")
    public String footer(){
        return "client/footer";
    }
}

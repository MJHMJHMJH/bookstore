package zddteam.bookstore.web.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import zddteam.bookstore.domain.Book;
import zddteam.bookstore.service.impl.BusinessServiceImpl;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping(value = "/manager")
public class ListBookController {

    @Autowired
    private BusinessServiceImpl businessService;

    private int pagenum = 1;
    private int maxpage;

    private void getMaxpage() {
        int total = 1;
        while (!businessService.getBookPageData(total).isEmpty())
            total++;
        maxpage = total - 1;
    }

    @GetMapping(value = "/list")
    public String list(Model model, String page) {
        getMaxpage();
        if (Objects.equals(page, "1") & pagenum < maxpage) {
            pagenum += 1;
        }
        if (Objects.equals(page, "0") & pagenum > 1) {
            pagenum -= 1;
        }
        List <Book> books = businessService.getBookPageData(pagenum);
        model.addAttribute("books", books);
        model.addAttribute("maxpage", maxpage);
        model.addAttribute("pagenum", pagenum);
        return "/manager/listbook";
    }

    @GetMapping(value = "/toEditBook")
    public String toEditBook(String id, Model model) {
        Book book = businessService.findBook(id);
        model.addAttribute("book", book);
        return "/manager/editbook";
    }

    @PostMapping(value = "/editBook")
    public String editBook(Book book) {
        businessService.addBook(book);
        return "redirect:/manager/list";
    }

    @GetMapping(value = "/doAddBook")
    public String doAddBook(Model model) {
        model.addAttribute("book", new Book());
        return "/manager/bookadd";
    }

    @PostMapping(value = "/addBook")
    public String addBook(@ModelAttribute(name = "book") Book book,Model model) {
        try {
            businessService.addBook(book);
            return "redirect:/manager/list";
        }catch (Exception e){
            e.printStackTrace();
            model.addAttribute("error","添加失败");
            model.addAttribute("book", new Book());
            return "/manager/bookadd";
        }
    }
}

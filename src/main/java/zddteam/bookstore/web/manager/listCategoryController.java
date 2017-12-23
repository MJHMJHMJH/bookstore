package zddteam.bookstore.web.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import zddteam.bookstore.domain.Category;
import zddteam.bookstore.service.impl.BusinessServiceImpl;

import java.util.List;

@Controller
@RequestMapping(value = "/manager")
public class listCategoryController {
    @Autowired
    private BusinessServiceImpl businessService;

    @GetMapping(value = "/categoryList")
    public String categoryList(Model model) {
        List <Category> categories = businessService.getAllCategory();
        model.addAttribute("categories", categories);
        return "/manager/listcategory";
    }

    @GetMapping(value = "/toEditcategory")
    public String toEditcategory(String id, Model model) {
        Category category = businessService.findCategory(id);
        model.addAttribute("category", category);
        return "/manager/editcategory";
    }

    @PostMapping(value = "/editCategory")
    public String editCategory(Category category) {
        businessService.addCategory(category);
        return "redirect:/manager/categoryList";
    }

    @GetMapping(value = "/doAddCategory")
    public String doAddCategory(Model model) {
        model.addAttribute("category", new Category());
        return "/manager/categoryadd";
    }

    @PostMapping(value = "/addCategory")
    public String addCategory(Category category, Model model) {
        try {
            businessService.addCategory(category);
            return "redirect:/manager/categoryList";
        }catch (Exception e){
            model.addAttribute("category",category);
            model.addAttribute("error","添加失败");
            return "/manager/categoryadd";
        }
    }

}

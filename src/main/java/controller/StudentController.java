package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/students")
public class StudentController {
    @GetMapping("/list")
    public String listStudent(ModelMap modelMap){
        modelMap.addAttribute("ten", "Kieu Anh xinh");
        return "list";
    }
    @GetMapping("")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("ten", "Vu Thi Kieu Anh");
        return  modelAndView;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView("detail");
        modelAndView.addObject("name", "Phan The Ky");
        modelAndView.addObject("age", "21");
        modelAndView.addObject("id", id);
        return modelAndView;
    }

    @GetMapping("/search")
    public ModelAndView modelAndView(@RequestParam String name, String a){
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("search", name);
        modelAndView.addObject("a", a);
        return modelAndView;
    }
}
package controller;

import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.student.IStudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
//    private IStudentService studentService = new StudentService();
    @Autowired
    private IStudentService studentService;


//    @GetMapping("/list")
//    public String listStudent(ModelMap modelMap){
//        modelMap.addAttribute("ten", "Kieu Anh xinh");
//        return "list";
//    }
    @GetMapping("")
    public ModelAndView index(){
//        ModelAndView modelAndView = new ModelAndView("list");
//        modelAndView.addObject("ten", studentService.findAll());
        ModelAndView modelAndView = new ModelAndView("list", "list", studentService.findAll());
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

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String showFormEdit(@PathVariable int id, ModelMap modelMap){
        Student student  = studentService.findById(id);
        modelMap.addAttribute("student", student);
        return "edit";
    }
//    @PostMapping("/edit/{id}")
//    public ModelAndView editStudent(@PathVariable int id, @RequestParam String name, String address){
//        Student student = new Student(id, name, address);
//        studentService2.save(student, id);
//        return new ModelAndView("list", "list", studentService2.findAll());
//    }
    @PostMapping("/edit/{id}")
    public ModelAndView editStudent(@PathVariable int id, @ModelAttribute Student student){
        student.setId(id);
        studentService.save(student, id);
        return new ModelAndView("list", "list", studentService.findAll());
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("s", new Student());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute Student s){
        int id = studentService.findAll().size();
        s.setId(id);
        studentService.update(s);
        ModelAndView modelAndView = new ModelAndView("create", "s", new Student());
        modelAndView.addObject("mess", "Tao moi thanh cong students " + s.getName());
        return modelAndView;

    }
}
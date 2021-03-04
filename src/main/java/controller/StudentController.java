package controller;

import model.Class;
import model.Student;
import model.StudentForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.student.IStudentService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
//    private IStudentService studentService = new StudentService();
    @Autowired
    private IStudentService studentService;

    @Autowired
    private Environment environment;

    @ModelAttribute("class")
    public List<Class> getClassInf(){
        List<Class> allClass = getAllClass();
        return allClass;
    }


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
        modelAndView.addObject("s", new StudentForm());
//        getAllClass(modelAndView);
        return modelAndView;
    }

    private List<Class> getAllClass() {
        List<Class> classList = new ArrayList<>();
        classList.add(new Class(1, "C10"));
        classList.add(new Class(2, "C11"));
        classList.add(new Class(3, "C12"));
        return classList;
//        modelAndView.addObject("class",classList);
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute StudentForm s) throws IOException {

        int id = studentService.findAll().size();
        s.setId(id);
//        studentService.update(s);

        MultipartFile multipartFile = s.getAvatar();
        String avatar = multipartFile.getOriginalFilename();
        String thu_muc_anh = environment.getProperty("file_upload").toString();
        FileCopyUtils.copy(multipartFile.getBytes(), new File(thu_muc_anh+avatar));
        Student s1 = new Student(s.getName(), s.getAddress(), s.getClass_id(), avatar);
        s1.setId(id);
        studentService.update(s1);
        ModelAndView modelAndView = new ModelAndView("create", "s", new Student());
        modelAndView.addObject("mess", "Tao moi thanh cong students " + s.getName());
        return modelAndView;

    }
}
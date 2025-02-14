package controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import bean.Student;
import dao.StudentDao;

@Controller
public class StudentController {

    @Autowired
    StudentDao dao;

    @RequestMapping("/studentform")
    public String showform(Model m) {
        m.addAttribute("command", new Student());
        return "studentform";
    }

    @RequestMapping(value="/save", method=RequestMethod.POST)
    public String save(@ModelAttribute("student") Student student) {
        dao.save(student);
        return "redirect:/viewstudents";
    }

    @RequestMapping("/viewstudents")
    public String viewstudents(Model m) {
        List<Student> list = dao.getStudents();
        m.addAttribute("list", list);
        return "viewstudents";
    }

    @RequestMapping(value="/editstudent/{id}")
    public String edit(@PathVariable int id, Model m) {
        Student student = dao.getStudentById(id);
        m.addAttribute("command", student);
        return "studenteditform";
    }

    @RequestMapping(value="/editsave", method=RequestMethod.POST)
    public String editsave(@ModelAttribute("student") Student student) {
        dao.update(student);
        return "redirect:/viewstudents";
    }

    @RequestMapping(value="/deletestudent/{id}", method=RequestMethod.GET)
    public String delete(@PathVariable int id) {
        dao.delete(id);
        return "redirect:/viewstudents";
    }
}
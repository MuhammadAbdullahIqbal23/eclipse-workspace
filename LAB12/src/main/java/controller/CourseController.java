package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bean.Course;
import dao.CourseDao;

@Controller
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseDao courseDao;

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("course", new Course());
        return "courseform";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("course") Course course) {
        courseDao.save(course);
        return "redirect:/courses";
    }

    @GetMapping
    public String viewCourses(Model model) {
        List<Course> courses = courseDao.getAllCourses();
        model.addAttribute("courses", courses);
        return "viewcourses";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam int id, Model model) {
        Course course = courseDao.getById(id);
        model.addAttribute("course", course);
        return "courseeditform";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("course") Course course) {
        courseDao.update(course);
        return "redirect:/courses";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        courseDao.delete(id);
        return "redirect:/courses";
    }
}

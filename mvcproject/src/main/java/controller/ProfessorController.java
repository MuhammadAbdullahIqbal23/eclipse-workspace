package controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import bean.Professor;
import dao.ProfessorDao;

@Controller
public class ProfessorController {

    @Autowired
    ProfessorDao dao;

    @RequestMapping("/professorform")
    public String showform(Model m) {
        m.addAttribute("command", new Professor());
        return "professorform";
    }

    @RequestMapping(value="/save", method=RequestMethod.POST)
    public String save(@ModelAttribute("professor") Professor professor) {
        dao.save(professor);
        return "redirect:/viewprofessors";
    }

    @RequestMapping("/viewprofessors")
    public String viewprofessors(Model m) {
        List<Professor> list = dao.getProfessors();
        m.addAttribute("list", list);
        return "viewprofessors";
    }

    @RequestMapping(value="/editprofessor/{id}")
    public String edit(@PathVariable int id, Model m) {
        Professor professor = dao.getProfessorById(id);
        m.addAttribute("command", professor);
        return "professoreditform";
    }

    @RequestMapping(value="/editsave", method=RequestMethod.POST)
    public String editsave(@ModelAttribute("professor") Professor professor) {
        dao.update(professor);
        return "redirect:/viewprofessors";
    }

    @RequestMapping(value="/deleteprofessor/{id}", method=RequestMethod.GET)
    public String delete(@PathVariable int id) {
        dao.delete(id);
        return "redirect:/viewprofessors";
    }
}

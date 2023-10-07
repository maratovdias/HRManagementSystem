package com.example.hr.controller;

import com.example.hr.entity.EmpEntity;
import com.example.hr.service.EmpService;
import jakarta.servlet.http.HttpSession;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class EmpController {
    @Autowired
    EmpService empService;
@GetMapping("/")
    public String home(Model m){
    List<EmpEntity> emp = empService.getAllEmp();
    m.addAttribute("emp", emp);

    return "index";
    }
    @GetMapping("/addemp")
    public String add_emp(){
    return "add_emp";
    }
    @PostMapping("/register")
    public String empRegister(@Valid @ModelAttribute EmpEntity e, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {

            return "add_emp";
        }
        empService.addEmp(e);
        session.setAttribute("msg", "Employee added successfully..");
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model m){
        EmpEntity e = empService.getEmpById(id);
        m.addAttribute("emp", e);
        return "edit";
    }
    @PostMapping("/update")
    public String updateEmp(@ModelAttribute EmpEntity e, HttpSession session){
        empService.addEmp(e);
        session.setAttribute("msg", "Emp data update successfuly !");
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String deleteEmp(@PathVariable int id, HttpSession session){
        empService.deleteEmp(id);
        session.setAttribute("msg", "Emp data delete successfuly !");
        return "redirect:/";
    }

}

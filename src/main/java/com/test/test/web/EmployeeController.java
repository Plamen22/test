package com.test.test.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.test.test.models.Employee;
import com.test.test.service.EmployeeService;

@Controller
@RequestMapping("web/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //web/employees
    @GetMapping
    public String getIndex(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        return "employee";
    }

    //web/employees
    @PostMapping
    public String create(@ModelAttribute  Employee employee) {
        employeeService.save(employee);
        return "redirect:/web/employees";
    }

    //web/employees/create
    @GetMapping("create")
    public String createEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee-create";
    }

    //web/employees/{id}}
    @GetMapping("/{id}")
    public String update(Model model, @PathVariable int id) {
        Optional<Employee> employee = employeeService.findById(id);
        if (employee.isPresent()) {
            model.addAttribute("employee", employee.get());
        } else {
            model.addAttribute("employee", new Employee());
        }
        return "employee-edit";
    }

    //web/employees/delete/{id}}
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        employeeService.deleteById(id);
        return "redirect:/web/employees";
    }

    @PostMapping("/update/{id}")
    public String updateDate(@ModelAttribute Employee employee) {
        employeeService.save(employee);
        return "redirect:/web/employees";
    }
}

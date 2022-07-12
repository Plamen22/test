package com.test.test.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.test.service.EmployeeService;

@Controller
@RequestMapping("web")
public class IndexController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String getIndex(Model model) {
        return "index";
    }
}

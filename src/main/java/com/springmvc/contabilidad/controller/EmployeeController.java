package com.springmvc.contabilidad.controller;


import com.springmvc.contabilidad.model.Employee;
import com.springmvc.contabilidad.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


    @PostMapping("")
    public RedirectView postEmployee(@ModelAttribute Employee newEmployee) {

        this.employeeService.saveEmployee(newEmployee);

        return new RedirectView("/lista-empleados");
    }

}

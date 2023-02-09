package com.springmvc.contabilidad.service;

import com.springmvc.contabilidad.model.Employee;
import com.springmvc.contabilidad.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.sql.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class EmployeeService {

    EmployeeRepository employeeRepository;


    public List<Employee> getEmployees() {

        return this.employeeRepository.findAll();

    }

    public Employee getEmployee(long id) {

        return this.employeeRepository.findById(id).get();

    }

    public Employee getEmployeeByEmail(String email){

        return employeeRepository.findByEmail(email);

    }

    public Employee saveEmployee(Employee newEmployee) {

        long millis=System.currentTimeMillis();

        newEmployee.setDateCreation(new Date(millis));

        return this.employeeRepository.save(newEmployee);

    }

    public void updateEmployee(long id, Employee newEmployee) {

        Employee EmployeeUpdate = this.employeeRepository.findById(id).get();

        if (this.employeeRepository.findById(id).isPresent()) {

            long millis=System.currentTimeMillis();

            if (newEmployee.getName() != null) EmployeeUpdate.setName(newEmployee.getName());

            if (newEmployee.getEmail() != null) EmployeeUpdate.setEmail(newEmployee.getEmail());

            newEmployee.setDateUpdate(new Date(millis));

            this.employeeRepository.save(EmployeeUpdate);
        }
    }

    public void deleteEmployee(long id) {

        this.employeeRepository.deleteById(id);

    }
}

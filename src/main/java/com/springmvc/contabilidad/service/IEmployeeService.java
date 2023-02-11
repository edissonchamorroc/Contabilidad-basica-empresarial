package com.springmvc.contabilidad.service;

import com.springmvc.contabilidad.model.Employee;

import java.util.List;

public interface IEmployeeService  {

    public List<Employee> getEmployees();

    public Employee getEmployee(long id);

    public Employee getEmployeeByEmail(String email);

    public Employee saveEmployee(Employee newEmployee) ;

    public void updateEmployee(long id, Employee newEmployee) ;

    public void deleteEmployee(long id) ;
}

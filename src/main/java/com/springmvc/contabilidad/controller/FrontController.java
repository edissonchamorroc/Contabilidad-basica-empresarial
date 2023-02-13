package com.springmvc.contabilidad.controller;


import com.springmvc.contabilidad.model.Employee;
import com.springmvc.contabilidad.model.Enterprise;
import com.springmvc.contabilidad.model.Transaction;
import com.springmvc.contabilidad.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class FrontController {

    @Autowired
    EnterpriseService enterpriseService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    TransactionService transactionService;
    @Autowired
    PefilService pefilService;
    @Autowired
    IMyUserDetailsService userDetailsService;

    @GetMapping(value = {"/login"})
    public String login(Model model) {

        return "login";
    }

    @GetMapping(value = {"/", "/home"})
    public String home(Model model) {

        model.addAttribute("loginEmployee",
                this.employeeService.getEmployee(userDetailsService.getUserDetailsService().getId()));

        model.addAttribute("enterprises",this.enterpriseService.getEnterprises());

        return "index";
    }

    //-------- mapping para empleados en front

    @GetMapping("/lista-empleados")
    public String getEmployees(Model model) {

        model.addAttribute("loginEmployee",
                this.employeeService.getEmployee(userDetailsService.getUserDetailsService().getId()));

        model.addAttribute("employees", this.employeeService.getEmployees());

        return "lista_empleados";
    }

    @GetMapping("/registro-empleado")
    public String postEmployee(Model model) {

        model.addAttribute("employee", new Employee());

        model.addAttribute("enterprises", this.enterpriseService.getEnterprises());

        model.addAttribute("roles",this.pefilService.getRoles());

        return "registro_empleado";
    }

    @GetMapping("/modificar-empleado/{id}")
    public String patchEmployee(@PathVariable("id") long id, Model model) {

        model.addAttribute("employee", employeeService.getEmployee(id));

        model.addAttribute("enterprises", this.enterpriseService.getEnterprises());

        model.addAttribute("roles",this.pefilService.getRoles());

        this.employeeService.updateEmployee(id, employeeService.getEmployee(id));

        return "registro_empleado";
    }

    @GetMapping("/eliminar-empleado/{id}")
    public String deleteEmployee(@PathVariable("id") long id, Model model) {

        this.employeeService.deleteEmployee(id);

        model.addAttribute("employees", this.employeeService.getEmployees());

        return"lista-empresas";
    }


    //---------- mapping para empresas en front


    @GetMapping("/lista-empresas")

    public String getEnterprises(Model model) {

        model.addAttribute("loginEmployee",
                this.employeeService.getEmployee(userDetailsService.getUserDetailsService().getId()));

        model.addAttribute("enterprises", this.enterpriseService.getEnterprises());

        return "lista_empresas";
    }

    @GetMapping("/registro-empresa")
    public String postEnterprise(Model model) {

        model.addAttribute("enterprise", new Enterprise());

        return "registro_empresa";
    }

    @GetMapping("/modificar-empresa/{id}")
    public String patchEnterprise(@PathVariable("id") long id, Model model) {

        model.addAttribute("enterprise", this.enterpriseService.getEnterprise(id));

        this.enterpriseService.updateEnterprise(id, this.enterpriseService.getEnterprise(id));

        return "registro_empresa";
    }


    @GetMapping("/eliminar-empresa/{id}")
    public String deleteEnterprise(@PathVariable("id") long id, Model model) {

        this.enterpriseService.deleteEnterprise(id);

        model.addAttribute("enterprises", this.enterpriseService.getEnterprises());

        return "lista_empresas";
    }



    //-------- mapping para movimientos en front

    @GetMapping("/registro-movimiento")
    public String postTransactions(Model model){

        model.addAttribute("loginEmployee",
                this.employeeService.getEmployee(userDetailsService.getUserDetailsService().getId()));

        model.addAttribute("transaction",new Transaction());

        return "registro_transaccion";
    }

    @GetMapping("/lista-movimientos")
    public String getTransactions(Model model){

        model.addAttribute("loginEmployee",
                this.employeeService.getEmployee(userDetailsService.getUserDetailsService().getId()));

        model.addAttribute("transactions",this.transactionService.getTransactions());
        return "lista_transacciones";
    }

    @GetMapping("/modificar-movimiento/{id}")
    public String patchTransaction(@PathVariable("id") long id,Model model){

        model.addAttribute("transaction",this.transactionService.getTransaction(id));

        this.transactionService.updateTransaction(id,this.transactionService.getTransaction(id));

        return "registro_transaccion";
    }


    @GetMapping("/eliminar-movimiento/{id}")
    public String deleteTransaction(@PathVariable("id") long id, Model model){

        this.transactionService.deleteTransaction(id);

        model.addAttribute("transaction",this.transactionService.getTransactions());
        return "lista_transacciones";
    }


}

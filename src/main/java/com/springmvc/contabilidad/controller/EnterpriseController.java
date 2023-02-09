package com.springmvc.contabilidad.controller;


import com.springmvc.contabilidad.model.Enterprise;
import com.springmvc.contabilidad.model.Transaction;
import com.springmvc.contabilidad.service.EnterpriseService;
import com.springmvc.contabilidad.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController()
@RequestMapping("/enterprises")
public class EnterpriseController {

    @Autowired
    EnterpriseService enterpriseService;
    @Autowired
    TransactionService transactionService;



    @PostMapping("")
    public RedirectView postEnterprise(@ModelAttribute Enterprise newEnterprise) {

        this.enterpriseService.saveEnterprise(newEnterprise);

        return new RedirectView("/lista-empresas");
    }



    //--------------Servicios para movimiento de dinero---------------------------



    @PostMapping("/transaction")
    public RedirectView postTransaction(@ModelAttribute Transaction newTransaction) {

        this.transactionService.saveTransaction(newTransaction);

        return new RedirectView("/lista-movimientos");
    }




}

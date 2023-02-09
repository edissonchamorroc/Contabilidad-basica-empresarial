package com.springmvc.contabilidad.controller;


import com.springmvc.contabilidad.model.Enterprise;
import com.springmvc.contabilidad.model.Transaction;
import com.springmvc.contabilidad.service.EnterpriseService;
import com.springmvc.contabilidad.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

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

package com.springmvc.contabilidad.service;

import com.springmvc.contabilidad.model.Enterprise;
import com.springmvc.contabilidad.repository.EnterpriseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class EnterpriseService {

    EnterpriseRepository enterpriseRepository;

    public List<Enterprise> getEnterprises() {

        return this.enterpriseRepository.findAll();

    }

    public Enterprise getEnterprise(long id) {

        return this.enterpriseRepository.findById(id).get();

    }

    public Enterprise saveEnterprise(Enterprise newEnterprise) {

        newEnterprise.setDateCreation(new Date(System.currentTimeMillis()));

        return this.enterpriseRepository.save(newEnterprise);

    }

    public void updateEnterprise(long id, Enterprise newEnterprise) {


        if (this.enterpriseRepository.findById(id).isPresent()) {

            Enterprise enterprise = this.enterpriseRepository.findById(id).get();

            enterprise.setDateUpdate(new Date(System.currentTimeMillis()));

            if (newEnterprise.getAdress() != null) enterprise.setAdress(newEnterprise.getAdress());
            if (newEnterprise.getNit() != null) enterprise.setNit(newEnterprise.getNit());
            if (newEnterprise.getName() != null) enterprise.setName(newEnterprise.getName());

            this.enterpriseRepository.save(enterprise);

        }
    }

    public void deleteEnterprise(long id) {

        this.enterpriseRepository.deleteById(id);

    }
}

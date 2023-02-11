package com.springmvc.contabilidad.service;

import com.springmvc.contabilidad.model.Enterprise;

import java.util.List;

public interface IEnterpriseService {

    public List<Enterprise> getEnterprises() ;

    public Enterprise getEnterprise(long id) ;

    public Enterprise saveEnterprise(Enterprise newEnterprise) ;

    public void updateEnterprise(long id, Enterprise newEnterprise) ;

    public void deleteEnterprise(long id) ;
}

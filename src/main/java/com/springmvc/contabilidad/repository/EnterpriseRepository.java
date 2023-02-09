package com.springmvc.contabilidad.repository;

import com.springmvc.contabilidad.model.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnterpriseRepository extends JpaRepository<Enterprise,Long> {

}

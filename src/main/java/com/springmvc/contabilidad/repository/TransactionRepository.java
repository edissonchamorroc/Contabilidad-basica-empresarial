package com.springmvc.contabilidad.repository;

import com.springmvc.contabilidad.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {

}

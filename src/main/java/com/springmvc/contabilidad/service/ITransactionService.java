package com.springmvc.contabilidad.service;

import com.springmvc.contabilidad.model.Transaction;

import java.util.List;

public interface ITransactionService {

    public List<Transaction> getTransactions() ;

    public Transaction getTransaction(long id);

    public Transaction saveTransaction(Transaction newTransaction) ;

    public void updateTransaction(long id, Transaction newTransaction) ;

    public void deleteTransaction(long id) ;
}

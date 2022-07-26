package com.api.rest.springboot.webflux.transaction.service;

import com.api.rest.springboot.webflux.transaction.model.Transaction;
import com.api.rest.springboot.webflux.transaction.util.Crud;

import reactor.core.publisher.Flux;

public interface TransactionService extends Crud<Transaction, String>{

  public Flux<Transaction> byDocumentNumber(String documentNumber);
}

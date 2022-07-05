package com.api.rest.springboot.webflux.transaction.service;

import com.api.rest.springboot.webflux.transaction.model.Transaction;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransactionService {
  
  public Flux<Transaction> findAll();

  public Mono<Transaction> findById(String id);

  public Mono<Transaction> save(Transaction transaction);
  
  public Mono<Void> delete(Transaction transaction);

}

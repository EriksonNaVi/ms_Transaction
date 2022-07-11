package com.api.rest.springboot.webflux.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rest.springboot.webflux.transaction.model.Transaction;
import com.api.rest.springboot.webflux.transaction.repository.TransactionRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TransactionServiceImpl implements TransactionService{
  
  @Autowired
  TransactionRepository transactionRepository;

  @Override
  public Flux<Transaction> findAll() {
    
    return transactionRepository.findAll();
  }

  @Override
  public Mono<Transaction> findById(String id) {
    
    return transactionRepository.findById(id);
  }

  @Override
  public Mono<Transaction> save(Transaction transaction) {
    
    return transactionRepository.save(transaction);
  }

  @Override
  public Mono<Void> delete(Transaction transaction) {
    
    return transactionRepository.delete(transaction);
  }

}

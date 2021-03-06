package com.api.rest.springboot.webflux.transaction.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import com.api.rest.springboot.webflux.transaction.model.Transaction;

import reactor.core.publisher.Flux;

@Repository
public interface TransactionRepository extends ReactiveMongoRepository<Transaction, String>{
  
  Flux<Transaction> findByDocumentNumber(String documentNumber);

}

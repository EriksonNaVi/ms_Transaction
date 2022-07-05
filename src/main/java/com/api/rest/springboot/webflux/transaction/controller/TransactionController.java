package com.api.rest.springboot.webflux.transaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.springboot.webflux.transaction.model.Transaction;
import com.api.rest.springboot.webflux.transaction.service.TransactionService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
  
  @Autowired
  private TransactionService transactionService;
  
  @GetMapping
  public Flux<Transaction> toList(){
      return transactionService.findAll();
  }
  
  @PostMapping
  public Mono<Transaction> register(@RequestBody Transaction transaction){
      return transactionService.save(transaction);
  }
  
  @GetMapping("/{id}")
  public Mono<ResponseEntity<Transaction>> listById(@PathVariable String id){
    return transactionService.findById(id).map(c -> ResponseEntity.ok()
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .body(c))
        .defaultIfEmpty(ResponseEntity.notFound().build());
  }

}

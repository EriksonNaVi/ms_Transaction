package com.api.rest.springboot.webflux.transaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.springboot.webflux.transaction.dto.TransactionDto;
import com.api.rest.springboot.webflux.transaction.resource.TransactionResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
  
  private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);
  
  @Autowired
  private TransactionResource transactionResource;
  
  @GetMapping
  public Flux<TransactionDto> toList(){
      return transactionResource.findAll();
  }
  
  @PostMapping
  public Mono<TransactionDto> createTransaction(@RequestBody TransactionDto transactionDto){
      return transactionResource.create(transactionDto);
  }
  
  @GetMapping("/{id}")
  public Mono<TransactionDto> listById(@PathVariable String id){
    return transactionResource.findById(id);
  }

}

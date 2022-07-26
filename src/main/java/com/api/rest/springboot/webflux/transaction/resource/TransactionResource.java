package com.api.rest.springboot.webflux.transaction.resource;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rest.springboot.webflux.transaction.dto.TransactionDto;
import com.api.rest.springboot.webflux.transaction.model.Transaction;
import com.api.rest.springboot.webflux.transaction.service.TransactionService;
import com.api.rest.springboot.webflux.transaction.util.MapperUtil;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TransactionResource extends MapperUtil {

  @Autowired
  TransactionService transactionService;

  public Flux<TransactionDto> findAll() {
    return transactionService.findAll().map(x -> map(x, TransactionDto.class));
  }

  public Mono<TransactionDto> create(TransactionDto transactionDto) {
    Transaction transaction = map(transactionDto, Transaction.class);
    transaction.setId(new ObjectId().toString());
    transaction.setCreatedDate(LocalDateTime.now());
    Mono<Transaction> entity = transactionService.save(transaction);
    return entity.map(x -> map(x, TransactionDto.class));
  }

  public Mono<TransactionDto> findById(String id) {
    return transactionService.findById(id).switchIfEmpty(Mono.error(new Exception()))
        .map(x -> map(x, TransactionDto.class));
  }

  public Mono<TransactionDto> update(TransactionDto transactionDto, String id) {
    return transactionService.findById(id).switchIfEmpty(Mono.error(new Exception())).flatMap(x -> {
      x.setAmount(transactionDto.getAmount());
      x.setDocumentType(transactionDto.getDocumentType());
      x.setDocumentNumber(transactionDto.getDocumentNumber());
      x.setTransactionType(transactionDto.getTransactionType());
      x.setComission(transactionDto.getComission());

      return transactionService.save(x).map(y -> map(y, TransactionDto.class));

    });
  }
  
  public Mono<Void> delete(String id){
    return transactionService.findById(id).switchIfEmpty(Mono.error(new Exception()))
        .flatMap(x -> transactionService.delete(x));
  }
  
  public Flux<TransactionDto> listByDocumentNumber(String documentNumber){
    return transactionService.byDocumentNumber(documentNumber).switchIfEmpty(Mono.error(new Exception()))
        .map(x -> map(x, TransactionDto.class));
  }

}

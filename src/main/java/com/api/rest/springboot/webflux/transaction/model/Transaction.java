package com.api.rest.springboot.webflux.transaction.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "transaction")
public class Transaction {
  
  @Id
  private String id;
  
  private Float amount;
  
  private String documentType;
  
  private String documentNumber;
  
  private String transactionType;
  
  private Float comission;
  
  @CreatedDate
  private LocalDateTime createdDate;
  
}

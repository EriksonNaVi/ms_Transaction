package com.api.rest.springboot.webflux.transaction.model;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "transaction")
public class Transaction {
  
  @Id
  private String id;
  
  @NotEmpty
  private Float amount;
  
  @NotEmpty
  private String documentType;
  
  @NotEmpty
  private String documentNumber;
  
  @NotEmpty
  private String transactionType;
  
  private Float comission;
  
  @CreatedDate
  private LocalDateTime createdDate;
  
}

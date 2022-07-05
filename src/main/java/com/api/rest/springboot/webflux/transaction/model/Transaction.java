package com.api.rest.springboot.webflux.transaction.model;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "transaction")
public class Transaction {
  
  @Id
  private String id;
  
  @NotEmpty
  private float amount;
  
  @NotEmpty
  private String creditCardNumber;
  
  @NotEmpty
  private String documentNumber;
  
  @NotEmpty
  private String documentType;
  
  @NotEmpty
  private String transferType;

}

package com.api.rest.springboot.webflux.transaction.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TransactionDto {
  
  private String id;
  private Float amount;
  private String documentType;
  private String documentNumber;
  private String transactionType;
  private Float comission;
  private LocalDateTime createdDate;

}

package com.api.rest.springboot.webflux.transaction.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.api.rest.springboot.webflux.transaction.util.ValidationConstants;

import lombok.Data;

@Data
public class TransactionDto {
  
  private String id;
  @NotNull(message = ValidationConstants.NOT_NULL)
  private Float amount;
  @NotEmpty(message = ValidationConstants.NOT_EMPTY)
  private String documentType;
  @NotEmpty(message = ValidationConstants.NOT_EMPTY)
  private String documentNumber;
  @NotEmpty(message = ValidationConstants.NOT_EMPTY)
  private String transactionType;
  @NotNull(message = ValidationConstants.NOT_NULL)
  private Float comission;
  private LocalDateTime createdDate;

}

package com.wizy.bill.entity;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Bill {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Long accountId;
  private BigDecimal amount;
  private Boolean isDefault;
  private OffsetDateTime creationDate;
  private Boolean overdraftEnabled;

  public Bill(
      Long accountId,
      BigDecimal amount,
      Boolean isDefault,
      OffsetDateTime creationDate,
      Boolean overdraftEnabled) {
    this.accountId = accountId;
    this.amount = amount;
    this.isDefault = isDefault;
    this.creationDate = creationDate;
    this.overdraftEnabled = overdraftEnabled;
  }

  public Bill(Long accountId, BigDecimal amount, Boolean isDefault, Boolean overdraftEnabled) {
    this.accountId = accountId;
    this.amount = amount;
    this.isDefault = isDefault;
    this.overdraftEnabled = overdraftEnabled;
  }
}

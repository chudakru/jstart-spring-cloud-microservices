package com.wizy.bill.controller.dto;

import com.wizy.bill.entity.Bill;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BillResponseDto {

  private Long billId;

  private Long accountId;

  private BigDecimal amount;

  private Boolean isDefault;

  private OffsetDateTime creationDate;

  private Boolean overdraftEnabled;

  public BillResponseDto(Bill bill) {
    billId = bill.getId();
    accountId = bill.getAccountId();
    amount = bill.getAmount();
    isDefault = bill.getIsDefault();
    creationDate = bill.getCreationDate();
    overdraftEnabled = bill.getOverdraftEnabled();
  }
}

package com.wizy.account.controller.dto;

import com.wizy.account.entity.Account;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
public class AccountResponseDto {

  private Long id;
  private String name;
  private String email;
  private String phone;
  private OffsetDateTime creationDate;
  private List<Long> bills;

  public AccountResponseDto(Account account) {
    this.id = account.getId();
    this.name = account.getName();
    this.email = account.getEmail();
    this.phone = account.getPhone();
    this.creationDate = account.getCreationDate();
    this.bills = account.getBills();
  }

}

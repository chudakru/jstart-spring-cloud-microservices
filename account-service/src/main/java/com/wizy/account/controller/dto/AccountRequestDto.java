package com.wizy.account.controller.dto;

import java.time.OffsetDateTime;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class AccountRequestDto {

  private String name;
  private String email;
  private String phone;
  private OffsetDateTime creationDate;
  private List<Long> bills;

}

package com.wizy.account.controller;

import com.wizy.account.controller.dto.AccountRequestDto;
import com.wizy.account.controller.dto.AccountResponseDto;
import com.wizy.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

  private final AccountService accountService;

  @Autowired
  public AccountController(AccountService accountService) {
    this.accountService = accountService;
  }

  @GetMapping("/{accountId}")
  public AccountResponseDto getAccount(@PathVariable Long accountId) {
    return new AccountResponseDto(accountService.getById(accountId));
  }

  @PostMapping("/")
  public Long createAccount(@RequestBody AccountRequestDto accountRequestDto) {
    return accountService.create(
        accountRequestDto.getName(),
        accountRequestDto.getEmail(),
        accountRequestDto.getPhone(),
        accountRequestDto.getBills());
  }

  @PutMapping("/{accountId}")
  public AccountResponseDto updateAccount(
      @PathVariable Long accountId, @RequestBody AccountRequestDto accountRequestDto) {
    return new AccountResponseDto(
        accountService.update(
            accountId,
            accountRequestDto.getName(),
            accountRequestDto.getEmail(),
            accountRequestDto.getPhone(),
            accountRequestDto.getBills()));
  }

  @DeleteMapping("/{accountId}")
  public AccountResponseDto deleteAccount(@PathVariable Long accountId) {
    return new AccountResponseDto(accountService.delete(accountId));
  }
}

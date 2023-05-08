package com.wizy.account.service;

import com.wizy.account.entity.Account;
import com.wizy.account.exception.AccountNotFoundException;
import com.wizy.account.repository.AccountRepository;
import java.time.OffsetDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

  private final AccountRepository accountRepository;

  @Autowired
  public AccountService(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  public Account getById(Long accountId) {
    return accountRepository
        .findById(accountId)
        .orElseThrow(
            () -> new AccountNotFoundException("Enable to find account with id: " + accountId));
  }

  public Long create(String name, String email, String phone, List<Long> bills) {
    final Account account = new Account(name, email, phone, OffsetDateTime.now(), bills);
    return accountRepository.save(account).getId();
  }

  public Account update(Long accountId, String name, String email, String phone, List<Long> bills) {
    final Account account = new Account();
    account.setId(accountId);
    account.setName(name);
    account.setEmail(email);
    account.setPhone(phone);
    account.setBills(bills);
    return accountRepository.save(account);
  }

  public Account delete(Long accountId) {
    final Account deletedAccount = getById(accountId);
    accountRepository.delete(deletedAccount);
    return deletedAccount;
  }
}

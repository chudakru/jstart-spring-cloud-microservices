package com.wizy.bill.service;

import com.wizy.bill.entity.Bill;
import com.wizy.bill.exception.BillNotFoundException;
import com.wizy.bill.repository.BillRepository;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import org.springframework.stereotype.Service;

@Service
public class BillService {

  private final BillRepository billRepository;

  public BillService(BillRepository billRepository) {
    this.billRepository = billRepository;
  }

  public Bill getById(Long billId) {
    return billRepository
        .findById(billId)
        .orElseThrow(() -> new BillNotFoundException("Unable to find bill with id: " + billId));
  }

  public Long create(
      Long accountId, BigDecimal amount, Boolean isDefault, Boolean overdraftEnabled) {
    final Bill bill =
        new Bill(accountId, amount, isDefault, OffsetDateTime.now(), overdraftEnabled);
    return billRepository.save(bill).getId();
  }

  public Bill update(
      Long billId, Long accountId, BigDecimal amount, Boolean isDefault, Boolean overdraftEnabled) {
    final Bill bill = new Bill(accountId, amount, isDefault, overdraftEnabled);
    bill.setId(billId);
    return billRepository.save(bill);
  }

  public Bill delete(Long accountId) {
    final Bill bill = getById(accountId);
    billRepository.delete(bill);
    return bill;
  }
}

package com.wizy.bill.exception;

public class BillNotFoundException extends RuntimeException {

  public BillNotFoundException(String message) {
    super(message);
  }
}

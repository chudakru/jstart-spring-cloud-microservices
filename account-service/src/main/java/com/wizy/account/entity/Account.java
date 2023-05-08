package com.wizy.account.entity;

import java.time.OffsetDateTime;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Account {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String email;
  private String phone;
  private OffsetDateTime creationDate;
  @ElementCollection private List<Long> bills;

  public Account(
      String name, String email, String phone, OffsetDateTime creationDate, List<Long> bills) {
    this.name = name;
    this.email = email;
    this.phone = phone;
    this.creationDate = creationDate;
    this.bills = bills;
  }
}

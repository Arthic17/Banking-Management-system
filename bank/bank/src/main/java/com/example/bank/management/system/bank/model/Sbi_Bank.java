package com.example.bank.management.system.bank.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;
@Entity
@Table(name="Sbi_Bank")
@Data
public class Sbi_Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long account_number;
    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    double account_bal;
    @Column(nullable = false)
    BigInteger ph_no;


}

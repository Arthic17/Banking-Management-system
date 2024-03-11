package com.example.bank.management.system.bank.controller;

import com.example.bank.management.system.bank.model.Sbi_Bank;
import com.example.bank.management.system.bank.model.WithDrawal;
import com.example.bank.management.system.bank.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class BankController {
    @Autowired
    BankService bankService;
    @PostMapping("/accountcreation")
    public ResponseEntity<Sbi_Bank> acc_creation(@RequestBody Sbi_Bank sbi_bank){
        return new ResponseEntity<Sbi_Bank>(bankService.account_creation(sbi_bank), HttpStatus.CREATED);
    }
    @PutMapping("/withdrawal")
    public ResponseEntity<Sbi_Bank> amt_withdrawal(@RequestBody WithDrawal withDrawal){
        return new ResponseEntity<Sbi_Bank>(bankService.amount_withdrawal(withDrawal), HttpStatus.ACCEPTED);
    }
}

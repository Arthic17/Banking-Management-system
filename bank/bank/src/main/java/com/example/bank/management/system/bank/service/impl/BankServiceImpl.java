package com.example.bank.management.system.bank.service.impl;

import com.example.bank.management.system.bank.exception.UserNotFoundException;
import com.example.bank.management.system.bank.model.Sbi_Bank;
import com.example.bank.management.system.bank.model.WithDrawal;
import com.example.bank.management.system.bank.repository.BankRepository;
import com.example.bank.management.system.bank.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankServiceImpl implements BankService{
    @Autowired
    BankRepository bankRepository;

    @Override
    public Sbi_Bank amount_withdrawal(WithDrawal withDrawal) {
       Sbi_Bank sbi_bank= bankRepository.findById(withDrawal.getAccount_num()).
                orElseThrow(() -> new UserNotFoundException
                        (withDrawal.getAccount_num().toString()));
                if(sbi_bank.getAccount_bal()>withDrawal.getWith_drawal()){
                    double updated_bal = sbi_bank.getAccount_bal()-withDrawal.getWith_drawal();
                    sbi_bank.setAccount_bal(updated_bal);
                     bankRepository.save(sbi_bank);
                }
        return sbi_bank;

    }

    @Override
    public Sbi_Bank account_creation(Sbi_Bank sbi_bank) {
        return bankRepository.save(sbi_bank);
        //return sbi_bank;
    }
}

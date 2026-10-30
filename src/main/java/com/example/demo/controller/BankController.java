package com.example.demo.controller;

import com.example.demo.model.BankCustomer;
import com.example.demo.service.BankAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bank")
public class BankController {

    private final BankAccountService bankAccountService ;

    public BankController(BankAccountService bankAccountService ) {
        this.bankAccountService = bankAccountService;
    }


    // Create Account
    @PostMapping
    public ResponseEntity<BankCustomer> createAccount( @RequestBody BankCustomer customer) {

        BankCustomer saved = bankAccountService.createAccount(customer);

        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // Get All Accounts
    @GetMapping
    public List<BankCustomer> getAllAccounts() {
        return bankAccountService.getAllAccounts();
    }

    // Find Account by Account Number
    @GetMapping("/{accountNumber}")
    public ResponseEntity<BankCustomer> findByID(
            @PathVariable Long accountNumber) {

        return bankAccountService.findByID(accountNumber).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Update Account Details
    @PutMapping
    public String updateAccount(@RequestBody BankCustomer customer) {
        return bankAccountService.updateAccount(customer);
    }


    // Delete Account
    @DeleteMapping("/{accountNumber}")
    public String deleteAccount(@PathVariable Long accountNumber) {
        return bankAccountService.deleteAccount(accountNumber);
    }

    // check balance using account number
    @GetMapping("/{accountNumber}/balance")
    public double getBalance(@PathVariable long accountNumber) {
        return bankAccountService.getBalance(accountNumber);
    }

}

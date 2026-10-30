package com.example.demo.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Table(name="bank")
@Entity
public class BankCustomer {
    @Id
    @Column
    long accountNumber;
    @Column
    String name;
    @Column
    long phoneNumber;
    @Column
    double bankBalance;
public double getBalance(){
    return bankBalance;
}
public void setBalance(double bankBalance){
    this.bankBalance=bankBalance;
}
}

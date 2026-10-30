package com.example.demo.repository;

import com.example.demo.model.BankCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BankDBRepository extends JpaRepository<BankCustomer, Long> {
    @Query(value="select bank_balance from bank where account_number=:acc", nativeQuery = true)
    double getBankBalance(@Param("acc") long accountNumber);
    @Transactional
    @Modifying
    @Query(value="update bank set bank_balance=:balance where account_number=:acc", nativeQuery = true)
    void updateBalance(@Param("balance")double newBalance, @Param("acc") long accountNumber);
}
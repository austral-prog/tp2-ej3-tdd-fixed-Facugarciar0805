package com.template;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static com.template.App.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    @Test
    void testDeposit() {
        Map<String, Integer> accounts = Map.of("mati", 10, "jaun", 20);
        Map<String, Integer> updatedAccounts = deposit(accounts, "mati", 5);
        assertEquals(15, updatedAccounts.get("mati"));
    }
    @Test
    void testUnknownDeposit(){
        Map<String, Integer> accounts = Map.of("mati", 10, "jaun", 20);
        Map<String, Integer> updatedAccounts = deposit(accounts, "pedro", 5);
        assertEquals(accounts, updatedAccounts);
    }
    @Test
    void testNullDeposit(){
        Map<String, Integer> accounts = Map.of("mati", 10, "jaun", 20);
        Map<String, Integer> updatedAccounts = deposit(accounts, "mati", -5);
        assertEquals(accounts, updatedAccounts);
    }
    @Test
    void testWithdrawal(){
        Map<String, Integer> accounts = Map.of("mati", 10, "jaun", 20);
        Map<String, Integer> updatedAccounts = withdraw(accounts, "jaun", 5);
        assertEquals(15, updatedAccounts.get("jaun"));
    }
    @Test
    void testUnknownWithdrawal(){
        Map<String, Integer> accounts = Map.of("mati", 10, "jaun", 20);
        Map<String, Integer> updatedAccounts = withdraw(accounts, "pedro", 5);
        assertEquals(accounts, updatedAccounts);
    }
    @Test
    void testNullWithdrawal(){
        Map<String, Integer> accounts = Map.of("mati", 10, "jaun", 20);
        Map<String, Integer> updatedAccounts = withdraw(accounts, "jaun", -5);
        assertEquals(accounts, updatedAccounts);
    }
    @Test
    void TestNoBalanceWithdrawal(){
        Map<String, Integer> accounts = Map.of("mati", 0, "jaun", 20);
        Map<String, Integer> updatedAccounts = withdraw(accounts, "mati", 5);
        assertEquals(accounts, updatedAccounts);
    }
    @Test
    void TestTransfer(){
        Map<String, Integer> accounts = Map.of("mati", 10, "jaun", 20);
        Map<String, Integer> updatedAccounts = transfer(accounts, "jaun", "mati", 5);
        assertEquals(15, updatedAccounts.get("mati"));
        assertEquals(15, updatedAccounts.get("jaun"));
    }
    @Test
    void TestUnknownTransfer(){
        Map<String, Integer> accounts = Map.of("mati", 10, "jaun", 20);
        Map<String, Integer> updatedAccounts = transfer(accounts, "jaun", "pedro", 5);
        assertEquals(accounts, updatedAccounts);
    }
    @Test
    void TestRecursiveTransfer(){
        Map<String, Integer> accounts = Map.of("mati", 10, "jaun", 20);
        Map<String, Integer> updatedAccounts = transfer(accounts, "mati", "mati", 5);
        assertEquals(accounts, updatedAccounts);
    }
    @Test
    void Nulltransfer(){
        Map<String, Integer> accounts = Map.of("mati", 10, "jaun", 20);
        Map<String, Integer> updatedAccounts = transfer(accounts, "jaun", "mati", -5);
        assertEquals(accounts, updatedAccounts);
    }
    @Test
    void TestNoBalance(){
        Map<String, Integer> accounts = Map.of("mati", 10, "jaun", 20);
        Map<String, Integer> updatedAccounts = withdraw(accounts, "jaun", 25);
        assertEquals(accounts, updatedAccounts);
    }


}

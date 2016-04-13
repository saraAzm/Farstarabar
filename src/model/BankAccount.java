package model;


import java.time.LocalDate;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aardwolf
 */
public class BankAccount {
    public String bank;
    public String type;
    public String accountNumber;
    private String cartNumber;
    private LocalDate accountInitiation;
    private int value;
    private int ID;

    public BankAccount(String bk, String tp, String accNum, String cartNum, LocalDate accInit, int val) {
        this.bank = bk;
        this.type = tp;
        this.accountNumber = accNum;
        this.cartNumber = cartNum;
        this.accountInitiation = accInit;
        this.value = val;
        this.ID = Database.database.addAccount(this);
    }
    
    public BankAccount(String bk, String tp, String accNum, String cartNum, 
            LocalDate accInit, int val, boolean flag) {
        this.bank = bk;
        this.type = tp;
        this.accountNumber = accNum;
        this.cartNumber = cartNum;
        this.accountInitiation = accInit;
        this.value = val;
        if(flag)
            this.ID = Database.database.addAccount(this);
    }
    
    public String toString(){
        return this.bank.concat(" ").concat(this.accountNumber);
    }
    
    public void doTrans(BankAccount to, int cost){
        
        this.value = this.value - cost;
        to.value = to.value + cost;
    }
    
    public String getBank() {
        return bank;
    }

    public String getType() {
        return type;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCartNumber() {
        return cartNumber;
    }

    public LocalDate getAccountInitiation() {
        return accountInitiation;
    }

    public int getValue() {
        return value;
    }

    public int getID() {
        return ID;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setCartNumber(String cartNumber) {
        this.cartNumber = cartNumber;
    }

    public void setAccountInitiation(LocalDate accountInitiation) {
        this.accountInitiation = accountInitiation;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    public void addValue(double dd){
        this.value += dd;
    }
    
    
}

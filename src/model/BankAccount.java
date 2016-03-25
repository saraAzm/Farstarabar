package model;


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
    private String bank;
    private String type;
    private String accountNumber;
    private String cartNumber;
    private Date accountInitiation;
    private int value;
    private int ID;

    public BankAccount(String bk, String tp, String accNum, String cartNum, Date accInit, int val) {
        this.bank = bk;
        this.type = tp;
        this.accountNumber = accNum;
        this.cartNumber = cartNum;
        this.accountInitiation = accInit;
        this.value = val;
        Database.database.addAccount(this);
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

    public Date getAccountInitiation() {
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

    public void setAccountInitiation(Date accountInitiation) {
        this.accountInitiation = accountInitiation;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    
    
    
}

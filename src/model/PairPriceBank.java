/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Aardwolf
 */
public class PairPriceBank {
    private int price;
    private BankAccount bank;
    private int ID;
    
    
    
    public PairPriceBank(int pp, BankAccount bb){
        this.bank = bb;
        this.price = pp;
    }
    
    public int getPrice() {
        return price;
    }

    public BankAccount getBank() {
        return bank;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setBank(BankAccount bank) {
        this.bank = bank;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    
}

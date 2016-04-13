package model;

import java.time.LocalDate;
import java.util.ArrayList;
import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aardwolf
 */
public class Transaction {
    private ArrayList<PairPriceBank> fromBank = new ArrayList();
    private ArrayList<PairPriceBank> toBank = new ArrayList(); 
    private int ID;
    private LocalDate dateTrans;
    private String type;
    private String description;
    private String FactorNumber;
    
    public Transaction(ArrayList<PairPriceBank> To, ArrayList<PairPriceBank> From, 
                        String ttype, int id, LocalDate date, String desc, String ffnumber){
        this.fromBank = From;
        this.toBank = To;
        this.type = ttype;
        this.ID = id;
        this.dateTrans = date;
        this.description = desc;
        this.FactorNumber = ffnumber;
        for(int i=0; i<To.size(); i++){
            PairPriceBank x = To.get(i);
            x.getBank().addValue(x.getPrice());
        }
        for(int i=0; i<From.size(); i++){
            PairPriceBank x = From.get(i);
            x.getBank().addValue(-1 * x.getPrice());
        }
        Database.database.addTransaction(this);
    }
    
    public Transaction(ArrayList<PairPriceBank> To, ArrayList<PairPriceBank> From, 
                        String ttype, int id, LocalDate date, String desc,
                        String ffnumber, boolean flag){
        this.fromBank = From;
        this.toBank = To;
        this.type = ttype;
        this.ID = id;
        this.dateTrans = date;
        this.description = desc;
        this.FactorNumber = ffnumber;
        for(int i=0; i<To.size(); i++){
            PairPriceBank x = To.get(i);
            x.getBank().addValue(x.getPrice());
        }
        for(int i=0; i<From.size(); i++){
            PairPriceBank x = From.get(i);
            x.getBank().addValue(-1 * x.getPrice());
        }
        if(flag)
            Database.database.addTransaction(this);
    }
    
    public void setFromBank(ArrayList<PairPriceBank> fromBank) {
        this.fromBank = fromBank;
    }

    public void setToBank(ArrayList<PairPriceBank> toBank) {
        this.toBank = toBank;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setDateTrans(LocalDate dateTrans) {
        this.dateTrans = dateTrans;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFactorNumber(String FactorNumber) {
        this.FactorNumber = FactorNumber;
    }

    public ArrayList<PairPriceBank> getFromBank() {
        return fromBank;
    }

    public ArrayList<PairPriceBank> getToBank() {
        return toBank;
    }

    public int getID() {
        return ID;
    }

    public LocalDate getDateTrans() {
        return dateTrans;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getFactorNumber() {
        return FactorNumber;
    }
    
    
    
}

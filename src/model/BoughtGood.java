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
public class BoughtGood {
    private Good gd;
    private int cn;
    private double eachPrice;
    // it has foreign id from factor.

    public BoughtGood(Good g, int cont, double pr){
        this.gd = g;
        this.cn = cont;
        this.eachPrice = pr;
        //Database.database.addBoughtGoods(this);
    }
    
    public double getEachPrice() {
        return eachPrice;
    }

    public void setEachPrice(double eachPrice) {
        this.eachPrice = eachPrice;
    }

    public Good getGood() {
        return gd;
    }

    public int getCount() {
        return cn;
    }

    public void setGood(Good gd) {
        this.gd = gd;
    }

    public void setCount(int cn) {
        this.cn = cn;
    }
    
    
}

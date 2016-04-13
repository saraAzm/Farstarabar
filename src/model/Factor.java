package model;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aardwolf
 */
public class Factor {
    private ArrayList<BoughtGood> goods;
    private String desc;
    private double finalPrice;
    
    public ObservableList<BoughtGood> getObservablesGoods(){
        ObservableList<BoughtGood> gd = FXCollections.observableArrayList(this.getBoughtGoods());
        return gd;
    }
    
    public ArrayList<BoughtGood> getBoughtGoods(){
        return this.goods;
    }
    
    public void addBoughtGood(BoughtGood gd){
        this.goods.add(gd);
    }
    
}

package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aardwolf
 */
public class Good {
    private String name = new String("No Name");
    private String n2;
    private String description;
    private String ID;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Good(String n1, String n2, String ds){
        this.name = n1;
        this.n2 = n2;
        this.description = ds;
        Database.database.addGood(this);
    }
    
    public String toString(){
        return this.name;
    }
    
    public String getName() {
        return name;
    }

    public String getN2() {
        return n2;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setN2(String n2) {
        this.n2 = n2;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
}

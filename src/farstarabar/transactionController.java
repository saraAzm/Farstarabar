/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farstarabar;

import java.time.LocalDate;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.BankAccount;
import model.PairPriceBank;
import model.Transaction;

/**
 *
 * @author Aardwolf
 */
public class transactionController {
    
    private ArrayList<PairPriceBank> fromBank = new ArrayList();
    private ArrayList<PairPriceBank> toBank = new ArrayList();
    
    
    @FXML
    public ComboBox<BankAccount> from;
    @FXML
    public ComboBox<BankAccount> to;
    @FXML
    public ComboBox<String> ttypeCombo;
    @FXML
    public TextField valueFrom;
    @FXML
    public TextField valueTo;
    @FXML
    public DatePicker date;
    @FXML
    public TextArea desssc;
    @FXML
    public TextField idField;
    @FXML
    public Button transaction;
    
    @FXML
    public TableView<PairPriceBank> FromBank;
    @FXML
    public TableColumn<PairPriceBank, Double> priceFrom;
    @FXML
    public TableColumn<PairPriceBank, BankAccount> AccountFrom;
    
    @FXML
    public TableView<PairPriceBank> ToBank;
    @FXML
    public TableColumn<PairPriceBank, Double> priceTo;
    @FXML
    public TableColumn<PairPriceBank, BankAccount> AccountTo;
        
    
    
    public void updateList(){
        ObservableList<PairPriceBank> fromArr = FXCollections.observableArrayList(this.fromBank);
        ObservableList<PairPriceBank> toArr = FXCollections.observableArrayList(this.toBank);
        
        this.FromBank.setItems(fromArr);
        this.ToBank.setItems(toArr);
    }
    
    @FXML
    public void initialize(){
        
        this.from.setItems(Database.database.getObservalbleAccounts());
        this.to.setItems(Database.database.getObservalbleAccounts());
        this.date.setValue(LocalDate.now());
        ObservableList<String> tts = FXCollections.observableArrayList();
        tts.add("حواله");
        tts.add("نقدی");
        tts.add("چک");
        this.ttypeCombo.setItems(tts);
    }
    
    @FXML
    public void doTrans(){
         Transaction tr = new Transaction(toBank, fromBank, 
                 this.ttypeCombo.getValue(), Integer.valueOf(this.idField.getText()), 
                 this.date.getValue(), this.desssc.getText(), this.idField.getText());
         
    }
    
    @FXML
    public void addFromBank(){
        int pp = Integer.valueOf(this.valueFrom.getText());
        PairPriceBank x = new PairPriceBank(pp, this.from.getValue());
        this.fromBank.add(x);
        this.updateList();
    }
    
    @FXML
    public void addToBank(){
        int pp = Integer.valueOf(this.valueTo.getText());
        PairPriceBank x = new PairPriceBank(pp, this.to.getValue());
        this.toBank.add(x);
        this.updateList();
    }
}

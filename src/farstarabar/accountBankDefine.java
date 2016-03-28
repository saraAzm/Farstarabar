/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farstarabar;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.BankAccount;

/**
 *
 * @author Aardwolf
 */
public class accountBankDefine {
    @FXML
    private TextField bankName;
    
    @FXML
    private TextField type;
    
    @FXML
    private TextField accountNumber;
    
    @FXML
    private TextField cartNumber;
    
    @FXML
    private DatePicker initDatePicker;
    
    @FXML
    private TextField initValue;
    
    @FXML
    private void defineNewAccount(){
        BankAccount bna = new BankAccount(this.bankName.getText(), this.type.getText(),
                this.accountNumber.getText(), this.cartNumber.getText(), 
                this.initDatePicker.getValue(), Integer.valueOf(this.initValue.getText()));
        
    }
    
    @FXML
    private void initialize(){}
}

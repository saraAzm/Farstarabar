/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farstarabar;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Good;

/**
 *
 * @author Aardwolf
 */
public class defineGoodController {
    @FXML
    public TextField nameField;
    @FXML
    public TextField ds2Field;
    @FXML
    public TextArea desc1Field;
    
    @FXML
    public void initialize(){
    
    
    }
    
    @FXML
    public void defineNewGood(){
        Good gd = new Good(this.nameField.getText(), this.ds2Field.getText(), 
                    this.desc1Field.getText());
        
    }
    
}

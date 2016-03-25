/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farstarabar;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 *
 * @author Aardwolf
 */
public class CarDefineController {
    
    
    @FXML
    private TextField ensuranceNumber;
    
    @FXML
    private TextField serialNumber;
    
    @FXML
    private TextField carNumber;
    
    @FXML
    private ComboBox<String> driver;
    
    @FXML
    private DatePicker expireDate;
    
    @FXML
    private DatePicker initDate;
    
    @FXML
    private TextField ITINumber;
    
    @FXML
    private DatePicker ITIExpire;
    
    @FXML
    private TextField measureNumber;
    
    @FXML
    public void initialize(){}
    
    @FXML
    public void defineNewCar(){
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farstarabar;

import java.time.LocalDate;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.Person;

/**
 *
 * @author Aardwolf
 */
public class DriverDefineController {
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField cityField;
    @FXML
    private TextField phoneNumber;
    @FXML
    private DatePicker birthdayDatePicker;
    @FXML
    private TextField nationalCodeField;
    @FXML
    private TextField insuranceCodeField;
    @FXML
    private TextField descriptionField;
    
    @FXML
    public void newPerson(){
        // this is going to introduce a new person!
        Person p = new Person(this.firstNameField.getText(), this.lastNameField.getText(),
                this.nationalCodeField.getText(), this.phoneNumber.getText(),
                this.birthdayDatePicker.getValue(),
                this.descriptionField.getText());
        
    }
    
    public void initialize(){
        this.birthdayDatePicker.setValue(LocalDate.now());
        
    }
}

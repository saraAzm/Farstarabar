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
import model.Car;
import model.Person;

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
    private ComboBox<Person> driver;
    
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
    public void initialize(){
        this.driver.setItems(Database.database.getObservalblePersons());
    }
    
    @FXML
    public void defineNewCar(){
        Car cr = new Car(this.carNumber.getText(), this.serialNumber.getText(), this.ensuranceNumber.getText(), 
                        this.initDate.getValue(), this.expireDate.getValue(), this.ITINumber.getText(), 
                        this.ITIExpire.getValue(), this.measureNumber.getText(), this.driver.getValue(),
                        "des is not provided");
        
        // String pn, String ps, String ensrCode, LocalDate ensStDate, LocalDate ensEndDate,
                //String itiNm, LocalDate itiFnm, String measureCode, Person dr, String ds
        cr.setDriver(this.driver.getValue());
        
    }
}

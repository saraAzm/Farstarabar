/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farstarabar;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.Barname;
import model.Car;
import model.Person;

/**
 *
 * @author Aardwolf
 */
public class barnameController {
    @FXML
    private DatePicker initDateBox;
    @FXML
    private ComboBox<Car> carBox;
    @FXML
    private ComboBox<Person> ownerBox;
    @FXML
    private TextField destBox;
    @FXML
    private TextField sourceBox;
    @FXML
    private TextField bijakBox;
    @FXML
    private TextField distanceBox;
    @FXML
    private TextField sourceWeightBox;
    @FXML
    private TextField destWeightBox;
    @FXML
    private TextField priceBox;
    @FXML
    private Button createButton;
    
    @FXML
    private void initialize(){
        this.ownerBox.setItems(Database.database.getObservalblePersons());
        this.carBox.setItems(Database.database.getObservableCars());
    }
    
    @FXML
    public void createBarname(){
        Barname bar = new Barname(this.initDateBox.getValue(), 
                this.carBox.getValue(), this.ownerBox.getValue(),
                this.destBox.getText(), this.bijakBox.getText(),
                this.sourceBox.getText(), 
                Double.valueOf(this.distanceBox.getText()), 
                Double.valueOf(this.sourceWeightBox.getText()), 
                Double.valueOf(this.destWeightBox.getText()),
                Integer.valueOf(this.priceBox.getText()));
        
        //Barname(LocalDate initDate, Car car, Person own, String dst, 
                //String src, double dist, double wSrc, double wDest, int pr)
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farstarabar;

import java.time.LocalDate;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.BankAccount;
import model.Barname;
import model.Car;
import model.PairPriceBank;
import model.Person;
import model.Transaction;

/**
 *
 * @author Aardwolf
 */
public class MainPageController {
    private Farstarabar mainApp;
    
    @FXML
    public MenuItem definePerson;
    @FXML
    public MenuItem defineCar;
    @FXML
    public MenuItem defineBarname;
    @FXML
    public MenuItem defineAccount;
    @FXML
    public MenuItem defineTransaction;
    @FXML
    public MenuItem defineNewGood;
    
    
    @FXML
    public TableView<Person> personTable;
    @FXML
    public TableColumn<Person, String> firstNameColPersonTable;
    @FXML
    public TableColumn<Person, String> lastNameColPersonTable;
    @FXML
    public TextField personFirstNameField;
    @FXML
    public TextField personLastNameField;
    @FXML
    public TextField personNationCodeField;
    @FXML
    public TextField personPhoneNumberField;
    @FXML
    public TextField personDescriptionField;
    @FXML
    public DatePicker personBirthdayDatePicker;
    @FXML
    public Button personAccountStat;
    @FXML
    public Label personIDLabel;
    
    
    @FXML
    public TextField pelakField;
    @FXML
    public TextField pelakSeriesField;
    @FXML
    public TextField insuranceCodeField;
    @FXML
    public TextField itiCodeField;
    @FXML
    public TextField measureCodeField;
    @FXML
    public DatePicker insuranceStartDatePicker;
    @FXML
    public DatePicker insuranceFinishDatePicker;
    @FXML
    public DatePicker itiCodeDatePicker;
    @FXML
    public Label IDLabel;
    @FXML
    public ComboBox<Person> driversComboBox;
    @FXML
    public TableView<Car> carsTableView;
    @FXML
    public TableColumn<Car, String> carPelakCol;
    @FXML
    public TableColumn<Car, String> carPelakSeriesCol;
    @FXML
    public TableColumn<Car, String> carDriverNameCol;
    
    
    
    @FXML
    public TableView<Barname> barnameTable;
    @FXML
    public TableColumn<Barname, String> barnameNumberCol;
    @FXML
    public TableColumn<Barname, String> barnameCarCol;
    @FXML
    public TableColumn<Barname, String> barnameOwnerCol;
    @FXML
    public TableColumn<Barname, String> barnameDateCol;
    @FXML
    public ComboBox<Car> barnameCarFilterComboBox;
    @FXML
    public ComboBox<Person> barnameOwnerFilterComboBox;
    @FXML
    public DatePicker barnameFromFilterComboBox;
    @FXML
    public DatePicker barnameToFilterComboBox;
    @FXML
    public DatePicker barnameInitiateDatePicker;
    @FXML
    public ComboBox<Car> barnameCarCombo;
    @FXML
    public ComboBox<Person> barnamePersonsCombo;
    @FXML
    public TextField barnameDestTextField;
    @FXML
    public TextField barnameSourceTextField;
    @FXML
    public TextField barnameBijakTextField;
    @FXML
    public TextField barnameDistanceTextField;
    @FXML
    public TextField barnameWSrcTextField;
    @FXML
    public TextField barnameWDestTextField;
    @FXML
    public TextField barnamePrice;
    
    @FXML
    public TableView<BankAccount> bankTable;
    @FXML
    public TableColumn<BankAccount, String> bankNumberCol;
    @FXML
    public TableColumn<BankAccount, String> bankBankCol;
    @FXML
    public TableColumn<BankAccount, String> bankTypeCol;
    @FXML
    public TableColumn<BankAccount, String> bankOwnerCol;
    @FXML
    public TextField bankBankField;
    @FXML
    public TextField bankTypeField;
    @FXML
    public TextField bankNumberField;
    @FXML
    public TextField bankCartNumberField;
    @FXML
    public DatePicker bankInitDatePicker;
    @FXML
    public TextField bankValue;
    
    
    @FXML
    public TableView<Transaction> transList;
    @FXML
    public TableColumn<Transaction, LocalDate> transColDate;
    @FXML
    public TableColumn<Transaction, String> transColFacNum;
    
    @FXML
    public TableView<PairPriceBank> transFromList;
    @FXML 
    public TableColumn<PairPriceBank, BankAccount> transColFromBank;
    @FXML
    public TableColumn<PairPriceBank, String> transColFromPrice;
    
    @FXML
    public TableView<PairPriceBank> transToList;
    @FXML 
    public TableColumn<PairPriceBank, BankAccount> transColToBank;
    @FXML
    public TableColumn<PairPriceBank, String> transColToPrice;
    
    @FXML
    public Label transId;
    @FXML
    public ComboBox<String> transtypes;
    @FXML
    public DatePicker transDate;
    @FXML
    public TextField transFactorNumber;
    @FXML
    public TextArea transDesc;
    @FXML
    public Button transSave;
    
    
    
    public void updateTransList(){
        transList.setItems(Database.database.getObservableTransactions());
    }
    
    public void updateTransAnchor(Transaction tr){
        
        transFromList.setItems(FXCollections.observableArrayList(tr.getFromBank()));
        
        transToList.setItems(FXCollections.observableArrayList(tr.getToBank()));
        transId.setText(String.valueOf(tr.getID()));
        transDate.setValue(tr.getDateTrans());
        transFactorNumber.setText(tr.getFactorNumber());
        transDesc.setText(tr.getDescription());
        
    }
    
    
    public void updateCarList(){
        carsTableView.setItems(Database.database.getObservableCars());
    }
    
    public void updateCarAnchor(Car c){
        this.pelakField.setText(c.getPelakNumber());
        this.pelakSeriesField.setText(c.getPelakSeries());
        this.insuranceCodeField.setText(c.getEnsuranceCode());
        this.insuranceStartDatePicker.setValue(c.getStartDate());
        this.insuranceFinishDatePicker.setValue(c.getFinishDate());
        this.itiCodeField.setText(c.getITINumber());
        this.itiCodeDatePicker.setValue(c.getITIfinish());
        this.measureCodeField.setText(c.getMeasuranceCode());
        this.driversComboBox.setItems(Database.database.getObservalblePersons());
        this.driversComboBox.setValue(c.getDriver());
        System.out.println(c.getDriverName());
        this.IDLabel.setText(String.valueOf(c.getID()));
        
        
    }
    
    public void updatePersonList(){
        personTable.setItems(Database.database.getObservalblePersons());
    }
    
    public void updatePersonAnchor(Person p){
        this.personFirstNameField.setText(p.getFirstName());
        this.personLastNameField.setText(p.getLastName());
        this.personNationCodeField.setText(p.getNationCode());
        this.personPhoneNumberField.setText(p.getPhoneNumber());
        this.personDescriptionField.setText(p.getDesc());
        this.personBirthdayDatePicker.setValue(p.getBirthday());
        
    }
    
    public void updatePerson(){
        updatePersonList();
    }
    
    
    public void updateBarnameAnchor(Barname bar){
        this.barnameInitiateDatePicker.setValue(bar.getInitiateDate());
        this.barnameCarCombo.setValue(bar.getCarInc());
        this.barnamePersonsCombo.setValue(bar.getOwner());
        this.barnameDestTextField.setText(bar.getDestination());
        this.barnameSourceTextField.setText(bar.getSource());
        this.barnameBijakTextField.setText(bar.getBijak());
        
        this.barnameDistanceTextField.setText(new Double(bar.getDistance()).toString());
        this.barnameWSrcTextField.setText(new Double(bar.getWeightSource()).toString());
        this.barnameWDestTextField.setText(new Double(bar.getWeightDest()).toString());   
    }
    
    public void updateBarnameList(){
        this.barnameTable.setItems(Database.database.getObservableAllBarname());
    }
    
    public void setMainApp(Farstarabar main){
        this.mainApp = main;
    }
    
    public void updateBankAccountList(){
        this.bankTable.setItems(Database.database.getObservalbleAccounts());
    }
    
    public void updateBankAccountAnchor(BankAccount ba){
        this.bankBankField.setText(ba.getBank());
        this.bankTypeField.setText(ba.getType());
        this.bankNumberField.setText(ba.getAccountNumber());
        this.bankCartNumberField.setText(ba.getCartNumber());
        this.bankInitDatePicker.setValue(ba.getAccountInitiation());
        this.bankValue.setText(Integer.valueOf(ba.getValue()).toString());
        
    }
    
    @FXML
    public void initialize(){
        
        transColFacNum.setCellValueFactory(new PropertyValueFactory<Transaction, String>("FactorNumber"));
        transColDate.setCellValueFactory(new PropertyValueFactory<Transaction, LocalDate>("dateTrans"));
        
        transList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Transaction>(){
            @Override
            public void changed(ObservableValue< ? extends Transaction> observable, 
                    Transaction oldValue, Transaction newValue){
                updateTransAnchor(newValue);
            }
        });
        
        transColFromBank.setCellValueFactory(new PropertyValueFactory<PairPriceBank, BankAccount>("bank"));
        transColFromPrice.setCellValueFactory(new PropertyValueFactory<PairPriceBank, String>("Sprice"));
        
        transColToBank.setCellValueFactory(new PropertyValueFactory<PairPriceBank, BankAccount>("bank"));
        transColToPrice.setCellValueFactory(new PropertyValueFactory<PairPriceBank, String>("Sprice"));
        
        bankNumberCol.setCellValueFactory(new PropertyValueFactory<BankAccount, String>("accountNumber"));
        bankBankCol.setCellValueFactory(new PropertyValueFactory<BankAccount, String>("bank"));
        //bankOwnerCol.setCellValueFactory(new PropertyValueFactory<BankAccount, String>(""));
        bankTypeCol.setCellValueFactory(new PropertyValueFactory<BankAccount, String>("type"));
        bankTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<BankAccount>(){
            @Override
            public void changed(ObservableValue<? extends BankAccount> observable, 
                    BankAccount oldValue, BankAccount newValue){
                    updateBankAccountAnchor(newValue);
            }
            
        
        });
        
        
        
        barnameCarCol.setCellValueFactory(new PropertyValueFactory<Barname, String>("pelakNumber"));
        barnameOwnerCol.setCellValueFactory(new PropertyValueFactory<Barname, String>("ownerName"));
        barnameNumberCol.setCellValueFactory(new PropertyValueFactory<Barname, String>("bijakNumber"));
        barnameDateCol.setCellValueFactory(new PropertyValueFactory<Barname, String>("initiateDateString"));
        barnameTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Barname>() {
            @Override
            public void changed(ObservableValue<? extends Barname> observable, 
                    Barname oldValue, Barname newValue){
                    updateBarnameAnchor(newValue);
                    
                }
        
        });
        
        
        carPelakCol.setCellValueFactory(new PropertyValueFactory<Car, String>("pelakNumber"));
        carPelakSeriesCol.setCellValueFactory(new PropertyValueFactory<Car, String>("pelakSeries"));
        carDriverNameCol.setCellValueFactory(new PropertyValueFactory<Car, String>("driverName"));
        
        carsTableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Car>() {
            @Override
            public void changed(ObservableValue<? extends Car> observable, Car oldValue, Car newValue){
                updateCarAnchor(newValue);
            }
        });
        
        
        
        
        
        firstNameColPersonTable.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        lastNameColPersonTable.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
        
        personTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Person>() {
            
            @Override
            public void changed(ObservableValue<? extends Person> observable, Person oldValue, Person newValue) {
                updatePersonAnchor(newValue); //To change body of generated methods, choose Tools | Templates.
            }
  });
        
        
        this.defineBarname.setAccelerator(new KeyCodeCombination(KeyCode.B, 
                KeyCombination.ALT_DOWN));
        
        this.defineCar.setAccelerator(new KeyCodeCombination(KeyCode.C, 
                KeyCombination.CONTROL_DOWN, KeyCombination.ALT_DOWN));
        
        
    }
    
    
    
        @FXML
    public void defineNewGood(){
        try{
//            root = FXMLLoader.load(getClass().getClassLoader().getResource("path/to/other/view.fxml"), resources);
//            Stage stage = new Stage();
//            stage.setTitle("My New Stage Title");
//            stage.setScene(new Scene(root, 450, 450));
//            stage.show();
            Stage newStage = new Stage();
            newStage.setTitle("تعریف کالای جدید");
            FXMLLoader loader = new FXMLLoader(Farstarabar.class.getResource("defineGood.fxml"));
            AnchorPane goodDefinition = (AnchorPane)loader.load();
            Scene scene = new Scene(goodDefinition);
            newStage.setScene(scene);
            newStage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @FXML
    public void defineNewTransacion(){
        try{
//            root = FXMLLoader.load(getClass().getClassLoader().getResource("path/to/other/view.fxml"), resources);
//            Stage stage = new Stage();
//            stage.setTitle("My New Stage Title");
//            stage.setScene(new Scene(root, 450, 450));
//            stage.show();
            Stage newStage = new Stage();
            newStage.setTitle("سند حساب داری");
            FXMLLoader loader = new FXMLLoader(Farstarabar.class.getResource("transaction.fxml"));
            AnchorPane transactionDefinition = (AnchorPane)loader.load();
            Scene scene = new Scene(transactionDefinition);
            newStage.setScene(scene);
            newStage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @FXML
    public void defineCar(){
        try{
//            root = FXMLLoader.load(getClass().getClassLoader().getResource("path/to/other/view.fxml"), resources);
//            Stage stage = new Stage();
//            stage.setTitle("My New Stage Title");
//            stage.setScene(new Scene(root, 450, 450));
//            stage.show();
            Stage newStage = new Stage();
            newStage.setTitle("معرفی ماشین");
            FXMLLoader loader = new FXMLLoader(Farstarabar.class.getResource("carDefine.fxml"));
            AnchorPane carDefinition = (AnchorPane)loader.load();
            Scene scene = new Scene(carDefinition);
            newStage.setScene(scene);
            newStage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @FXML
    private void defineBarname(){
         try{
//            root = FXMLLoader.load(getClass().getClassLoader().getResource("path/to/other/view.fxml"), resources);
//            Stage stage = new Stage();
//            stage.setTitle("My New Stage Title");
//            stage.setScene(new Scene(root, 450, 450));
//            stage.show();
            Stage newStage = new Stage();
            newStage.setTitle("تعریف بارنامه");
            FXMLLoader loader = new FXMLLoader(Farstarabar.class.getResource("barname.fxml"));
            AnchorPane barnameDefinition = (AnchorPane)loader.load();
            Scene scene = new Scene(barnameDefinition);
            newStage.setScene(scene);
            newStage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @FXML
    private void definePerson(){
         try{
//            root = FXMLLoader.load(getClass().getClassLoader().getResource("path/to/other/view.fxml"), resources);
//            Stage stage = new Stage();
//            stage.setTitle("My New Stage Title");
//            stage.setScene(new Scene(root, 450, 450));
//            stage.show();
            Stage newStage = new Stage();
            newStage.setTitle("تعریف شخص");
            FXMLLoader loader = new FXMLLoader(Farstarabar.class.getResource("driverDefine.fxml"));
            AnchorPane driverDefinition = (AnchorPane)loader.load();
            Scene scene = new Scene(driverDefinition);
            newStage.setScene(scene);
            newStage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    @FXML
    private void defineNewAccount(){
         try{
//            root = FXMLLoader.load(getClass().getClassLoader().getResource("path/to/other/view.fxml"), resources);
//            Stage stage = new Stage();
//            stage.setTitle("My New Stage Title");
//            stage.setScene(new Scene(root, 450, 450));
//            stage.show();
            Stage newStage = new Stage();
            newStage.setTitle("معرفی حساب");
            FXMLLoader loader = new FXMLLoader(Farstarabar.class.getResource("accountBankDefine.fxml"));
            AnchorPane accountDefinition = (AnchorPane)loader.load();
            Scene scene = new Scene(accountDefinition);
            newStage.setScene(scene);
            newStage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
}

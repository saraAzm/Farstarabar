/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farstarabar;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
    
    
    
    public void setMainApp(Farstarabar main){
        this.mainApp = main;
    }
    
    @FXML
    public void initialize(){
        
        this.defineBarname.setAccelerator(new KeyCodeCombination(KeyCode.B, 
                KeyCombination.ALT_DOWN));
        
        this.defineCar.setAccelerator(new KeyCodeCombination(KeyCode.C, 
                KeyCombination.CONTROL_DOWN, KeyCombination.ALT_DOWN));
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

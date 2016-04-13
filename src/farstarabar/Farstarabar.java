/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farstarabar;

import java.io.IOException; 
import java.time.LocalDate;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.BankAccount;
import model.Barname;
import model.Car;
import model.Person;

/**
 *
 * @author Aardwolf
 */
public class Farstarabar extends Application {
    
    private Stage primaryStage;
    private BorderPane rootlayout;
    
    
    
    @Override
    public void start(Stage primaryStage) {
        
        Database.database.initiate();
//        Person p = new Person("hamid", "Shayesteh", "3543", "9875",
//                            LocalDate.now(), "nothing");
//
//        Person p1 = new Person("saeed", "Shayesteh", "3543", "9875",
//                            LocalDate.now(), "nothing");
//        
//        Car c = new Car("123", "d3", "23423", LocalDate.now(), LocalDate.now(),
//                            "sdf", LocalDate.now(), "sdlkf", p1, "sdlf");
//        
//        Car c1 = new Car("1sd23", "dd3", "23sdf423", LocalDate.now(),
//                            LocalDate.now(), "sfdsdf", LocalDate.now(), "ssdfdlkf", p, "sdlf");
//        
//        Barname b1 = new Barname(LocalDate.now(), c1, p1, "Shiraz", "tehran", 
//                            0.4, 0.5, 0.3, 0);
        
//        BankAccount a1 = new BankAccount("melli", "sd", "3124123", "23423423", LocalDate.now(), 0);
//        BankAccount a2 = new BankAccount("mellat", "sd", "3124123", "23423423", LocalDate.now(), 0);
//        BankAccount a3 = new BankAccount("sepah", "sd", "3124123", "23423423", LocalDate.now(), 0);
//        BankAccount a4 = new BankAccount("رفاه", "فلان مدل!", "3124123", "23423423", LocalDate.now(), 0);
//        BankAccount a5 = new BankAccount("khar", "sd", "3124123", "23423423", LocalDate.now(), 0);
//        
//        Database.database.getAccounts();
        
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Farstarabar!");
        
        try{
            FXMLLoader loader = new FXMLLoader(Farstarabar.class.getResource("RootLayout.fxml"));
            LoginPageController controller = loader.getController();
            //controller.setMainApp(this);
            rootlayout = (BorderPane)loader.load();
            Scene scene = new Scene(rootlayout);
            primaryStage.setScene(scene);
            primaryStage.setMaximized(true);
            primaryStage.show();
            
        }catch(IOException e){
            e.printStackTrace();
        }
        this.loadLoginPage();
    }

    public void loadLoginPage(){
        try{
            FXMLLoader loader = new FXMLLoader(Farstarabar.class.getResource("loginPage.fxml"));
            // controller, set main!
            AnchorPane loginPage = (AnchorPane)loader.load();
            rootlayout.setCenter(loginPage);
            LoginPageController controller = loader.getController();
            controller.setMainApp(this);
            controller.getin();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void loadMainPage(){
        System.out.println("closed");
        try{
            FXMLLoader loader = new FXMLLoader(Farstarabar.class.getResource("MainPage.fxml"));
            
            AnchorPane MainPage = (AnchorPane)loader.load();
            MainPageController controller = loader.getController();
            controller.setMainApp(this);
            rootlayout.setCenter(MainPage);
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }
       
    
}

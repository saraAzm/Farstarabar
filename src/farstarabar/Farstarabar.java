/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farstarabar;

import java.io.IOException; 
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Aardwolf
 */
public class Farstarabar extends Application {
    
    private Stage primaryStage;
    private BorderPane rootlayout;
    
    
    
    @Override
    public void start(Stage primaryStage) {
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

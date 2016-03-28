/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farstarabar;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author Aardwolf
 */
public class LoginPageController {
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Button login;
    @FXML
    private Button newAccount;
    
    private Farstarabar mainApp;
    
    
    public LoginPageController(){
    }
    
    @FXML
    private void initialize(){
        
    }
    
    public void getin(){
        this.username.setText("s");
        this.password.setText("s");
        this.loginAction();
    }
    
    public void setMainApp(Farstarabar mainApp){
        this.mainApp = mainApp;
    }
    
    @FXML
    public void loginAction(){
        String usr = username.getText();
        String pass = password.getText();
        
        if (usr.equals("s") && pass.equals("s")){
            System.out.println("logined!");
            mainApp.loadMainPage();
        }else{
            System.out.println("shome sookhti");
        }
    
    }
    
    
}

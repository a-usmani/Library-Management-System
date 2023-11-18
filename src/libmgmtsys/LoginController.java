/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package libmgmtsys;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;

/**
 * FXML Controller class
 *
 * @author Ali Usmani
 */
public class LoginController implements Initializable {
    private Stage stage;
    private Scene scene;

    @FXML private TextField username;
    @FXML private PasswordField password;
    @FXML private Label error;
    @FXML private AnchorPane t;
    @FXML private Button login;
    @FXML private Label Password;
    @FXML private Label Username;
    //@FXML private VBox V;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //this.stage.setScene(scene);
        //this.stage.show();
        double width = (int) Screen.getPrimary().getBounds().getWidth();
        double height = (int) Screen.getPrimary().getBounds().getHeight();
        AnchorPane.setTopAnchor(username, height/2-50);
        AnchorPane.setTopAnchor(password, height/2+50);
        AnchorPane.setLeftAnchor(username, 150.0);
        AnchorPane.setLeftAnchor(password, 150.0);
        AnchorPane.setRightAnchor(username, width/2);
        AnchorPane.setRightAnchor(password, width/2);
        AnchorPane.setTopAnchor(login, height/2);
        AnchorPane.setRightAnchor(login, width/4);
        AnchorPane.setTopAnchor(error, height/2+100);
        AnchorPane.setLeftAnchor(error, 150.0);
        AnchorPane.setRightAnchor(error, width/2);
        
        AnchorPane.setTopAnchor(Username, height/2-50);
        AnchorPane.setTopAnchor(Password, height/2+50);
        AnchorPane.setLeftAnchor(Username, 20.0);
        AnchorPane.setLeftAnchor(Password, 20.0);
        AnchorPane.setRightAnchor(Username, 150.0);
        AnchorPane.setRightAnchor(Password, 150.0);
        
        

        // TODO
        error.setText("");
        username.setText("");
        password.setText("");

        
        //AnchorPane.setTopAnchor(password, 200.0);
    }    
    
    @FXML
    private void btnAddClicked(ActionEvent event) {
        Login x=new Login();
        if (x.IsOwner(username.getText(), password.getText())){
            try {
                Parent root=FXMLLoader.load(getClass().getResource("OwnerStartScreen.fxml"));
                stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                scene=new Scene(root);
                stage.setScene(scene);
                stage.setFullScreen(true);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (x.IsCustomer(username.getText(), password.getText())){
            try {
                Parent root=FXMLLoader.load(getClass().getResource("CustomerStartScreen.fxml"));
                stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                scene=new Scene(root);
                stage.setScene(scene);
                stage.setFullScreen(true);
                stage.show();
            } catch (IOException ex) {
                
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(username.getText().equals("")){
            error.setText("Enter a username");}
        else if(password.getText().equals("")){
            error.setText("Enter a password");
    }else{
    error.setText("Enter a valid username and password");}
            username.setText("");
            password.setText("");
        }
        
    
}

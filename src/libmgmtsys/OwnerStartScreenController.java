/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package libmgmtsys;

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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ali Usmani
 */
public class OwnerStartScreenController implements Initializable {
    private Stage stage;
    private Scene scene;
    @FXML private Button Logout;
    @FXML private Button Customers;
    @FXML private Button Books;
    @FXML private AnchorPane t;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        double width = (int) Screen.getPrimary().getBounds().getWidth();
        double height = (int) Screen.getPrimary().getBounds().getHeight();
        
        AnchorPane.setLeftAnchor(Books, width/2-200);
        AnchorPane.setRightAnchor(Books, width/2-200);
        AnchorPane.setLeftAnchor(Customers, width/2-200);
        AnchorPane.setRightAnchor(Customers, width/2-200);
        AnchorPane.setLeftAnchor(Logout, width/2-200);
        AnchorPane.setRightAnchor(Logout, width/2-200);
        
        AnchorPane.setTopAnchor(Books, 50.0);
        AnchorPane.setBottomAnchor(Books, height*2/3+50.0);
        AnchorPane.setTopAnchor(Customers, height/3+50.0);
        AnchorPane.setBottomAnchor(Customers, height/3+50.0);
        AnchorPane.setTopAnchor(Logout, height*2/3+50.0);
        AnchorPane.setBottomAnchor(Logout, 50.0);
        
        
        
    }    
    
    @FXML
    private void btnBooksClicked(ActionEvent event) {
        try {
            Parent root=FXMLLoader.load(getClass().getResource("editBooksFXML.fxml"));
            stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.setFullScreen(true);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(OwnerStartScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void btnCustomersClicked(ActionEvent event) {
        try {
            Parent root=FXMLLoader.load(getClass().getResource("editCustomers.fxml"));
            stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.setFullScreen(true);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(OwnerStartScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void btnLogoutClicked(ActionEvent event) {
        try {
            Parent root=FXMLLoader.load(getClass().getResource("login.fxml"));
            stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.setFullScreen(true);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(OwnerStartScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

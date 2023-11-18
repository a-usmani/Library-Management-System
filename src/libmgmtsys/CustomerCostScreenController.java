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
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ali Usmani
 */
public class CustomerCostScreenController implements Initializable {

    @FXML private Label totalCostLabel;
    @FXML private Label StatusLabel;
    @FXML private Label PointsLabel;
    @FXML private Button logout;
    private Stage stage;
    private Scene scene;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        double width = (int) Screen.getPrimary().getBounds().getWidth();
        double height = (int) Screen.getPrimary().getBounds().getHeight();
        
        /*AnchorPane.setLeftAnchor(Books, width/2-200);
        AnchorPane.setRightAnchor(Books, width/2-200);
        AnchorPane.setLeftAnchor(Customers, width/2-200);
        AnchorPane.setRightAnchor(Customers, width/2-200);
        AnchorPane.setLeftAnchor(Logout, width/2-200);
        AnchorPane.setRightAnchor(Logout, width/2-200);
        */
        AnchorPane.setBottomAnchor(totalCostLabel, height*13/20);
        AnchorPane.setTopAnchor(totalCostLabel, height*2/20);
        AnchorPane.setTopAnchor(PointsLabel, height*8/20);
        AnchorPane.setBottomAnchor(PointsLabel, height*7/20);
        AnchorPane.setTopAnchor(StatusLabel, height*13/20);
        AnchorPane.setBottomAnchor(StatusLabel, height*2/20);
        AnchorPane.setRightAnchor(logout, 50.0);
        AnchorPane.setLeftAnchor(logout, 50.0+width/2);
        AnchorPane.setTopAnchor(logout, 100.0);
        AnchorPane.setBottomAnchor(logout, 100.0);
        
        BookStoreApp info = new BookStoreApp();
        Customers currentCust = Customers.getInstance();
        totalCostLabel.setText("Total Cost: $"+info.totalCost());
        PointsLabel.setText("Points: "+Integer.toString(info.getPoints())+" points");
        StatusLabel.setText("Status: "+info.getStatus());
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
            Logger.getLogger(CustomerCostScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package libmgmtsys;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ali Usmani
 */
public class CustomerStartScreenController implements Initializable {
    @FXML private TableView<book> tableview;
    @FXML private TableColumn<book, String> nameColumn;
    @FXML private TableColumn<book, Double> priceColumn;
    @FXML private TableColumn<book, CheckBox> selectColumn;
    @FXML private Label welcome;
    @FXML private Button BandR;
    @FXML private Button B;
    @FXML private AnchorPane t;
    @FXML private Button Logout;
    private Stage stage;
    private Scene scene;
    private editBooks editor;
    private ObservableList<book> x;
    
    private double currentPoints;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        double width = (int) Screen.getPrimary().getBounds().getWidth();
        double height = (int) Screen.getPrimary().getBounds().getHeight();
        
        AnchorPane.setBottomAnchor(B, 50.0);
        AnchorPane.setLeftAnchor(B, 50.0);
        AnchorPane.setRightAnchor(B, width*2/3+50);
        AnchorPane.setBottomAnchor(BandR, 50.0);
        AnchorPane.setLeftAnchor(BandR, width*1/3);
        AnchorPane.setRightAnchor(BandR, width*1/3);
        AnchorPane.setBottomAnchor(Logout, 50.0);
        AnchorPane.setLeftAnchor(Logout, width*2/3+50.0);
        AnchorPane.setRightAnchor(Logout, 50.0);
        
       AnchorPane.setTopAnchor(tableview, 100.0);
       AnchorPane.setBottomAnchor(tableview, 0.25*height);
       AnchorPane.setRightAnchor(tableview, 50.0);
       AnchorPane.setLeftAnchor(tableview, 50.0);
        
        Customers access=Customers.getInstance();
        Customer cust=access.getCustomerList().get(access.getCustNum());
        welcome.setText(cust.welcomeCustomer());
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("bookName"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("bookPrice"));
        selectColumn.setCellValueFactory(new PropertyValueFactory<>("select"));
        editor=editBooks.getInstance();
        tableview.setItems(FXCollections.observableArrayList(editor.getBookList()));
        currentPoints = cust.getPoints();
            if(editor.isEmpty() == true){
                B.setText("There are no books, request from the owner");
                BandR.setText("There are no books, request from the owner");
    }
    }    

    @FXML
    private void btnBuyClicked(ActionEvent event) {
    if(editor.isEmpty() == true){
                B.textFillProperty();
                B.setText("There are no books, request from the owner");
    }else{
        int x=0;
        List<book> newlist=new ArrayList<book>();
        for (int i=0;i<editor.getBookList().size();i++){
            if (editor.getBookList().get(i).getSelect().isSelected()){
                x=1;
                newlist.add(editor.getBookList().get(i));
            }
        }
        BookStoreApp op = new BookStoreApp(newlist,false);
        if (x==1){
         try {
            Parent root=FXMLLoader.load(getClass().getResource("CustomerCostScreen.fxml"));
            stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.setFullScreen(true);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(CustomerStartScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }}
    
    @FXML
    private void btnBuyAndRedeemClicked(ActionEvent event) {        
        if(currentPoints ==0){
            BandR.setText("No points to redeem");
            BandR.disableProperty();
        }else if(editor.isEmpty() == true){
                BandR.setText("There are no books, request from the owner");
            
        } else{
            BandR.setText("Buy and Redeem");

            
        int x=0;
        List<book> newlist=new ArrayList<book>();
        for (int i=0;i<editor.getBookList().size();i++){
            if (editor.getBookList().get(i).getSelect().isSelected()){
                x=1;
                newlist.add(editor.getBookList().get(i));
            }
        }
        BookStoreApp op = new BookStoreApp(newlist,true);
        if (x==1){
        try {
            Parent root=FXMLLoader.load(getClass().getResource("CustomerCostScreen.fxml"));
            stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.setFullScreen(true);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(CustomerStartScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }}
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
            Logger.getLogger(CustomerStartScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
}

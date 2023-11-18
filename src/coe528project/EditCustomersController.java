/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package coe528project;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ali Usmani
 */
public class EditCustomersController implements Initializable {
    @FXML private TableView<Customer> tableview;
    @FXML private TableColumn<Customer, String> usernameColumn;
    @FXML private TableColumn<Customer, String> passwordColumn;
    @FXML private TableColumn<Customer, Integer> pointsColumn;
    @FXML private TextField username;
    @FXML private TextField password;
    @FXML private Label Username;
    @FXML private Label Password;
    @FXML private Button Back;
    @FXML private Button Add;
    @FXML private Button Delete;
    @FXML private Label error;
    private Stage stage;
    private Scene scene;
    private TableView.TableViewSelectionModel<Customer> selectionModel ;
    private Customers editor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        double width = (int) Screen.getPrimary().getBounds().getWidth();
        double height = (int) Screen.getPrimary().getBounds().getHeight();

        AnchorPane.setRightAnchor(tableview, 50.0);
        AnchorPane.setLeftAnchor(tableview, 50.0);
        AnchorPane.setBottomAnchor(tableview, height*0.33);
        AnchorPane.setTopAnchor(tableview, 50.0);
        
        AnchorPane.setTopAnchor(username, height*0.66+50);
        AnchorPane.setTopAnchor(password, height*0.66+100);
        AnchorPane.setTopAnchor(Username, height*0.66+50);
        AnchorPane.setTopAnchor(Password, height*0.66+100);
        AnchorPane.setTopAnchor(error, height*0.66+150);
        
        AnchorPane.setTopAnchor(Add,height*0.66+50);
        AnchorPane.setRightAnchor(Add, width/2+50.0);
        AnchorPane.setTopAnchor(Back,height*0.66+50);
        AnchorPane.setTopAnchor(Delete,height*0.66+50);
        AnchorPane.setLeftAnchor(Delete,width/2+50.0);
        AnchorPane.setBottomAnchor(Delete, 115.0);
        AnchorPane.setBottomAnchor(Back, 115.0);
        AnchorPane.setLeftAnchor(Back, width*3/4);
        AnchorPane.setRightAnchor(Back, 50.0);
        
        
        /*AnchorPane.setLeftAnchor(delete, 50.0);
        AnchorPane.setRightAnchor(delete, width/2 + 50);
        AnchorPane.setBottomAnchor(delete, 50.0);
        AnchorPane.setTopAnchor(delete, height*7/10);
        
        AnchorPane.setLeftAnchor(add, width/2 + 50);
        AnchorPane.setRightAnchor(add, 50.0);
        AnchorPane.setBottomAnchor(add, back.getHeight()+height*1/4+50);
        AnchorPane.setTopAnchor(add, height*1/2);*/

        
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
        pointsColumn.setCellValueFactory(new PropertyValueFactory<>("points"));
        selectionModel = tableview.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.MULTIPLE);
        editor=Customers.getInstance();
        tableview.setItems(FXCollections.observableList(editor.getCustomerList()));
        error.setText("");
        username.setText("");
        password.setText("");
    }    

    @FXML
    private void btnAddClicked(ActionEvent event) {
        error.setText("");
        String user = username.getText();
        String pass = password.getText();
        if(editor.checkUsername(user) == false){
            error.setText("Please select another username");
        }else if(pass.equals("")){
            error.setText("Please Enter a password");
        }else if(user.equals("")){
            error.setText("Please Enter a username");
        }else{
            
            editor.addCustomer(new Customer(0,user,pass));
        }


        username.setText("");
        password.setText("");
        tableview.setItems(FXCollections.observableList(editor.getCustomerList()));
    }

    @FXML
    private void btnDeleteClicked(ActionEvent event) {
        error.setText("");
        ObservableList<Customer> selectedItems=selectionModel.getSelectedItems();
        int x=selectedItems.size();
        for (int i=0;i<x;i++){
            editor.deleteCustomer(selectedItems.get(0));
        }
        tableview.setItems(FXCollections.observableList(editor.getCustomerList()));
    }

    @FXML
    private void btnBackClicked(ActionEvent event) {
        try {
            Parent root=FXMLLoader.load(getClass().getResource("OwnerStartScreen.fxml"));
            stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.setFullScreen(true);

            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(editBooksFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

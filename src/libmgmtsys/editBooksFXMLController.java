/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package libmgmtsys;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
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
public class editBooksFXMLController implements Initializable {
    @FXML private TableView<book> tableview;
    @FXML private TableColumn<book, String> nameColumn;
    @FXML private TableColumn<book, Double> priceColumn;
    @FXML private TextField bookName;
    @FXML private TextField bookPrice;
    @FXML private Label error;
    @FXML private AnchorPane t;
    @FXML private Label BookPrice;
    @FXML private Label BookName;
    @FXML private Button add;
    @FXML private Button delete;
    @FXML private Button back;
    private Stage stage;
    private Scene scene;
    private TableViewSelectionModel<book> selectionModel ;
    private editBooks editor;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        error.setText("");
        double width = (int) Screen.getPrimary().getBounds().getWidth();
        double height = (int) Screen.getPrimary().getBounds().getHeight();


        
        
        AnchorPane.setRightAnchor(back, 50.0);
        AnchorPane.setLeftAnchor(back, width/2 + 50);
        AnchorPane.setBottomAnchor(back, 50.0);
        AnchorPane.setTopAnchor(back, height*7/10);
        
        AnchorPane.setLeftAnchor(delete, 50.0);
        AnchorPane.setRightAnchor(delete, width/2 + 50);
        AnchorPane.setBottomAnchor(delete, 50.0);
        AnchorPane.setTopAnchor(delete, height*7/10);
        
        AnchorPane.setLeftAnchor(add, width/2 + 50);
        AnchorPane.setRightAnchor(add, 50.0);
        AnchorPane.setBottomAnchor(add, back.getHeight()+height*1/4+50);
        AnchorPane.setTopAnchor(add, height*1/2);
        
        AnchorPane.setBottomAnchor(BookPrice, 250.0);
        AnchorPane.setLeftAnchor(bookPrice, 200.0);
        AnchorPane.setRightAnchor(bookPrice, width/2);
        AnchorPane.setBottomAnchor(bookPrice, 250.0);
        
        AnchorPane.setBottomAnchor(BookName, 300.0);
        AnchorPane.setLeftAnchor(bookName, 200.0);
        AnchorPane.setRightAnchor(bookName, width/2);
        AnchorPane.setBottomAnchor(bookName, 300.0);
        
        
        
        AnchorPane.setTopAnchor(tableview, 50.0);
        AnchorPane.setBottomAnchor(tableview, height/2+50.0);
        AnchorPane.setRightAnchor(tableview, width/4);
        AnchorPane.setLeftAnchor(tableview, 50.0);
        
        AnchorPane.setBottomAnchor(error, 230.0);
        AnchorPane.setLeftAnchor(error, 200.0);
        
        nameColumn.setMinWidth(tableview.getWidth()/2);
        priceColumn.setMinWidth(tableview.getWidth()/2);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("bookName"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("bookPrice"));
        selectionModel = tableview.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.MULTIPLE);
        editor=editBooks.getInstance();
        tableview.setItems(FXCollections.observableList(editor.getBookList()));

    }    

    @FXML
    private void btnAddClicked(ActionEvent event) {
        error.setText("");
        String BN = bookName.getText();
        String BP = bookPrice.getText();
        
        if(BN.equals("") || BP.equals("")){
            error.setText("Enter something");
        //}else if(editor.checkName(BN) == false){
        //    error.setText("Please select another Book Name");
        }else{
            try{
                if(Double.parseDouble(BP)>=0){
        editor.addBook(new book(BN,Double.parseDouble(String.format("%.2f",Double.parseDouble(BP)))));
            } else{
                    error.setText("Enter a positive price");
                }
            }catch (NumberFormatException e) {
                error.setText("This price is not a value");
            }
        }
        bookName.setText("");
        bookPrice.setText("");
        tableview.setItems(FXCollections.observableList(editor.getBookList()));

    }
    
    @FXML
    private void btnDeleteClicked(ActionEvent event) {
        error.setText("");
        ObservableList<book> selectedItems=selectionModel.getSelectedItems();
        int x=selectedItems.size();
        for (int i=0;i<x;i++){
            editor.deleteBook(selectedItems.get(0));
        }
         tableview.setItems(FXCollections.observableList(editor.getBookList()));
    }
    
    @FXML
    private void btnBackClicked(ActionEvent event) {
        error.setText("");
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
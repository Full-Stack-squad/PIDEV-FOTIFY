/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDao;
import entity.User;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.ImageCursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ayoub
 */
public class ProfileAdminController implements Initializable {

    @FXML
    private Label fotify;
    @FXML
    private TableView<User> tvuser;
    @FXML
    private TableColumn<User, String> colnom;
    @FXML
    private TableColumn<User, String> colprenom;
    @FXML
    private TableColumn<User, String> colbio;
    private TableColumn<User, Integer> colage;
    @FXML
    private TableColumn<User, String> colemail;
    @FXML
    private Button supp;
    @FXML
    private Button retour;
    
    private ObservableList<User> user;
    private ListUser listPhoto = new ListUser();
    private ObservableList<User> phs = FXCollections.observableArrayList();
    @FXML
    private TableColumn<User, String> coltype;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    
   
    
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        
             tvuser.setItems(listPhoto.getUser());
        
            colnom.setCellValueFactory(cell -> cell.
                getValue().getUserNomProperty());
            colprenom.setCellValueFactory(cell -> cell.
                getValue().getUserPrenomProperty());
            colbio.setCellValueFactory(cell -> cell.
                getValue().getUserBioProperty());
            colemail.setCellValueFactory(cell -> cell.
                getValue().getUserEmailProperty());
            coltype.setCellValueFactory(cell -> cell.
                getValue().getUserTypeProperty());
            
            
            
            
            retour.setOnMouseClicked(event -> {
                try {
                    
                    Parent type = FXMLLoader.load(getClass().getResource("/view/Back.fxml"));
                    Scene scene = new Scene(type);
                    Image image = new Image("/img/pik.gif");
                    scene.setCursor(new ImageCursor(image,
                            image.getWidth() / 2,
                            image.getHeight() / 2));
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.setTitle("Fotify");
                    stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(FController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            });
        } 
         
         
          
          

    }



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.User;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;

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
    @FXML
    private TableColumn<User, Integer> colage;
    @FXML
    private TableColumn<User, Integer> coltel;
    @FXML
    private TableColumn<User, String> colemail;
    @FXML
    private Button supp;
    @FXML
    private Button retour;
    @FXML
    private ImageView imgv;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}

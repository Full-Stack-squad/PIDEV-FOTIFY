/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AbonnementDAO;
import dao.UserDao;
import entity.Abonnement;
import entity.User;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author YACINE
 */
public class MyabbsController implements Initializable {

    /**
     * Initializes the controller class.
     */
    public ArrayList<Label> abbs = new ArrayList<>();
    public ArrayList<Label> noms = new ArrayList<>();
    public ArrayList<Integer> ids = new ArrayList<>();
    @FXML
    private ScrollPane sp1;
    @FXML
    private ScrollPane sp2;
    @FXML
    private Label com1;
    @FXML
    private Label com2;
    @FXML
    private Pane pane;
    @FXML
    private Button feedback_window_btn;
    @FXML
    private Button ab51;
    @FXML
    private Button ab3;
    @FXML
    private Button ab4;
    @FXML
    private Button ab2;
    @FXML
    private Button ab;
    @FXML
    private Button ab1;
    @FXML
    private Label fotify;
    
    
      String cssLayout = "-fx-background-color: #2d424a;\n" +
                   "-fx-border-insets: 2;\n" +
                   "-fx-border-width: 2;\n" +
                  "-fx-text-fill:white;\n" +
                   "-fx-border-radius: 30;\n";
                String cLayout = "-fx-background-color:#1f1f22;\n" ;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
            AbonnementDAO abd = new AbonnementDAO();
            
            
            
             
            for(Abonnement a : abd.Mesabbs()){
               
                Label l= new Label();
                l.setText(a.getnomA());
                l.setAlignment(Pos.CENTER);
                abbs.add(l);
                VBox vB=new VBox();
                vB.setMinWidth(269);
               
               
                vB.setMinHeight(300);
                vB.setSpacing(8);//jdid
                vB.setStyle(cLayout);
                abbs.forEach( e-> vB.getChildren().add(e));
                abbs.forEach(e->e.setMinHeight(50));
                abbs.forEach(e->e.setStyle(cssLayout));
                abbs.forEach(e->e.setMaxWidth(Double.MAX_VALUE));
                sp1.setContent(vB);
                com1.setText(""+abd.Mesabbs().size());
                
            }
             for(Abonnement a : abd.otherabbs()){
               
                Label l= new Label();
                l.setText(a.getAnom());
                l.setAlignment(Pos.CENTER);
                noms.add(l);
                VBox vB=new VBox();
                vB.setStyle(cLayout);
                
                vB.setMinWidth(269);
                vB.setSpacing(8);//jdid
                vB.setMinHeight(301);
                noms.forEach( e-> vB.getChildren().add(e));
                noms.forEach(e->e.setMinHeight(50));
                noms.forEach(e->e.setStyle(cssLayout));
                noms.forEach(e->e.setMaxWidth(Double.MAX_VALUE));
                sp2.setContent(vB);
                com2.setText(""+abd.otherabbs().size());
                
            }
    }   

    @FXML
    private void gererFeedback(ActionEvent event) {
    }

    @FXML
    private void gererprofile(ActionEvent event) {
    }

    @FXML
    private void abonnementt(ActionEvent event) {
    }

    @FXML
    private void gerercours(ActionEvent event) {
    }

    @FXML
    private void gererevenement(ActionEvent event) {
    }

    @FXML
    private void gerergalerie(ActionEvent event) {
    }

    @FXML
    private void gererreclamation(ActionEvent event) {
    }
 }
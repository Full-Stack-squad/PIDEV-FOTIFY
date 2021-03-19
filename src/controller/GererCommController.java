/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CommentaireServiceDao;
import entity.commentaire;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author YACINE
 */
public class GererCommController implements Initializable {

    @FXML
    private ScrollPane sp;
    @FXML
    private TextArea tfcomm;
    public ArrayList<Label> comms = new ArrayList<>();
    public int idcommentaire=0;
    @FXML
    private Button btnmodif;
    @FXML
    private Button btnsupp;
    public String cssLayout = "-fx-border-color: black;\n" +
                   "-fx-border-insets: 2;\n" +
                   "-fx-border-width: 2;\n" +
                   "-fx-border-style: solid;\n"+
                   "-fx-border-radius: 10;\n";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    
    void comms (int id,int idU){
        comms.clear();
        CommentaireServiceDao ccc =CommentaireServiceDao.getInstance();
         for (commentaire c : ccc.owndisplaycomms(id, idU)){
             Label l =new Label();
             l.setText("  "+c.getcomm());
             comms.add(l);
             l.setOnMouseClicked(e->{
             tfcomm.setText(c.getcomm());
             idcommentaire=c.getid_comm();
             System.out.println(idcommentaire);
            });
             
             
            
             VBox vB=new VBox();
             vB.getChildren().clear();
             comms.forEach( e-> vB.getChildren().add(e));
             comms.forEach(e->e.setMinHeight(50));
             
             comms.forEach(e->e.setMaxWidth(Double.MAX_VALUE));
             comms.forEach(e->e.setStyle(cssLayout));
             sp.setContent(vB);   
               
    
               
    }
    }
     void setIdd(int id, int idU) {
         comms(id,idU);
         
         btnmodif.setOnAction(e->{
             if(idcommentaire==0){ 
                 Alert alert = new Alert(AlertType.NONE, "Erreur de champs", ButtonType.OK);
                 alert.setTitle("Erreur");
                 alert.setContentText("Veuillez sélectionner un commentaire à supprimer"); 
                 alert.showAndWait();     }
             else{
                 CommentaireServiceDao cc =new CommentaireServiceDao();
                 commentaire cNew= new commentaire(idcommentaire, tfcomm.getText());
                 cc.update(cNew);
                 sp.setContent(null);
                 comms(id,idU);}
         
             
             
         
         });
         
         btnsupp.setOnAction(e->{
             if(idcommentaire==0){ 
                 Alert alert = new Alert(AlertType.NONE, "Erreur de champs", ButtonType.OK);
                 alert.setTitle("Erreur");
                 alert.setContentText("Veuillez sélectionner un commentaire à supprimer"); 
                 alert.showAndWait();     }
             else{
                 CommentaireServiceDao cc =new CommentaireServiceDao();
                 commentaire cNew= cc.displayById(idcommentaire);
                 cc.delete(cNew);
                 sp.setContent(null);
                 comms(id,idU);
             }
         });
         
         
    }
     
     
    
}

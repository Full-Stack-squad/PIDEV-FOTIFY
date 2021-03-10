/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PhotoServiceDao;
import entity.photo;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author YACINE
 */
public class UpdatePhotoViewController implements Initializable {

    @FXML
    private TextField tftitre;
    @FXML
    private TextField tftheme;
    @FXML
    private TextField tfcouleur;
    @FXML
    private TextField tfloc;
    @FXML
    private BorderPane bp;
    @FXML
    private ImageView img;
    @FXML
    private Button btnmodif;
    @FXML
    private Button btnsupprim;
    @FXML
    private Button btnprofil;
    public int g;
    public photo p;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        btnprofil.setOnAction(e->{
    try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/view/ProfileView.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();}
    catch (IOException ex) {
                Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
            }
         });
        
    
btnmodif.setOnAction(e->{
  
   PhotoServiceDao ps1 = PhotoServiceDao.getInstance();
   photo updated = new photo(g,tftitre.getText(),tftheme.getText(),tfcouleur.getText(),tfloc.getText());
   ps1.update(updated);
           
   
         });
        
        
        
    }    
    
    
    public int setIdd(int id){

PhotoServiceDao ps1 = new PhotoServiceDao();
        photo photo1 = new photo();
        p=photo1;
        photo1=ps1.displayById(id);
        
        g=id;
        
        Image image = new Image(photo1.geturl());
        tftitre.setText(photo1.gettitre());
        tfcouleur.setText(photo1.getcouleur());
        tftheme.setText(photo1.gettheme());
        tfloc.setText(photo1.getlocalisation());
        img.setImage(image);
        img.setFitHeight(200);
        img.setFitWidth(200);
        return id;
        
};
}

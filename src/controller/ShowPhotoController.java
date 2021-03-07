/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PhotoServiceDao;
import entity.photo;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author YACINE
 */
public class ShowPhotoController implements Initializable {
    
    public int g;
    @FXML
    private Label tftitre;
    @FXML
    private Label tfcol;
    @FXML
    private ImageView ima;

    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println(g);
        // TODO
    }    
    public int setIdd(int id){

PhotoServiceDao ps1 = new PhotoServiceDao();
        photo photo1 = new photo();
        photo1=ps1.displayById(id);
        System.out.println("hhh"+photo1.gettitre());
        g=id;
        tftitre.setText(photo1.gettitre());
        Image image = new Image(photo1.geturl());
        ima.setImage(image);
        ima.setFitHeight(300);
        ima.setFitWidth(300);
        return id;
        
};

}



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PhotoServiceDao;
import entity.Photo;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author YACINE
 */
public class RechercheViewController implements Initializable {

    @FXML
    private TextField tfRech;
    @FXML
    private ChoiceBox<?> ch;
    private GridPane gr;
    public ArrayList<Image> ima = new ArrayList<>();
    public ArrayList<Label> imaa =new ArrayList<>();
    public ArrayList<Integer> imaaa =new ArrayList<>();
    public ArrayList<ImageView> pics = new ArrayList();
    @FXML
    private FlowPane fp;
    public List <Photo> f = new ArrayList<>();
    @FXML
    private Button btnrech;
    BorderPane borderPane;

    /**
     * Initializes the controller class.
     */
   
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO        
        PhotoServiceDao ps1 = new PhotoServiceDao();
  
        for(Photo j : ps1.displayAll()){
            ima.add(new Image(j.geturl()));
            imaa.add(new Label(j.gettitre()));
            imaaa.add(j.getid_photo());}        
         
        for(int i=0;i<ima.size();i++){              
            pics.add(new ImageView(ima.get(i)));
            pics.get(i).setFitWidth(300);
            pics.get(i).setFitHeight(200);}
        
        for(int i=0;i<ima.size();i++){  
            BorderPane borderPane = new BorderPane();
            borderPane.setCenter(pics.get(i));
            borderPane.setBottom(imaa.get(i));
            BorderPane.setAlignment(imaa.get(i),Pos.TOP_CENTER);
            String s =imaa.get(i).getText();
            int n = imaaa.get(i);
            
            
 borderPane.setOnMouseClicked(e->{
          
    try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ShowPhoto.fxml"));
                Region root = (Region) loader.load();
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                ShowPhotoController spc = loader.getController();
                spc.setIdd(n);  
                stage.setScene(scene);
                stage.show();}
    catch (IOException ex) {
                Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
            }
  
});
            fp.getChildren().addAll(borderPane);
            fp.setHgap(10);
            fp.setVgap(10);}
   
    
    
    

               

}}
            
            
        
    
    


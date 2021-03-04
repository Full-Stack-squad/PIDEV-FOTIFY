/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import dao.PhotoServiceDao;
import entity.photo;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author YACINE
 */
public class ProfileController implements Initializable {

    @FXML
    private Label nomlabel;
    @FXML
    private Button btnAjPh;
    @FXML
    private Button btnrech;
    @FXML
    private ScrollPane sp;
    @FXML
    private ImageView phProfil;
    @FXML
    private GridPane gp;
    public ArrayList<String> imagess = new ArrayList<>(); 
    public ImageView iv ;
    public BorderPane bp;
    private HBox hb;
    public ArrayList<Image> ima = new ArrayList<>();
    public ArrayList<ImageView> pics = new ArrayList();
    public ArrayList<String> pic = new ArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         PhotoServiceDao ps1 = new PhotoServiceDao();
         InputStream stream;
         Image image = new Image("/img/user.png");
         phProfil.setImage(image);
         
   
      
    for(photo j : ps1.displayAll()){
            ima.add(new Image(j.geturl()));}
            for(int i=0;i<ima.size();i++){
            pics.add(new ImageView(ima.get(i)));
            pics.get(i).setFitWidth(300);
            pics.get(i).setFitHeight(400);
            gp.add(pics.get(i),i+2,1);      }
            sp.setContent(gp);
            sp.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
         
           
btnAjPh.setOnAction(e->{
    try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/view/AjouterPhotoView.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();}
    catch (IOException ex) {
                Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
            }
         });
      
        
    }    
    
}

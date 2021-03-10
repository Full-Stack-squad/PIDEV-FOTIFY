/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import dao.PhotoServiceDao;
import entity.photo;
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
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
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
    public ImageView iv ;
    public BorderPane bp;
    private HBox hb;
    public ArrayList<String> imagess = new ArrayList<>();
    public ArrayList<Image> ima = new ArrayList<>();
    public ArrayList<Label> imaa =new ArrayList<>();
    public ArrayList<Integer> imaaa =new ArrayList<>();
    public ArrayList<ImageView> pics = new ArrayList();
    public ArrayList<String> pic = new ArrayList();
    public int Id_membre=1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         PhotoServiceDao ps1 = new PhotoServiceDao();
         InputStream stream;
        
         Image image = new Image("/img/user.png");
         phProfil.setImage(image);
         
   
      
    for(photo j : ps1.displayByIdMembre(Id_membre)){
            ima.add(new Image(j.geturl()));
            imaa.add(new Label(j.gettitre()));
            imaaa.add(j.getid_photo());
        }  
    
    for(int i=0;i<ima.size();i++){              
            pics.add(new ImageView(ima.get(i)));
            pics.get(i).setFitWidth(250);
            pics.get(i).setFitHeight(250);}
        
    for(int i=0;i<ima.size();i++){  
            BorderPane borderPane = new BorderPane();
            borderPane.setCenter(pics.get(i));
            borderPane.setBackground(new Background(new BackgroundFill(Color.GAINSBORO, CornerRadii.EMPTY, Insets.EMPTY)));
            borderPane.setBottom(imaa.get(i));
            BorderPane.setMargin(imaa.get(i), new Insets(10, 10, 10, 10));
            BorderPane.setAlignment(imaa.get(i),Pos.TOP_CENTER);
            String s =imaa.get(i).getText();
            int n = imaaa.get(i);
            
            
 borderPane.setOnMouseClicked(e->{
    try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/UpdatePhotoView.fxml"));
                Region root = (Region) loader.load();
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                UpdatePhotoViewController spc = loader.getController();
                spc.setIdd(n);  
                stage.setScene(scene);
                stage.show();}
    catch (IOException ex) {
                Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
            }
  
});
        gp.add(borderPane,i+2,1);
        
        
        sp.setContent(gp);}
    
         
           
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
btnrech.setOnAction(e->{
    try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/view/RechercheView.fxml"));
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CommentaireServiceDao;
import dao.PhotoServiceDao;
import entity.commentaire;
import entity.photo;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.color;
import static javafx.scene.paint.Color.color;
import static javafx.scene.paint.Color.color;
import static javafx.scene.paint.Color.color;
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
    @FXML
    private Button btnProfil;
    @FXML
    private Button BtnRech;
    @FXML
    private ScrollPane sp;
    @FXML
    private Button btncomm;
    @FXML
    private TextArea tfcomm;
    public ArrayList comments;
    public ArrayList<String> comms = new ArrayList<>();
    public ArrayList<String> usernames = new ArrayList<>();
    public ArrayList<Label> imaa =new ArrayList<>();
    @FXML
    private VBox vb;

    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
     
BtnRech.setOnAction(e->{
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
        
         btnProfil.setOnAction(e->{
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
        
CommentaireServiceDao cc = new CommentaireServiceDao();
for (commentaire c : cc.displaycomms(g)){
    
   comms.add(c.getcomm());
   
   usernames.add(c.getnom_user());
   }
   for (int i=0;i<comms.size();i++){
       System.out.println(comms.get(i));
       imaa.add(new Label("  "+comms.get(i)+" : "+usernames.get(i)));
       VBox vBox=new VBox(); 
       //vBox.setAlignment(Pos.BASELINE_CENTER);
       imaa.forEach( e-> vBox.getChildren().add(e));
       imaa.get(i).setMinHeight(50);
        String cssLayout = "-fx-border-color: black;\n" +
                   "-fx-border-insets: 2;\n" +
                   "-fx-border-width: 2;\n" +
                   "-fx-border-style: solid;\n"+
                "-fx-border-radius: 10;\n";
       imaa.get(i).setMaxWidth(Double.MAX_VALUE);
       imaa.get(i).setStyle(cssLayout);
      
       
       

       sp.setContent(vBox);
    
    }
   
btncomm.setOnAction(e->{  
commentaire c1 = new commentaire(tfcomm.getText(),"user",id);
cc.insert(c1);
});


   
   
   
 
        
        
        
        return id;
        
};

    private Insets Insets(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}



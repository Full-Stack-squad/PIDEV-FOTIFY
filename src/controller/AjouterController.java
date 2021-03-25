/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.sun.javafx.iio.common.ImageTools;
import dao.PhotoServiceDao;
import dao.UserDao;
import entity.Photo;
import utils.Upload;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import org.controlsfx.control.Rating;

/**
 * FXML Controller class
 *
 * @author YCINE
 */
public class AjouterController implements Initializable {

    private ImageView phv;
    private TextField tfTitre;
    private TextField tfTheme;
    private TextField tfCouleur;
    private TextField tfLocalisation;
    private Button addAll;
    private Button addPH;
    private Button btnProfil;
    
    private FileChooser filechooser = new FileChooser();
    public String url;
    public String path ; 
    public int Id_membre=1;
    
    
    
    
    
    private File file;
    String pic;
    @FXML
    private Pane pane;
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
    private Button feedback_window_btn;
    @FXML
    private Label fotify;
    @FXML
    private TextField feedback_description;
    @FXML
    private Button btn_ajouterFeedback;
    @FXML
    private Button btn_listerfeedback;
    @FXML
    private Rating feedback_rating;
    @FXML
    private Button btn_ProfileMembre;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
         fotify.setOnMouseClicked(event -> {
            try {

                Parent type = FXMLLoader.load(getClass().getResource("/view/firstView.fxml"));
                Scene scene = new Scene(type);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                 stage.setTitle("Fotify"); 
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(CoursController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
        
    //fonction du bouton d'ajout des photos     
    addAll.setOnAction(e->{
            if(tfTitre.getText().isEmpty()||tfCouleur.getText().isEmpty()||tfLocalisation.getText().isEmpty()||tfTheme.getText().isEmpty()){
                 Alert alert = new Alert(AlertType.NONE, "Erreur de champs", ButtonType.OK);
                 alert.setTitle("Erreur");
                 alert.setContentText("Veuillez remplir les champs vides!"); 
                 alert.showAndWait();     }
            else if (phv.getImage()==null){
                 Alert alert = new Alert(AlertType.NONE, "Erreur d'image", ButtonType.OK);
                 alert.setTitle("Erreur d'image");
                 alert.setContentText("Veuillez choisir une image!"); 
                 alert.showAndWait();  }
            else {
                  SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
                  Date date = new Date(System.currentTimeMillis());
                  PhotoServiceDao ps1 = new PhotoServiceDao();
                  Photo p1 = new Photo(this.url,tfTitre.getText(),tfTheme.getText(),date.toString(),tfCouleur.getText(),tfLocalisation.getText(),UserDao.connectedUser.getUserId());
                  ps1.insert(p1);
              try {

                Parent type = FXMLLoader.load(getClass().getResource("/view/ProfileView.fxml"));
                Scene scene = new Scene(type);
                Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                stage.setScene(scene);
                 stage.setTitle("Fotify"); 
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(CoursController.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
    });
     
    
    //Fonction du bouton de selection de la photo a inserr
    addPH.setOnAction(e->{
            FileChooser fileChooser = new FileChooser();
            file= fileChooser.showOpenDialog(null);
             //FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
            //FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
            //fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

            
            pic=(file.toURI().toString());
            phv.setImage(new Image(pic));
        try {
            //  pic=new Upload().upload(file,"uimg");
            pic=new Upload().upload(file, "");
        } catch (IOException ex) {
            Logger.getLogger(AjouterController.class.getName()).log(Level.SEVERE, null, ex);
        }
            System.out.println(pic);
   //   image= new Image("http://localhost/uimg/"+pic);
            
           this.url= "http://localhost/doc/"+pic;
  }
        
    );
    
//bouton de redirection vers la view profil
    btnProfil.setOnAction(e->{
            try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/view/ProfileView.fxml"));
                Scene scene1 = new Scene(page1);
                Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                stage.setScene(scene1);
                stage.show();
                
            } catch (IOException ex) {
                Logger.getLogger(AjouterController.class.getName()).log(Level.SEVERE, null, ex);
            }
    });
    
    }    


    @FXML
    private void gererprofile() {
          ab51.setOnMouseClicked(event -> {
            try {

                Parent type = FXMLLoader.load(getClass().getResource("/view/displayUsers.fxml"));
                Scene scene = new Scene(type);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                 stage.setTitle("Fotify"); 
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(CoursController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
    }

    @FXML
    private void abonnementt(ActionEvent event) {
    }

    @FXML
    private void gerercours() {
        ab4.setOnMouseClicked(event -> {
            try {

                Parent type = FXMLLoader.load(getClass().getResource("/view/home.fxml"));
                Scene scene = new Scene(type);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                 stage.setTitle("Fotify"); 
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(CoursController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
    }

    @FXML
    private void gererevenement() {
        ab2.setOnMouseClicked(event -> {
            try {

                Parent type = FXMLLoader.load(getClass().getResource("/view/AfficherEvenement.fxml"));
                Scene scene = new Scene(type);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                 stage.setTitle("Fotify"); 
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(CoursController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
    }

    @FXML
    private void gerergalerie() {
        ab.setOnMouseClicked(event -> {
            try {

                Parent type = FXMLLoader.load(getClass().getResource("/view/ProfileView.fxml"));
                Scene scene = new Scene(type);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                 stage.setTitle("Fotify"); 
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(CoursController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
    }

    @FXML
    private void gererreclamation() {
          ab1.setOnMouseClicked(event -> {
            try {

                Parent type = FXMLLoader.load(getClass().getResource("/view/MesReclamations.fxml"));
                Scene scene = new Scene(type);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                 stage.setTitle("Fotify"); 
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(FController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
    }

    @FXML
    private void gererFeedback() {
        feedback_window_btn.setOnMouseClicked(event -> {
            System.out.println("hey");
           try {
                Parent type = FXMLLoader.load(getClass().getResource("/view/ListerFeedback.fxml"));
                Scene scene = new Scene(type);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                System.out.println("hey");
                 stage.setTitle("Fotify"); 
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            } 
        });
    }
    
}

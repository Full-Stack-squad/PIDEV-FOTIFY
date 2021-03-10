/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.sun.javafx.iio.common.ImageTools;
import dao.PhotoServiceDao;
import entity.photo;
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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author YCINE
 */
public class AjouterController implements Initializable {

    @FXML
    private ImageView phv;
    @FXML
    private TextField tfTitre;
    @FXML
    private TextField tfTheme;
    @FXML
    private TextField tfCouleur;
    @FXML
    private TextField tfLocalisation;
    @FXML
    private Button addAll;
    @FXML
    private Button addPH;
    @FXML
    private Button btnProfil;
    
    private FileChooser filechooser = new FileChooser();
    public String url;
    public String path ; 
    public int Id_membre=1;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         
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
                  photo p1 = new photo(this.url,tfTitre.getText(),tfTheme.getText(),date.toString(),tfCouleur.getText(),tfLocalisation.getText(),Id_membre);
                  ps1.insert(p1);}
    });
        
    addPH.setOnAction(e->{
            try {
               
                        File infile = filechooser.showOpenDialog(null);
                        Image img = SwingFXUtils.toFXImage(ImageIO.read(infile), null); 
                        phv.setImage(img);
                        path="http://localhost/image/"+infile.getName() ;
                        Path from = Paths.get(infile.toURI());
                        Path to = Paths.get("c:\\xampp\\htdocs\\image\\"+infile.getName());
                        CopyOption[] options = new CopyOption[]{
                               StandardCopyOption.REPLACE_EXISTING,
                               StandardCopyOption.COPY_ATTRIBUTES};
                        Path temp = Files.copy(from,to,options);
                        this.url=path;
            }
            catch (IOException ex) {
                         } ;
        
    });
    
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
    
}

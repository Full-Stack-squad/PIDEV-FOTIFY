/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PhotoServiceDao;
import dao.ReclamationDao;
import dao.UserDao;
import entity.Photo;
import entity.Reclamation;
import enums.Etat;
import utils.EmailService;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author fares
 */
public class CreeReclamationController implements Initializable {

    private Text photoT;
    @FXML
    private ComboBox<String> sujetCB;
    @FXML
    private TextField sujetTF;
    @FXML
    private TextArea descriptionTA;
    @FXML
    private Button envoyerBT;
    @FXML
    private Button annulerBT;
    @FXML
    private Label kk;
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
        // TODO
        List<String> sujetoption = new ArrayList<>();

        sujetoption.add("option1");
        sujetoption.add("option0");
        sujetoption.add("autre");

        sujetCB.setItems(FXCollections.observableArrayList(sujetoption));
    }

    @FXML
    private void sujetCBClick(ActionEvent event) {
        System.out.println(sujetCB.getValue());
        if (sujetCB.getValue() == "autre") {
            sujetTF.setVisible(true);
        } else {
            sujetTF.setVisible(false);

        }
    }

    

    @FXML
    private void annulerClick(ActionEvent event) {

        try {
            photoT.getScene().setRoot(FXMLLoader.load(getClass().getResource("/view/MesReclamations.fxml")));
        } catch (IOException ex) {
            Logger.getLogger(CreeReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    int setIdd(int id) {
           PhotoServiceDao ps1 = new PhotoServiceDao();
        Photo photo1 = new Photo();
        photo1=ps1.displayById(id);//recuperer la photo avec son id
        
        kk.setText(photo1.gettitre());
       envoyerBT.setOnAction(e->{
           
        ReclamationDao rdao = new ReclamationDao();
        String sujett;
        if (sujetCB.getValue() == "autre") {
            sujett = sujetTF.getText();
        } else {
            sujett = sujetCB.getValue();
        }

        rdao.insert(new Reclamation(sujett, descriptionTA.getText(), Etat.EN_ATTENTE, "",UserDao.connectedUser.getUserId(), id, null, null));
        
        EmailService.sendMailFunc("jlassi.med.yacine@gmail.com", "Reclamation: " + sujett, "Votre Reclamation est en attente "+ descriptionTA.getText() );

         try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/view/MesReclamations.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();}
    catch (IOException ex) {
                Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
            }
       });

    
        
return id;
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

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ReclamationDao;
import entity.Reclamation;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author fares
 */
public class DetailReclamationAdminController implements Initializable {

    @FXML
    private Text photoT;
    @FXML
    private Text etatT;
    @FXML
    private Text sujetT;
    @FXML
    private Text dateT;
    @FXML
    private TextArea descriptionTA;
    @FXML
    private HBox showEditHB;
    @FXML
    private Button supprimerBT;
    @FXML
    private Button retourBT;

    private Reclamation reclamation;
    @FXML
    private Label fotify;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fotify.setOnMouseClicked(event -> {
            try {

                Parent type = FXMLLoader.load(getClass().getResource("/view/Back.fxml"));
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
    }

    @FXML
    private void retourClick() {
        retourBT.setOnMouseClicked(event -> {
            try {

                Parent type = FXMLLoader.load(getClass().getResource("/view/ReclamationsAdmin.fxml"));
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

    public void initData(Reclamation r) {
        this.reclamation = r;
//        photoT.setText(r.getPhoto().gettitre());
        descriptionTA.setText(r.getDescription());
        sujetT.setText(r.getSujet());

        etatT.setText(r.getEtat().toString());
        dateT.setText(r.getDate_creation());

    }

    @FXML
    private void supprimerClick(ActionEvent event) {
        ReclamationDao rdao = new ReclamationDao();
        rdao.delete(reclamation);
        try {
            photoT.getScene().setRoot(FXMLLoader.load(getClass().getResource("/view/ReclamationsAdmin.fxml")));
        } catch (IOException ex) {
            Logger.getLogger(CreeReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

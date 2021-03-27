/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ReclamationDao;
import entity.Reclamation;
import dao.UserDao;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author fares
 */
public class MesReclamationsController implements Initializable {

    String ccLayout = "-fx-background-color:#1f1f22;\n" + "-fx-text-fill: red;\n";
    String cLayout = "-fx-background-color:#1f1f22;\n";
    String cssLayout = "-fx-background-color:#1f1f22;\n"
            + "-fx-border-insets: 2;\n"
            + "-fx-border-width: 2;\n"
            + "-fx-text-fill: white;\n"
            + "-fx-font-weight: bold;\n"
            + "-fx-border-radius: 10;\n"
            + "-fx-border-color: #fabe2e;\n"
            + "-fx-background-radius: 11;\n";
    public ArrayList<Label> comms = new ArrayList<>();
    @FXML
    private ScrollPane sp;
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
        ReclamationDao rd = new ReclamationDao();
        for (Reclamation r : rd.isplayById(UserDao.connectedUser.getUserId())) {
            Label l = new Label();
            l.setText("sujet : " + r.getSujet() + "        description : " + r.getDescription() + "          Etat :  " + r.getEtat());
            l.setAlignment(Pos.CENTER);
            comms.add(l);
            //  comms.forEach(e->e.setStyle(cLayout));

            VBox vB = new VBox();
            vB.setMinWidth(300);
            // vB.setStyle(ccLayout);
            vB.setSpacing(8);//jdid
            vB.setStyle(cLayout);
            comms.forEach(e -> vB.getChildren().add(e));
            comms.forEach(e -> e.setMinHeight(50));

            comms.forEach(e -> e.setMaxWidth(Double.MAX_VALUE));
            comms.forEach(e -> e.setStyle(cssLayout));

            //comms.forEach(e->e.setStyle(cLayout));
            sp.setContent(vB);

            l.setOnMouseClicked(e -> {
                try {

                    Parent type = FXMLLoader.load(getClass().getResource("/view/DetailReclamation.fxml"));
                    Scene scene = new Scene(type);
                    Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.setTitle("Fotify");
                    stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(CoursController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });

        }

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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AbonnementDAO;
import entity.Abonnement;
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
 * @author YACINE
 */
public class MyabbsController implements Initializable {

    /**
     * Initializes the controller class.
     */
    public ArrayList<Label> abbs = new ArrayList<>();
    public ArrayList<Label> noms = new ArrayList<>();
    public ArrayList<Integer> ids = new ArrayList<>();
    @FXML
    private ScrollPane sp1;
    @FXML
    private ScrollPane sp2;
    @FXML
    private Label com1;
    @FXML
    private Label com2;
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

    String cssLayout = "-fx-background-color: #1f1f22;\n"
            + "-fx-border-insets: 2;\n"
            + "-fx-border-color: #fabe2e;\n"
            + "-fx-border-width: 2;\n"
            + "-fx-text-fill:white;\n"
            + "-fx-font-weight: bold;\n"
            + "-fx-min-height:50;\n"
            + "-fx-border-radius: 10;\n";
    String cLayout = "-fx-background-color:#1f1f22;\n";

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

        AbonnementDAO abd = new AbonnementDAO();

        for (Abonnement a : abd.Mesabbs()) {

            Label l = new Label();
            l.setText(a.getnomA());
            l.setAlignment(Pos.CENTER);
            abbs.add(l);
            VBox vB = new VBox();
            vB.setMinWidth(269);

            vB.setMinHeight(300);
            vB.setSpacing(8);//jdid
            vB.setStyle(cLayout);
            abbs.forEach(e -> vB.getChildren().add(e));
            abbs.forEach(e -> e.setMinHeight(50));
            abbs.forEach(e -> e.setMaxWidth(250));
            abbs.forEach(e -> e.setStyle(cssLayout));
            //abbs.forEach(e->e.setMaxWidth(Double.MAX_VALUE));
            sp1.setContent(vB);
            com1.setText("" + abd.Mesabbs().size());

        }
        for (Abonnement a : abd.otherabbs()) {

            Label l = new Label();
            l.setText(a.getAnom());
            l.setAlignment(Pos.CENTER);
            noms.add(l);
            VBox vB = new VBox();
            vB.setStyle(cLayout);

            vB.setMinWidth(269);
            vB.setSpacing(8);//jdid
            vB.setMinHeight(301);
            noms.forEach(e -> vB.getChildren().add(e));
            noms.forEach(e -> e.setMinHeight(50));
            noms.forEach(e -> e.setMaxWidth(250));
            noms.forEach(e -> e.setStyle(cssLayout));
            // noms.forEach(e->e.setMaxWidth(Double.MAX_VALUE));
            sp2.setContent(vB);
            com2.setText("" + abd.otherabbs().size());

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

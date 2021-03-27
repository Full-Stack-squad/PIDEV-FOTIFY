/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDao;
import entity.User;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Amine
 */
public class DisplayUsersController implements Initializable {

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
    private ScrollPane sp;
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

    private GridPane gr;
    @FXML
    private Label fotify;
    private List<User> list = new ArrayList();
    private List<User> listt = new ArrayList();
    @FXML
    private TextField tfrech;

    /**
     * Initializes the controller class.
     */

    public Label add(User u) {

        Label l = new Label();
        l.setText(u.getUserNom() + "  " + u.getUserPrenom());
        l.setAlignment(Pos.CENTER);
        l.setStyle(cssLayout);

        l.setMinHeight(50);

        l.setMaxWidth(Double.MAX_VALUE);

        l.setOnMouseClicked(e -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/showuser.fxml"));
                Region root = (Region) loader.load();
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                ShowuserController spc = loader.getController();
                spc.setIdd(u.getUserId());//envoie de l'ID de la photo   
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        );
        return l;

    }

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
        try {
            UserDao udao = new UserDao();
            for (User u : udao.displayAlll()) {
                list = udao.displayAlll();
                listt = udao.displayAlll();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DisplayUsersController.class.getName()).log(Level.SEVERE, null, ex);
        }

        tfrech.textProperty().addListener((observableValue, oldValue, newValue) -> {
            sp.setContent(null);

            list = listt.stream().filter(e -> e.getUserNom().toLowerCase().contains(newValue) || e.getUserPrenom().toLowerCase().contains(newValue)).distinct().collect(Collectors.toList());
            System.out.println(list);

            for (User j : list) {

                VBox vB = new VBox();
                vB.setMinWidth(300);
                // vB.setStyle(ccLayout);
                vB.setSpacing(8);//jdid
                vB.setStyle(cLayout);
                list.forEach(e -> vB.getChildren().add(add(e)));

                //comms.forEach(e->e.setStyle(cLayout));
                sp.setContent(vB);
            }
        });

        for (User j : list) {

            VBox vB = new VBox();
            vB.setMinWidth(300);
            // vB.setStyle(ccLayout);
            vB.setSpacing(8);//jdid
            vB.setStyle(cLayout);
            list.forEach(e -> vB.getChildren().add(add(e)));

            //comms.forEach(e->e.setStyle(cLayout));
            sp.setContent(vB);
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FeedbackDAO;
import entity.Feedback;
import static com.mysql.jdbc.StringUtils.isNullOrEmpty;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.controlsfx.control.Rating;

/**
 * FXML Controller class
 *
 * @author ayoub
 */
public class ModifierFeedbackController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField feedback_description;
    @FXML
    private Rating feedback_rating;
    @FXML
    private Button btn_modifierFeedback;

    private Feedback feedback;
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

    public void transferMsg(Feedback f) {
        feedback = f;
        feedback_description.setText(feedback.getContenuFeedBack());
        feedback_rating.setRating(f.getRating());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

       
    }

    void setIdd(Feedback id) {
        System.out.println(id);
         btn_modifierFeedback.setOnAction(event -> {
            if (isNullOrEmpty(feedback_description.getText())) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Champ Description doit etre remplie!");
                alert.show();
            } else {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                Date now = new Date();

                Feedback f = new Feedback(id.getId(), String.valueOf(now), feedback_description.getText(), (Integer) Math.round((float) feedback_rating.getRating()));
                FeedbackDAO fdao;
                try {
                    fdao = FeedbackDAO.getInstance();
                    fdao.update(f.getId(), f);

                    FXMLLoader l = new FXMLLoader(getClass().getResource("/view/ListerFeedback.fxml"));
                    Parent root = l.load();
                    ListerFeedbackController listerFeedbackController = l.getController();
                   // listerFeedbackController.loadData();

                } catch (SQLException ex) {
                    Logger.getLogger(AjouterFeedbackController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ModifierFeedbackController.class.getName()).log(Level.SEVERE, null, ex);
                }
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Feedback modifié avec succés!");
                alert.show();
        
                try {
                    Parent profileMembrePage = FXMLLoader.load(ModifierFeedbackController.this.getClass().getResource("/view/ListerFeedback.fxml"));
                    Scene scene = new Scene(profileMembrePage);
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.setResizable(false);
                    stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(ModifierFeedbackController.class.getName()).log(Level.SEVERE, null, ex);
                }
                    
                //feedback_description.setText("");
            }
        });

    }

    @FXML
    private void gererFeedback(ActionEvent event) {
    }

    @FXML
    private void gererprofile(ActionEvent event) {
    }

    @FXML
    private void abonnementt(ActionEvent event) {
    }

    @FXML
    private void gerercours(ActionEvent event) {
    }

    @FXML
    private void gererevenement(ActionEvent event) {
    }

    @FXML
    private void gerergalerie(ActionEvent event) {
    }

    @FXML
    private void gererreclamation(ActionEvent event) {
    }

}

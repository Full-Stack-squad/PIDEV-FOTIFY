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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.ImageCursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ayoub
 */
public class SignInController implements Initializable {

    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    @FXML
    private Button btn_signIn;

    @FXML
    private Button forget;
    @FXML
    private Hyperlink pass;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        btn_signIn.setOnAction((ActionEvent event) -> {

            UserDao udao;
            User user;
            try {
                udao = UserDao.getInstance();
                Object o = udao.SignIn(email.getText(), password.getText());
                if (o != null) {
                    UserDao.connectedUser = (User) o;
                    System.out.println((User) udao.SignIn(email.getText(), password.getText()));
                    if (((User) o).getUserType().equals("Membre")) {
                        Parent membreProfilePage = FXMLLoader.load(SignInController.this.getClass().getResource("/view/firstView.fxml"));
                        Scene scene = new Scene(membreProfilePage);
                        Image image = new Image("/img/pik.gif");
                        scene.setCursor(new ImageCursor(image,
                                image.getWidth() / 2,
                                image.getHeight() / 2));
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        stage.setScene(scene);

                        stage.show();
                    } else if (((User) o).getUserType().equals("Enseignant")) {
                        Parent adminProfilePage = FXMLLoader.load(SignInController.this.getClass().getResource("/view/FXML.fxml"));
                        Scene scene = new Scene(adminProfilePage);
                        Image image = new Image("/img/pik.gif");
                        scene.setCursor(new ImageCursor(image,
                                image.getWidth() / 2,
                                image.getHeight() / 2));
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        stage.setScene(scene);
                        stage.show();
                    } else if (((User) o).getUserType().equals("Admin")) {
                        Parent adminProfilePage = FXMLLoader.load(SignInController.this.getClass().getResource("/view/Back.fxml"));
                        Scene scene = new Scene(adminProfilePage);
                        Image image = new Image("/img/pik.gif");
                        scene.setCursor(new ImageCursor(image,
                                image.getWidth() / 2,
                                image.getHeight() / 2));
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        stage.setScene(scene);
                        stage.show();
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText(null);
                    alert.setContentText("email ou password incorrect!");
                    alert.show();
                }
            } catch (SQLException | IOException ex) {
                Logger.getLogger(SignInController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(SignInController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        forget.setOnMouseClicked(event -> {
            try {

                Parent type = FXMLLoader.load(getClass().getResource("/view/SignUp.fxml"));
                Scene scene = new Scene(type);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.setTitle("Fotify");
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(FController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        pass.setOnMouseClicked(event -> {
            try {

                Parent type = FXMLLoader.load(getClass().getResource("/view/resend.fxml"));
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

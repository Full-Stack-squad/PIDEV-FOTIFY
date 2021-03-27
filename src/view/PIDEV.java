/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.ImageCursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author YACINE
 */
public class PIDEV extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root;
            root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));

        Scene scene = new Scene(root, 1020, 620);
        Image image = new Image("/img/pik.gif");
        scene.setCursor(new ImageCursor(image,
                image.getWidth() / 2,
                image.getHeight() / 2));
        primaryStage.setTitle("Fotify");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
//Date date = new Date(System.currentTimeMillis());

        launch(args);
    }

}

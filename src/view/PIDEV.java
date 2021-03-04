/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.PhotoServiceDao;
import entity.photo;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import utils.DataSource;

/**
 *
 * @author YACINE
 */
public class PIDEV extends Application {
    
    
    @Override
    public void start(Stage primaryStage) throws IOException {
       
        
       Parent root;
        root = FXMLLoader.load(getClass().getResource("ProfileView.fxml"));
        
        Scene scene = new Scene(root, 800, 500);
        
        primaryStage.setTitle("Ajouter photo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
//Date date = new Date(System.currentTimeMillis());

      
        PhotoServiceDao ps1 = new PhotoServiceDao();
         //photo p1 = new photo("1","2","3","4","5","444");
       //ps1.insert(p1);
       
       ps1.displayAll().forEach(e->System.out.println(e.toString()));
        launch(args);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PhotoServiceDao;
import entity.Photo;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author YACINE
 */
public class RechercheViewController implements Initializable {

    @FXML
    private TextField tfRech;
    @FXML
    private ChoiceBox<?> ch;
    private GridPane gr;
    public ArrayList<Image> ima = new ArrayList<>();
    public ArrayList<Label> imaa =new ArrayList<>();
    public ArrayList<Integer> imaaa =new ArrayList<>();
    public ArrayList<ImageView> pics = new ArrayList();
    public ArrayList<Photo> aa = new ArrayList<>();
    @FXML
    private FlowPane fp;
    public List <Photo> f = new ArrayList<>();
    @FXML
    private Button btnrech;
    BorderPane borderPane;
    
    
    
    private List<Photo> list=new ArrayList();
   private  List<Photo> listt=new ArrayList();

    /**
     * Initializes the controller class.
     */
   
   
   public BorderPane createphoto(Photo o){
   BorderPane bp = new BorderPane();
            ImageView ii =new ImageView();
            ii.setFitWidth(300);
            ii.setFitHeight(200);
            ii.setImage(new Image(o.geturl()));
            bp.setCenter(ii);
            Label ll = new Label();
            ll.setText(o.gettitre());
            bp.setBottom(ll);
            BorderPane.setAlignment(ll,Pos.TOP_CENTER);
            
            return bp;
   
   }
   
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO        
       
    PhotoServiceDao ps1 = new PhotoServiceDao();
    listt=ps1.displayAlll();
tfRech.textProperty().addListener(( observableValue,oldValue,newValue) -> {
                                 
           list=listt.stream().filter(e->e.gettitre().contains(newValue)).distinct().collect(Collectors.toList());
           System.out.println(list); 
           fp.getChildren().clear();
           for(Photo j : list){                       
           fp.getChildren().add(createphoto(j));
           fp.setHgap(10);
           fp.setVgap(10);}       
            });
for(Photo j : listt){                       
           fp.getChildren().add(createphoto(j));
           fp.setHgap(10);
           fp.setVgap(10);}     
    


}
}
            
            
        
    
    


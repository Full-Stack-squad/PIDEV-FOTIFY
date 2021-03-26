package controller;

import dao.PhotoServiceDao;
import entity.Photo;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

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
    
     public String cssLayout = "-fx-background-color:#fabe2e;\n" +
                   "-fx-text-fill: #0a0400;\n"+"-fx-font-weight: bold;\n" ;
    
    private List<Photo> list=new ArrayList();
   private  List<Photo> listt=new ArrayList();
   private List<String> themes=new ArrayList();
   private ObservableList<String> phs=FXCollections.observableArrayList(); //jdid
    @FXML
    private Pane pane;
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
    private Button feedback_window_btn;
    @FXML
    private ChoiceBox<String> cb;
    @FXML
    private Label fotify;

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
            ll.setStyle(cssLayout);//jdid
            ll.setMinHeight(30);//jdid
            ll.setMinWidth(300);//jdid
            ll.setAlignment(Pos.CENTER);//jdid
            bp.setBottom(ll);
            BorderPane.setAlignment(ll,Pos.TOP_CENTER);
            bp.setOnMouseClicked(e->{
          
    try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ShowPhoto.fxml"));
                Region root = (Region) loader.load();
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                ShowPhotoController spc = loader.getController();
                spc.setIdd(o.getid_photo());  
                stage.setScene(scene);
                stage.show();}
    catch (IOException ex) {
                Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
            }
  
});
            return bp;
   
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
        // TODO        
       
    PhotoServiceDao ps1 = new PhotoServiceDao();
    themes=ps1.displayAlll().stream().map(e->e.gettheme()).distinct().collect(Collectors.toList());
    for (String s : themes){phs.add(s);}//jdid
    cb.setItems(FXCollections.observableArrayList(phs));
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

cb.setOnAction((event) -> {//jddddiiiiddd
    int selectedIndex = cb.getSelectionModel().getSelectedIndex();
    Object selectedItem = cb.getSelectionModel().getSelectedItem();

    System.out.println("Selection made: [" + selectedIndex + "] " + selectedItem);
    System.out.println("   ChoiceBox.getValue(): " + cb.getValue());
    
    list=listt.stream().filter(e->e.gettheme().contains(cb.getValue())).distinct().collect(Collectors.toList());
           System.out.println(list); 
           fp.getChildren().clear();
           for(Photo j : list){                       
           fp.getChildren().add(createphoto(j));
           fp.setHgap(10);
           fp.setVgap(10);}       
           
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
    private void gerergalerie() throws IOException {
        
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
}
            
            
        
    
    


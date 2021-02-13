package ui;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import model.Classroom;
import model.UserAccount;


import java.io.IOException;

public class ClassroomGUI {

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtPhotoUrl;

    @FXML
    private TextField txtUsername1;

    @FXML
    private TextField txtPassword1;

    @FXML
    private ChoiceBox<String> favoriteBrowser;

    @FXML
    private CheckBox sis;

    @FXML
    private CheckBox tel;

    @FXML
    private CheckBox Indus;

    @FXML
    private DatePicker UserBirthday;

    @FXML
    private RadioButton male;

    @FXML
    private ToggleGroup gender;

    @FXML
    private RadioButton other;

    @FXML
    private RadioButton female;

    @FXML
    private Pane mainPane;

    @FXML
    private Pane pClassroom;

    @FXML
    private TableView<UserAccount> classroomIn;

    @FXML
    private TableColumn<UserAccount, String> colUsername;

    @FXML
    private TableColumn<UserAccount, String> colGender;

    @FXML
    private TableColumn<UserAccount, String> colCareer;

    @FXML
    private TableColumn<UserAccount, String> colBirthday;

    @FXML
    private TableColumn<UserAccount, String> colBrowser;

    @FXML
    private ImageView profilephoto;

    @FXML
    private Label txtUserIn;

    private  UserAccount account;
    private  Classroom classroomGUI;

    public  ClassroomGUI(Classroom classroomG){

        classroomGUI = new Classroom();
    }

    private void initializeClassroom(){
        ObservableList<UserAccount> observableList;
        observableList = FXCollections.observableArrayList(classroomGUI.getAccounts());
        classroomIn.setItems(observableList);

        colUsername.setCellValueFactory(new PropertyValueFactory<UserAccount,String>("username"));
        colGender.setCellValueFactory(new PropertyValueFactory<UserAccount, String>("gender"));
        colCareer.setCellValueFactory(new PropertyValueFactory<UserAccount,String>("career"));
        colBirthday.setCellValueFactory(new PropertyValueFactory<UserAccount, String>("birthday"));
        colBrowser.setCellValueFactory(new PropertyValueFactory<UserAccount, String>("browser"));

    }


    @FXML
    public  void ScreateAnAccount(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CreateAnAccount.fxml"));
        loader.setController(this);
        Parent Screen1 = loader.load();

        mainPane.getChildren().setAll(Screen1);

        favoriteBrowser.getItems().add("Chrome");
        favoriteBrowser.getItems().add("Firefox");
        favoriteBrowser.getItems().add("Brave");






    }

    @FXML
    public  void  alreadySignedIn(ActionEvent event) throws IOException{
        if ((txtUsername1.getText().equals(""))&&(txtPassword1.getText().equals(""))){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all the blanks");
            alert.showAndWait();

        }else {
            if (classroomGUI.canLogin(txtUsername1.getText() , txtPassword1.getText())){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Classroom.fxml"));
                loader.setController(this);

                Parent Screen2 = loader.load();
                txtUserIn.setText(txtUsername1.getText());
                mainPane.getChildren().setAll(Screen2);
                initializeClassroom();



            }else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText(null);
                alert.setContentText("Wrong data! Check your username and password or sign you in!");
                alert.showAndWait();
            }

        }

    }

    @FXML
    public void create(ActionEvent event){
        String user, passW, career , bDay , browser , gender;
        career="";
        user = txtUsername.getText();
        passW = txtPassword.getText();
        gender="";

        if(male.isSelected()){
            gender = "Male";
        }else if(female.isPressed()){
           gender = "Female";
        }else if(other.isSelected()){
           gender = "Other";
        }

        if(sis.isSelected()){
           career = "Software Systems Engineer";
        }else if(tel.isSelected()){
            career = "Telematic Engineer";

        } else if(Indus.isSelected()) {
            career = "Industrial Engineer";

        }
        if (UserBirthday.getValue()!=null) {
            bDay = UserBirthday.getValue().toString();
            System.out.println(bDay);
        }else {
            bDay = "";
        }

        if(favoriteBrowser.getValue()!=null){
            browser = favoriteBrowser.getValue();
        }else {
            browser="";

        }



        if(user.equals("") || passW.equals("") ||  gender.equals("") || career.equals("") || bDay.equals("") || browser.equals("")){

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all the blanks");
            alert.showAndWait();

        }else {
            UserAccount newAccount = new UserAccount(user,passW ,gender, career,bDay,browser);
            classroomGUI.addAccount(newAccount);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Done");
            alert.setHeaderText(null);
            alert.setContentText("The new account has been created!");
            alert.showAndWait();
        }


    }


    @FXML
    public void logOut(ActionEvent event) throws  IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainScreen.fxml"));
        loader.setController(this);

        Parent mScreen= loader.load();

        pClassroom.getChildren().setAll(mScreen);




    }

}

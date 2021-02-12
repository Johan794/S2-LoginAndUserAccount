package ui;
import  model.Classroom;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ClassroomGUI {
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtPassword;

    private  Classroom classroom;

    public  ClassroomGUI(Classroom classroom){
        classroom = new Classroom();
    }

}

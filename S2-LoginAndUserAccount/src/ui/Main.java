package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Classroom;

public class Main extends Application {

    private ClassroomGUI gui;
    private  Classroom classroom;

    public Main(){
        classroom = new Classroom();
        gui = new ClassroomGUI(classroom);
    }

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws  Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainScreen.fxml"));
        loader.setController(gui);
        Parent root = loader.load();


        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Classroom");
        primaryStage.show();


    }
}

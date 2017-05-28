package Notepad;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class Main extends Application {
    public Stage primaryStage;
    private BorderPane rootPane;

    @Override
    public void start(Stage primaryStage) throws Exception {

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Notepad Killer");

        initRootLayout();
    }




        public void initRootLayout(){
            try{
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(Main.class.getResource("notepad.fxml"));
                rootPane =(BorderPane)loader.load();
                Scene myScene = new Scene(rootPane);
                primaryStage.setScene(myScene);
                primaryStage.show();

                MyController controller = loader.getController();
                controller.setMainApp(this);


            }
            catch (IOException e) {
                e.printStackTrace();
            }

    }

        /*

        Parent root = FXMLLoader.load(getClass().getResource("notepad.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
        */


    public static void main(String[] args) {
        launch(args);
    }
}

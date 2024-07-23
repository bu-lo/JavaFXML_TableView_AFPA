package fr.afpa;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    public static void main(String[] args) {
        launch();
    }

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        // *** TITLE IN STAGE ***
        stage.setTitle(" USER MANAGER");

        // ICON
        Image icon = new Image(getClass().getResourceAsStream("logo_user_management.png"));
        stage.getIcons().add(icon); // Add icon in stage

        // *** SCENE ***

        // INSTANCIATION

        scene = new Scene(loadFXML("user_management"), 535, 346);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

}
package pl.jacek;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Jacek
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/Fxml/StartPanel.fxml"));
        Scene scene = new Scene((Parent) fxmlLoader.load());
        
        primaryStage.setTitle("Integracja systemów");
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.setHeight(220.0);
        primaryStage.setWidth(350.0);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

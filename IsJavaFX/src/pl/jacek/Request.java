package pl.jacek;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Jacek
 */
public class Request {
        
    private Stage stage;
    
    private BorderPane borderPane;
    
    
    public Request(){
        this.borderPane = new BorderPane();
    }
    
    public void open() {
        Scene scene = new Scene(this.borderPane);
        this.stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(true);
        stage.setFullScreen(false);
        stage.setTitle("Integracja systemów");
        stage.show();
    }
   

    
    
    
}

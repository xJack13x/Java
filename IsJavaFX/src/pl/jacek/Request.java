package pl.jacek;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
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
    }
}

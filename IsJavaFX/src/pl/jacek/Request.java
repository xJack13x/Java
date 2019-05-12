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
    private Label label;
    
    
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
        
        addButtonToToolBar();
    }
    
    private void addButtonToToolBar() {
        ToolBar toolBar = new ToolBar();
        label = new Label("Nazwa Pliku: Domyślny plik");
        Button buttonAdd = new Button("Dodaj");
        Button buttonSaveToFIle = new Button("Zapisz do pliku txt");
        Button buttonOpenFile = new Button("Wczytaj dane z pliku txt");
        
        Button buttonOpenXMLFile = new Button("Wczytaj dane z pliku XML");
        Button buttonSaveToXMLFile = new Button("Zapisz do pliku XML");
        
        Button buttonToZip = new Button("Kompresuj do ZIP");
        
        toolBar.getItems().add(buttonAdd);
        toolBar.getItems().add(buttonOpenFile);
        toolBar.getItems().add(buttonSaveToFIle);

        toolBar.getItems().add(buttonOpenXMLFile);
        toolBar.getItems().add(buttonSaveToXMLFile);

        toolBar.getItems().add(buttonToZip);
        toolBar.getItems().add(label);

        buttonAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
            }
        });

        buttonSaveToFIle.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
            }
        });

        buttonOpenFile.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
            }
        });


        buttonOpenXMLFile.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
            }
        });

        buttonSaveToXMLFile.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
            }
        });


        buttonToZip.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
            }
        });

        this.borderPane.setTop(toolBar);
    }
    

    
    
    
}

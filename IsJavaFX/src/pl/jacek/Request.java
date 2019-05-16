package pl.jacek;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


/**
 *
 * @author Jacek
 */
public class Request {
        
    private Stage stage;
   
    public static ObservableList<DataPattern> data = FXCollections.observableArrayList();
    private ArrayList<String> lineOfFile = new ArrayList();
    private TableView<DataPattern> table = new TableView();
    
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
        stage.setWidth(1600);
        stage.setHeight(800);
        stage.setFullScreen(false);
        stage.setTitle("Integracja systemów");
        stage.show();
        
        addButtonToToolBar();
        buildTable();
    }
    
    private void addButtonToToolBar() {
        ToolBar toolBar = new ToolBar();
        label = new Label("Nazwa Pliku: Domyślny plik");
        Button buttonAdd = new Button("Dodaj");
        Button buttonSaveToFIle = new Button("Zapisz do pliku txt");
        Button buttonOpenFile = new Button("Wczytaj dane z pliku txt");
        
        Button buttonSaveToXMLFile = new Button("Zapisz do pliku XML");
        Button buttonOpenXMLFile = new Button("Wczytaj dane z pliku XML");
    
        Button buttonToZip = new Button("Kompresuj do ZIP");
        
        toolBar.getItems().add(buttonAdd);
        toolBar.getItems().add(buttonOpenFile);
        toolBar.getItems().add(buttonSaveToFIle);

        toolBar.getItems().add(buttonSaveToXMLFile);
        toolBar.getItems().add(buttonOpenXMLFile);
        
        toolBar.getItems().add(buttonToZip);
        toolBar.getItems().add(label);

        buttonAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Form form = new Form(ConstantValue.columnName());
                form.open();
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
                choiceTxtFileAndReadData();
            }
        });   

        buttonSaveToXMLFile.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
        
        buttonOpenXMLFile.setOnAction(new EventHandler<ActionEvent>() {
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
    
    private void buildTable() {
        Table universalTable = new Table(ConstantValue.columnName());
        table = universalTable.getTable();
        table.setEditable(true);
        this.borderPane.setCenter(table);
    }
    
    private void choiceTxtFileAndReadData() {
        Stage stage = (Stage) this.borderPane.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Wybierz plik txt");
        File recordsDir = new File(System.getProperty("user.dir"));
        fileChooser.setInitialDirectory(recordsDir);
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Rozszerzenia", "*.txt"));
        File wybranyPlik = fileChooser.showOpenDialog(stage);
        String sciezkaDoPliku = wybranyPlik.getPath();
        String sciezkaDoFolderu = wybranyPlik.getAbsoluteFile().getParent();
        label.setText(sciezkaDoPliku);

        readDataFromTxt(sciezkaDoPliku);
        buildTable();
    } 
    
    public void readDataFromTxt(String sciezka) {
        lineOfFile.clear();
        File file = new File(sciezka);
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (sc.hasNextLine()) {
            lineOfFile.add(sc.nextLine());
        }

        data.clear();
        for (String linia : lineOfFile) {
            String[] names = linia.split(";");

            int licznik = 1;
            DataPattern dataPattern= new DataPattern();
            for (String komorka : names) {
                dataPattern.setValue(komorka, licznik);
                licznik++;
            }
            data.add(dataPattern);
        }
    }
    

}

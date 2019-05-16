package pl.jacek;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Jacek
 */
public class Form {
    
    private Stage stage;
    private BorderPane borderPane = new BorderPane();
    private ArrayList<TextField> listOfTextField = new ArrayList();
    private ArrayList<String> columnName;
    private DataPattern dataModel = new DataPattern();

    private String actionType = "Dodawanie";
    private int indexPosition = 0;

    public Form(ArrayList<String> columnName) {
        this.columnName = columnName;
    }

    public Form(ArrayList<String> columnName, DataPattern dataModel, String actionType) {
        this.columnName = columnName;
        this.dataModel = dataModel;
        this.actionType = actionType;
        this.indexPosition = Request.data.indexOf(this.dataModel);
        System.out.println("Numer indeksu: " + this.indexPosition);
        displayDataInForm();
    }

    private void displayDataInForm() {
        createForm();
        int licznik = 1;
        for (TextField textField : listOfTextField) {
            textField.setText(this.dataModel.getValue(licznik));
            licznik++;
        }
    }

    public void open() {
        createForm();
        addButtonToToolBar();
        Scene scene = new Scene(this.borderPane);
        this.stage = new Stage();
        stage.initStyle(StageStyle.DECORATED);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setFullScreen(false);
        stage.setMaximized(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Formularz");
        stage.show();
    }

    private void addButtonToToolBar() {
        ToolBar toolBar = new ToolBar();
        Button button = new Button("Dodaj");
        toolBar.getItems().add(button);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addDate();
            }
        });
        this.borderPane.setBottom(toolBar);
    }

    private void addDate() {
        int licznik = 1;
        for (TextField textField : listOfTextField) {
            this.dataModel.setValue(textField.getText(), licznik);
            licznik++;
        }
        if (actionType.equals("Dodawanie")) {
            Request.data.add(this.dataModel);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informacja");
            alert.setHeaderText("Powodzenie");
            alert.setContentText("Dane zostały dodane");

            alert.showAndWait();
        } else {
            Request.data.set(indexPosition, this.dataModel);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informacja");
            alert.setHeaderText("Powodzenie");
            alert.setContentText("Dane zostały edytowane");
        }
    }

    private void createForm() {

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        if (listOfTextField.size() == 0) {
            int licznik = 0;
            for (String nazwa : columnName) {
                Label label = new Label(nazwa + ": ");
                TextField textField = new TextField();
                listOfTextField.add(textField);

                gridPane.add(label, 0, licznik);
                gridPane.add(textField, 1, licznik);

                licznik++;

            }

            this.borderPane.setCenter(gridPane);
        }

    }
}

package pl.jacek;

import java.util.ArrayList;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToolBar;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Jacek
 */
public class Table {
    
    private String windowTitle = "Tabela";
    private String titleToolBar = "Tabela tytuł";
    private boolean resizdable = true;
    private boolean fullScreen = false;
    private boolean maximized = false;
    private int minimalWidthOFColumn = 100;
    
    private Stage stage;
    private BorderPane borderPane;
    private ToolBar toolBar;
    private Label label;
    private TableView<DataPattern> table;
    private ArrayList<String> columnName;
    
    private Button button1;
    private Button button2;
    private Button button3;
    private boolean showButton1 = false;
    private boolean showButton2 = false;
    private boolean showButton3 = false;

    public Table(ArrayList<String> columnName){
        this.borderPane = new BorderPane();
        this.toolBar = new ToolBar();
        this.table = new TableView();
        this.label = new Label(titleToolBar + " (Pozycji: " + Request.data.size() + ")");               
        this.columnName = columnName;
        this.table.setEditable(true);
    }
    
    private void buildTable() {
        this.table.getItems().clear();
        for (int i = 0; i < columnName.size(); i++) {

            TableColumn<DataPattern, String> kolumna = new TableColumn(columnName.get(i));

            kolumna.setCellValueFactory(new PropertyValueFactory<DataPattern, String>("value" + (i + 1)));
            kolumna.setMinWidth(minimalWidthOFColumn);

            kolumna.setCellFactory((TextFieldTableCell.forTableColumn()));

            kolumna.setOnEditCommit(e->{
                e.getTableView().getItems().get(e.getTablePosition().getRow()).setValue(e.getNewValue(),  e.getTablePosition().getColumn()+1);
            });
            this.table.getColumns().add(kolumna);
            kolumna.setEditable(true);
            this.table.setEditable(true);
        }
        
        TableColumn<DataPattern, DataPattern> kolumnaAkcja = new TableColumn("Akcja");
        kolumnaAkcja.setCellValueFactory(CellData -> new SimpleObjectProperty<>(CellData.getValue()));
        kolumnaAkcja.setMinWidth(minimalWidthOFColumn);
        kolumnaAkcja.setCellFactory(param -> new TableCell<DataPattern, DataPattern>(){
            MenuButton menuButton = createButtonInTable("Akcja");

            @Override
            protected void updateItem(DataPattern item, boolean empty) {
                super.updateItem(item, empty);

                if (empty) {
                    setGraphic(null);
                    return;
                }
                
                if (!empty) {
                    setGraphic(menuButton);
                    setGraphic(menuButton);
                    menuButton.getItems().get(0).setOnAction(event -> {
                        Form form = new Form(ConstantValue.columnName(), item, "Edycja");
                        form.open();

                    });

                    menuButton.getItems().get(1).setOnAction(event -> {
                        Request.data.remove(item);
                    });

                }
            }
        });

        this.table.getColumns().add(kolumnaAkcja);


        table.setItems(Request.data);
        settingsOfTable();
    }
    
    private MenuButton createButtonInTable(String tekstPrzycisku) {
        MenuItem menuItem1 = new MenuItem("Edytuj");
        MenuItem menuItem2 = new MenuItem("Usuń");

        MenuButton menuButton = new MenuButton(tekstPrzycisku, null, menuItem1, menuItem2);
        menuButton.setCursor(Cursor.HAND);
        return menuButton;
    }
    
    private void settingsOfTable() {
        table.setPlaceholder(new Label("Brak danych"));
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }


    public void open() {
        buildWindow();
        Scene scene = new Scene(this.borderPane);
        this.stage = new Stage();
        stage.initStyle(StageStyle.DECORATED);
        stage.setScene(scene);
        stage.setResizable(this.resizdable);
        stage.setFullScreen(this.fullScreen);
        stage.setMaximized(this.maximized);
        stage.setTitle(this.windowTitle);
        stage.show();
    }

    public void buildWindow() {
        buildTable();
        this.borderPane.setCenter(this.table);
        toolBar.getItems().add(this.label);
        if (showButton1) {
            button1 = new Button("1");
            toolBar.getItems().add(button1);
        }

        if (showButton2) {
            button2 = new Button("2");
            toolBar.getItems().add(button2);
        }
        if (showButton3) {
            button3 = new Button("3");
            toolBar.getItems().add(button3);
        }
        this.borderPane.setTop(this.toolBar);
    }
   
    
    
    
    public String getWindowTitle() {
        return windowTitle;
    }

    public void setWindowTitle(String windowTitle) {
        this.windowTitle = windowTitle;
    }

    public String getTitleToolBar() {
        return titleToolBar;
    }

    public void setTitleToolBar(String titleToolBar) {
        this.titleToolBar = titleToolBar;
    }

    public boolean isResizdable() {
        return resizdable;
    }

    public void setResizdable(boolean resizdable) {
        this.resizdable = resizdable;
    }

    public boolean isFullScreen() {
        return fullScreen;
    }

    public void setFullScreen(boolean fullScreen) {
        this.fullScreen = fullScreen;
    }

    public boolean isMaximized() {
        return maximized;
    }

    public void setMaximized(boolean maximized) {
        this.maximized = maximized;
    }

    public int getMinimalWidthOFColumn() {
        return minimalWidthOFColumn;
    }

    public void setMinimalWidthOFColumn(int minimalWidthOFColumn) {
        this.minimalWidthOFColumn = minimalWidthOFColumn;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public BorderPane getBorderPane() {
        return borderPane;
    }

    public void setBorderPane(BorderPane borderPane) {
        this.borderPane = borderPane;
    }

    public ToolBar getToolBar() {
        return toolBar;
    }

    public void setToolBar(ToolBar toolBar) {
        this.toolBar = toolBar;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public TableView<DataPattern> getTable() {
        buildTable();
        return table;
    }

    public void setTable(TableView<DataPattern> table) {
        this.table = table;
    }

    public ArrayList<String> getColumnName() {
        return columnName;
    }

    public void setColumnName(ArrayList<String> columnName) {
        this.columnName = columnName;
    }

    public Button getButton1() {
        return button1;
    }

    public void setButton1(Button button1) {
        this.button1 = button1;
    }

    public Button getButton2() {
        return button2;
    }

    public void setButton2(Button button2) {
        this.button2 = button2;
    }

    public Button getButton3() {
        return button3;
    }

    public void setButton3(Button button3) {
        this.button3 = button3;
    }

    public boolean isShowButton1() {
        return showButton1;
    }

    public void setShowButton1(boolean showButton1) {
        this.showButton1 = showButton1;
    }

    public boolean isShowButton2() {
        return showButton2;
    }

    public void setShowButton2(boolean showButton2) {
        this.showButton2 = showButton2;
    }

    public boolean isShowButton3() {
        return showButton3;
    }

    public void setShowButton3(boolean showButton3) {
        this.showButton3 = showButton3;
    }
    
}

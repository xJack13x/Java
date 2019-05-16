package pl.jacek;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
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
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document; 
import org.w3c.dom.Element;  
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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
                saveDataToTxtFile();
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
                saveDataToXMLFile();
            }
        });
        
        buttonOpenXMLFile.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                choiceXMLFileAndReadData();
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
    
    private void saveDataToTxtFile() {
        FileChooser fileChooser = new FileChooser();
        File recordsDir = new File(System.getProperty("user.dir"));
        fileChooser.setInitialDirectory(recordsDir);
        fileChooser.setTitle("Zapisz plik");
        fileChooser.setInitialFileName("nazwaPliku.txt");
        Stage stage = (Stage) this.borderPane.getScene().getWindow();
        File plik = fileChooser.showSaveDialog(stage);
        String sciezkaDoFolderu = plik.getAbsoluteFile().getParent();
        String filename = plik.getAbsolutePath();

        PrintWriter out = null;
        try {
            out = new PrintWriter(filename + ".txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (DataPattern dataPattern : data) {
            String linia = dataPattern.toString();
            out.println(linia);
        }
        out.close();
    }
    
    private void saveDataToXMLFile() {                                                                                                     
        FileChooser fileChooser = new FileChooser();                                                                                       
        File recordsDir = new File(System.getProperty("user.dir"));                                                                        
        fileChooser.setInitialDirectory(recordsDir);                                                                                       
        fileChooser.setTitle("Zapisz plik");                                                                                               
        fileChooser.setInitialFileName("nazwaPliku.xml");                                                                                  
        Stage stage = (Stage) this.borderPane.getScene().getWindow();                                                                      
        File plik = fileChooser.showSaveDialog(stage);                                                                                                                                                       
        String filename = plik.getAbsolutePath();                                                                                          

        try {                                                                                                                              
            DocumentBuilder budowniczy;                                                                                                    
            DocumentBuilderFactory fabryka = DocumentBuilderFactory.newInstance();                                                         
            budowniczy = fabryka.newDocumentBuilder();                                                                                     
            Document dok = budowniczy.newDocument();                                                                                       

            Element komputery = dok.createElement("Komputery");                                                                            

            for (DataPattern dataModel : data) {                                                                                             
                Element komputer = dok.createElement("Komputer");                                                                          

                Element producent = dok.createElement("Producent");                                                                        
                producent.setTextContent(dataModel.getValue(1));                                                                           

                Element matryca = dok.createElement("Matryca");                                                                            

                Element matrycaRozmiar = dok.createElement("RozmiarMatrycy");                                                              
                matrycaRozmiar.setTextContent(dataModel.getValue(2));                                                                      
                matryca.appendChild(matrycaRozmiar);                                                                                       

                Element matrycaRozdzielczosc = dok.createElement("Rozdzielczosc");                                                         
                matrycaRozdzielczosc.setTextContent(dataModel.getValue(3));                                                                
                matryca.appendChild(matrycaRozdzielczosc);                                                                                 

                Element matrycaTyp = dok.createElement("Typ");                                                                             
                matrycaTyp.setTextContent(dataModel.getValue(4));                                                                          
                matryca.appendChild(matrycaTyp);                                                                                                                                                                  

                Element procesor = dok.createElement("Procesor");                                                                          

                Element procesorModel = dok.createElement("ModelProcesora");                                                               
                procesorModel.setTextContent(dataModel.getValue(5));                                                                       
                procesor.appendChild(procesorModel);                                                                                       

                Element procesrLiczbaRdzeni = dok.createElement("Rdzenie");                                                                
                procesrLiczbaRdzeni.setTextContent(dataModel.getValue(6));                                                                 
                procesor.appendChild(procesrLiczbaRdzeni);                                                                                 

                Element procesrCzestotliwoscTaktowania = dok.createElement("CzestotliwoscTaktowania");                                     
                procesrCzestotliwoscTaktowania.setTextContent(dataModel.getValue(7));                                                      
                procesor.appendChild(procesrCzestotliwoscTaktowania);                                                                      


                Element ram = dok.createElement("RAM");                                                                                    
                ram.setTextContent(dataModel.getValue(8));                                                                                 

                Element dysk = dok.createElement("Dysk");                                                                                  

                Element dyskPojemnosc = dok.createElement("Pojemnosc");                                                                    
                dyskPojemnosc.setTextContent(dataModel.getValue(9));                                                                      
                dysk.appendChild(dyskPojemnosc);                                                                                           

                Element dyskRodzaj = dok.createElement("Rodzaj");                                                                          
                dyskRodzaj.setTextContent(dataModel.getValue(10));                                                                         
                dysk.appendChild(dyskRodzaj);                                                                                              

                Element kartaGraficzna = dok.createElement("KartaGraficzna");                                                              

                Element kartaGraficznaModel = dok.createElement("Model");                                                                  
                kartaGraficznaModel.setTextContent(dataModel.getValue(11));                                                                
                kartaGraficzna.appendChild(kartaGraficznaModel);                                                                           

                Element kartaGraficznaPamiec = dok.createElement("Pamiec");                                                                
                kartaGraficznaPamiec.setTextContent(dataModel.getValue(12));                                                               
                kartaGraficzna.appendChild(kartaGraficznaPamiec);                                                                          

                Element systemOperacyjny = dok.createElement("Sytem");                                                                     
                systemOperacyjny.setTextContent(dataModel.getValue(13));                                                                   

                Element naped = dok.createElement("Naped");                                                                                
                naped.setTextContent(dataModel.getValue(14));                                                                              

                komputer.appendChild(producent);                                                                                           
                komputer.appendChild(matryca);                                                                                             
                komputer.appendChild(procesor);                                                                                            
                komputer.appendChild(ram);                                                                                                 
                komputer.appendChild(dysk);                                                                                                
                komputer.appendChild(kartaGraficzna);                                                                                      
                komputer.appendChild(systemOperacyjny);                                                                                    
                komputer.appendChild(naped);                                                                                               

                komputery.appendChild(komputer);                                                                                           
            }                                                                                                                              

            dok.appendChild(komputery);                                                                                                    

            Transformer t = TransformerFactory.newInstance().newTransformer();                                                             
            t.setOutputProperty(OutputKeys.INDENT, "yes");                                                                                 
            t.setOutputProperty(OutputKeys.METHOD, "xml");                                                                                 

            t.transform(new DOMSource(dok), new StreamResult(new FileOutputStream(filename + ".xml")));                                    
        } catch (FileNotFoundException ex) {                                                                                               
            ex.printStackTrace();                                                                                                          
        } catch (TransformerException ex) {                                                                                                
            ex.printStackTrace();                                                                                                          
        } catch (ParserConfigurationException ex) {                                                                                        
            ex.printStackTrace();                                                                                                          
        }                                                                                                                                  
    }                                                                                                                                      
    
    private void choiceXMLFileAndReadData() {                                                    
        Stage stage = (Stage) borderPane.getScene().getWindow();                                 
        FileChooser fileChooser = new FileChooser();                                             
        fileChooser.setTitle("Wybierz plik txt");                                                
        File recordsDir = new File(System.getProperty("user.dir"));                              
        fileChooser.setInitialDirectory(recordsDir);                                             
        fileChooser.getExtensionFilters().addAll(                                                
                new FileChooser.ExtensionFilter("Rozszerzenia", "*.xml"));                       
        File wybranyPlik = fileChooser.showOpenDialog(stage);                                    
        String filePath = wybranyPlik.getPath();                                           
        String pathFolder = wybranyPlik.getAbsoluteFile().getParent();                     
        label.setText(filePath);                                                           

        readDataFromXML(filePath);    
    }
    
    private void readDataFromXML(String filePath) {                                                                                    
        data.clear();                                                                                                                        
        try {                                                                                                                                

            File fXmlFile = new File(filePath);                                                                                        
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();                                                         
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();                                                                       
            Document doc = dBuilder.parse(fXmlFile);                                                                                         

            doc.getDocumentElement().normalize();                                                                                            

            NodeList nList = doc.getElementsByTagName("Komputer");                                                                           

            for (int temp = 0; temp < nList.getLength(); temp++) {                                                                           

                Node nNode = nList.item(temp);                                                                                               

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {                                                                              
                    DataPattern dataPattern = new DataPattern();                                                                                   
                    Element eElement = (Element) nNode;                                                                                      

                    dataPattern.setValue(eElement.getElementsByTagName("Producent").item(0).getTextContent(), 1);                              
                    dataPattern.setValue(eElement.getElementsByTagName("RozmiarMatrycy").item(0).getTextContent(), 2);                         
                    dataPattern.setValue(eElement.getElementsByTagName("Rozdzielczosc").item(0).getTextContent(), 3);                          
                    dataPattern.setValue(eElement.getElementsByTagName("Typ").item(0).getTextContent(), 4);                                                        
                    dataPattern.setValue(eElement.getElementsByTagName("ModelProcesora").item(0).getTextContent(), 5);                         
                    dataPattern.setValue(eElement.getElementsByTagName("Rdzenie").item(0).getTextContent(), 6);                                
                    dataPattern.setValue(eElement.getElementsByTagName("CzestotliwoscTaktowania").item(0).getTextContent(), 7);                
                    dataPattern.setValue(eElement.getElementsByTagName("RAM").item(0).getTextContent(), 8);                                    
                    dataPattern.setValue(eElement.getElementsByTagName("Pojemnosc").item(0).getTextContent(), 9);                             
                    dataPattern.setValue(eElement.getElementsByTagName("Rodzaj").item(0).getTextContent(), 10);                                
                    dataPattern.setValue(eElement.getElementsByTagName("Model").item(0).getTextContent(), 11);                                 
                    dataPattern.setValue(eElement.getElementsByTagName("Pamiec").item(0).getTextContent(), 12);                                
                    dataPattern.setValue(eElement.getElementsByTagName("Sytem").item(0).getTextContent(), 13);                                 
                    dataPattern.setValue(eElement.getElementsByTagName("Naped").item(0).getTextContent(), 14);                                 
                    data.add(dataPattern);                                                                                       
                }                                                                                                                            
            }                                                                                                                                
        } catch (Exception e) {                                                                                                              
            e.printStackTrace();                                                                                                             
        }                                                                                                                                    
    }                                                                                                                                         

}

package pl.jacek;

import java.util.ArrayList;

/**
 *
 * @author Jacek
 */
public class ConstantValue {
    
    public static ArrayList<String> columnName(){
        ArrayList<String> listColumnName = new ArrayList();
        
        String[] columns = {"Producent", "Rozmiar matrycy", "Rozdzielczość",
                "Rodzaj matrycy", "Procesor", "Rdzenie", "Częstotliwość taktowanie", "RAM", "Pojemnosc Dysku",
                "Rodzaj dysku", "Karta Graficzna", "Ram karty graficznej", "Sytem", "Napęd optyczny"};
        
        for (String column : columns){
            listColumnName.add(column);
        }
        
        return listColumnName;
    }
    
    
}

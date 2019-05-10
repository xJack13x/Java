package pl.jacek;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 *
 * @author Jacek
 */
public class StartPanel {
    
    @FXML
    private Button przyciskZadanie1;

    @FXML
    void otworzZadanie1(ActionEvent event) {
        Request exercise = new Request();
        exercise.open();
    }

}

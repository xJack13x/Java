package pl.jacek;

import javafx.application.Platform;
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
        Request request = new Request();
        request.open();
    }

    @FXML
    void otworzZadanie2(ActionEvent event) {
        Platform.exit();
    }
}

package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class PrimaryGameController implements Initializable {
	
	@FXML private AnchorPane root;
	
	@FXML private Button closeGameButton;
		
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		
		

	}
	
	
	@FXML
    void closeGameAction(ActionEvent event) {
		
		Platform.exit();
    }
}
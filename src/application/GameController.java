package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.TextFlow;

public class GameController implements Initializable {
	
	@FXML AnchorPane root;
	
	@FXML private Button closeGameButton;
	
	@FXML private TextFlow gameText;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		
		

	}
	
	
	
	@FXML
    void closeGameAction(ActionEvent event) {
		
		Platform.exit();
    }
}

package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class GameMenuController implements Initializable {
	
	@FXML AnchorPane root;
	
	@FXML Button closeGameButton;
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		/*AnchorPane needGivePane;
		try {
			needGivePane = (AnchorPane)FXMLLoader.load(getClass().getResource("GameMenu.fxml"));
			root.getChildren().setAll(needGivePane);
		} catch (IOException e) {
			e.printStackTrace();
		}*/

	}
	
	@FXML
    void closeGameMenuAction(ActionEvent event) {
		
		Platform.exit();
    }
}

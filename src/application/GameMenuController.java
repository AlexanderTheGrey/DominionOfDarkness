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
import javafx.scene.media.AudioClip;

public class GameMenuController implements Initializable {
	
	@FXML private AnchorPane root;
	
	@FXML private Button newGameButton;
	@FXML private Button creditsButton;
	@FXML private Button exitGameMenuButton;
	
	
	@FXML
	void loadNewGame(ActionEvent event) {
		
		LauncherController.mp.stop();
		LauncherController.mp.dispose();
		
		String path = Main.class.getResource("/application/resources/in_game/sound_effects/Horror Scary Male Demon Talk 01.wav").toString();
		AudioClip a = new AudioClip(path);
		a.play();

		try {
			AnchorPane newGamePane = (AnchorPane)FXMLLoader.load(getClass().getResource("/application/fxml/PrimaryGame.fxml"));
			this.root.getChildren().setAll(newGamePane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
    @FXML
    void loadCredits(ActionEvent event) {

    }

    
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		

	}
	
	
	@FXML
    void closeGameMenuAction(ActionEvent event) {
		
		Platform.exit();
    }
}
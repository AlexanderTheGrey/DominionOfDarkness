package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class PrimaryGameController implements Initializable {
	
	@FXML private AnchorPane root;
	
	private static MediaPlayer mp;
	
	@FXML private Button closeGameButton;
		
	@Override
	public void initialize(URL url, ResourceBundle rb) {

		String path = Main.class.getResource("/application/resources/in_game/ambient_music/PrimaryGameAmbientMusic.m4a").toString();
		Media media = new Media(path);
		mp = new MediaPlayer(media);
		int loop = MediaPlayer.INDEFINITE;
		mp.setCycleCount(loop);
		mp.play();
	}

	
	@FXML
    void closeGameAction(ActionEvent event) {
		
		Platform.exit();
    }
}
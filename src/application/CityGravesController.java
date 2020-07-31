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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class CityGravesController implements Initializable {
	
	@FXML AnchorPane root;
	
	@FXML private Button cityGravesNexusButton;

	@FXML private Button cityGravesExitButton;
	
	private static MediaPlayer mp;



	@FXML void loadNexus(ActionEvent event) {


		//String path = Main.class.getResource("/application/resources/in_game/sound_effects/Horror Scary Male Demon Talk 01.wav").toString();
		//AudioClip a = new AudioClip(path);
		//a.play();
		
		mp.stop();
		mp.dispose();

		try {
			AnchorPane primaryGamePane = (AnchorPane)FXMLLoader.load(getClass().getResource("/application/fxml/PrimaryGame.fxml"));
			this.root.getChildren().setAll(primaryGamePane);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}



	@FXML
	void closeGameAction(ActionEvent event) {

		Platform.exit();
	}



	@Override
	public void initialize(URL url, ResourceBundle resources) {
		
		String path = Main.class.getResource("/application/resources/in_game/ambient_music/City Graves Ambience.m4a").toString();
		Media musicmedia = new Media(path);
		mp = new MediaPlayer(musicmedia);
		
		int loop = MediaPlayer.INDEFINITE;
		mp.setCycleCount(loop);
		
		mp.play();	
		
	}

}

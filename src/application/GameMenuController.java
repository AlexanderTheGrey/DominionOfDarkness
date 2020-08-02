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

public class GameMenuController implements Initializable {
	
	@FXML private AnchorPane root;
	
	@FXML private Button newGameButton;
	@FXML private Button creditsButton;
	@FXML private Button exitGameMenuButton;
	
	public static MediaPlayer mp = null;
	
	public static boolean loadMusic = false;
	
	
	@FXML
	void loadNewGame(ActionEvent event) {

		if(LauncherController.mp.getStatus() == MediaPlayer.Status.PLAYING) {
			LauncherController.mp.stop();
			LauncherController.mp.dispose();
		}
		
		if (mp != null) {
			if (mp.getStatus() == MediaPlayer.Status.PLAYING) {
				
				mp.stop();
				mp.dispose();
				loadMusic = false;
			}
		}
		
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
    	
    	try {
			AnchorPane creditsPane = (AnchorPane)FXMLLoader.load(getClass().getResource("/application/fxml/CreditsMenu.fxml"));
			this.root.getChildren().setAll(creditsPane);
		} catch (IOException e) {
			e.printStackTrace();
		}

    }

    
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		if (loadMusic) {
			
			String path = Main.class.getResource("/application/resources/game_menu/music/GameMenu.mp3").toString();
	        Media media = new Media(path);
	        mp = new MediaPlayer(media);
	        int loop = MediaPlayer.INDEFINITE;
	        mp.setCycleCount(loop);
	        mp.play();
	        
	        loadMusic = false;
		}

	}
	
	
	@FXML
    void closeGameMenuAction(ActionEvent event) {
		
		Platform.exit();
    }
}
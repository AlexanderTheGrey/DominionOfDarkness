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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import model.Model;

import areas.DeathAreas;

public class CityGravesController implements Initializable {
	
	@FXML AnchorPane root;
	
	@FXML private Button cityGravesNexusButton;

	@FXML private Button cityGravesExitButton;
	
	@FXML private Button northButton;
	@FXML private Button southButton;
	@FXML private Button eastButton;
	@FXML private Button westButton;
	@FXML private Button northEastButton;
	@FXML private Button northWestButton;
	@FXML private Button southEastButton;
	@FXML private Button southWestButton;
	
	@FXML private ImageView cityGravesBackground;
			
	public static MediaPlayer mp;
	
	@FXML void goNorth(ActionEvent event) {
		
		Model.goNorth(cityGravesBackground, cityGravesNexusButton);
		
		if (PrimaryGameController.currentArea == DeathAreas.REAPER) {
						
			loadDeath();
		}
	}



	@FXML void goSouth(ActionEvent event) {
		
		Model.goSouth(cityGravesBackground, cityGravesNexusButton);
	}



	@FXML void goEast(ActionEvent event) {


	}



	@FXML void goWest(ActionEvent event) {


	}



	@FXML void goNorthEast(ActionEvent event) {


	}



	@FXML void goNorthWest(ActionEvent event) {


	}



	@FXML void goSouthEast(ActionEvent event) {


	}




	@FXML void goSouthWest(ActionEvent event) {


	}
	
	
	
	@FXML void loadNexus(ActionEvent event) {
		
		mp.stop();
		mp.dispose();

		try {
			AnchorPane primaryGamePane = (AnchorPane)FXMLLoader.load(getClass().getResource("/application/fxml/PrimaryGame.fxml"));
			this.root.getChildren().setAll(primaryGamePane);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	void loadDeath() {
		
		mp.stop();
		mp.dispose();
		    	
    	String path = Main.class.getResource("/application/resources/in_game/sound_effects/Horror Demonic Possession 01.wav").toString();
		Media musicmedia = new Media(path);
		DeathController.mp = new MediaPlayer(musicmedia);
		
		int loop = MediaPlayer.INDEFINITE;
		DeathController.mp.setCycleCount(loop);

		DeathController.mp.play();
    	
    	try {
			AnchorPane newGamePane = (AnchorPane)FXMLLoader.load(getClass().getResource("/application/fxml/Death.fxml"));
			root.getChildren().setAll(newGamePane);
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

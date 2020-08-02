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

public class WatchTowerController implements Initializable {
	
	@FXML AnchorPane root;
	
	@FXML private Button watchTowerNexusButton;

	@FXML private Button watchTowerExitButton;
	
	@FXML private Button northButton;
	@FXML private Button southButton;
	@FXML private Button eastButton;
	@FXML private Button westButton;
	@FXML private Button northEastButton;
	@FXML private Button northWestButton;
	@FXML private Button southEastButton;
	@FXML private Button southWestButton;
	
	@FXML private ImageView watchTowerBackground;
			
	public static MediaPlayer mp;
	
	
	
	@FXML void goNorth(ActionEvent event) {
		
		Model.goNorth(watchTowerBackground, watchTowerNexusButton);
	}



	@FXML void goSouth(ActionEvent event) {
		
		Model.goSouth(watchTowerBackground, watchTowerNexusButton);
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



	@FXML
	void closeGameAction(ActionEvent event) {

		Platform.exit();
	}



	@Override
	public void initialize(URL url, ResourceBundle resources) {
		
		String path1 = Main.class.getResource("/application/resources/in_game/ambient_music/Watch Tower Ambience.m4a").toString();
		Media musicmedia = new Media(path1);
		mp = new MediaPlayer(musicmedia);
		
		int loop = MediaPlayer.INDEFINITE;
		mp.setCycleCount(loop);
		
		mp.play();	
		
	}

}

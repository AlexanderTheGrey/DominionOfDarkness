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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class PrimaryGameController implements Initializable {
	
	@FXML private AnchorPane root;
		
	private static MediaPlayer mp;
	
	@FXML private Button inventoryButton;
	@FXML private Button statsButton;
	
	@FXML private Button peakButton;
	@FXML private Button hallButton;
	@FXML private Button woodsButton;
	@FXML private Button watchTowerButton;
	@FXML private Button willowButton;
	@FXML private Button cliifssButton;
	@FXML private Button cityGravesButton;
	@FXML private Button citySubmergedButton;
	@FXML private Button shipButton;
	@FXML private Button depthsButton;
	
	@FXML private Button primaryGameExitButton;
	
	
	
	@FXML
    void loadInventory(ActionEvent event) {

    }
	
	

    @FXML
    void loadStats(ActionEvent event) {
	
    }
    
    
    @FXML
    void loadPeak(ActionEvent event) {
    	
    	try {
			AnchorPane newGamePane = (AnchorPane)FXMLLoader.load(getClass().getResource("/application/fxml/Peak.fxml"));
			this.root.getChildren().setAll(newGamePane);
		} catch (IOException e) {
			e.printStackTrace();
		}

    }

    @FXML
    void loadHall(ActionEvent event) {

    }

    @FXML
    void loadWoods(ActionEvent event) {

    }

    @FXML
    void loadWatchTower(ActionEvent event) {

    }

    @FXML
    void loadWillow(ActionEvent event) {

    }

    @FXML
    void loadCliffs(ActionEvent event) {

    }

    @FXML
    void loadCityGraves(ActionEvent event) {

    }

    @FXML
    void loadCitySubmerged(ActionEvent event) {

    }

    @FXML
    void loadShip(ActionEvent event) {

    }
    
    @FXML
    void loadDepths(ActionEvent event) {

    }

    
    
	@Override
	public void initialize(URL url, ResourceBundle rb) {

		String path1 = Main.class.getResource("/application/resources/in_game/ambient_music/PrimaryGameAmbientMusic.m4a").toString();
		Media musicmedia = new Media(path1);
		mp = new MediaPlayer(musicmedia);
		
		int loop = MediaPlayer.INDEFINITE;
		mp.setCycleCount(loop);
		
		mp.play();	
	}

	
	@FXML
    void closeGameAction(ActionEvent event) {
		
		Platform.exit();
    }
}
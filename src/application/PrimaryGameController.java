package application;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;

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
			
	@FXML private Button inventoryButton;
	@FXML private Button statsButton;
	
	@FXML private Button peakButton;
	@FXML private Button hallButton;
	@FXML private Button woodsButton;
	@FXML private Button watchTowerButton;
	@FXML private Button willowButton;
	@FXML private Button cliffsButton;
	@FXML private Button cityGravesButton;
	@FXML private Button citySubmergedButton;
	@FXML private Button shipButton;
	@FXML private Button depthsButton;
	
	@FXML private Button primaryGameExitButton;
	
	private static MediaPlayer mp;
	
	
	
	@FXML
    void loadInventory(ActionEvent event) {

    }
	
	

    @FXML
    void loadStats(ActionEvent event) {
	
    }
    
    
    
    @FXML
    void loadPeak(ActionEvent event) {
    	
    	mp.stop();
		mp.dispose();
    	
    	try {
			AnchorPane newGamePane = (AnchorPane)FXMLLoader.load(getClass().getResource("/application/fxml/areas/Peak.fxml"));
			this.root.getChildren().setAll(newGamePane);
		} catch (IOException e) {
			e.printStackTrace();
		}

    }

    
    
    @FXML
    void loadHall(ActionEvent event) {
    	
    	mp.stop();
		mp.dispose();
    	
    	try {
			AnchorPane newGamePane = (AnchorPane)FXMLLoader.load(getClass().getResource("/application/fxml/areas/Hall.fxml"));
			this.root.getChildren().setAll(newGamePane);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    
    
    @FXML
    void loadWoods(ActionEvent event) {
    	
    	mp.stop();
		mp.dispose();
    	
    	try {
			AnchorPane newGamePane = (AnchorPane)FXMLLoader.load(getClass().getResource("/application/fxml/areas/Woods.fxml"));
			this.root.getChildren().setAll(newGamePane);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    
    
    @FXML
    void loadWatchTower(ActionEvent event) {

    	mp.stop();
		mp.dispose();
    	
    	try {
			AnchorPane newGamePane = (AnchorPane)FXMLLoader.load(getClass().getResource("/application/fxml/areas/WatchTower.fxml"));
			this.root.getChildren().setAll(newGamePane);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    
    
    @FXML
    void loadWillow(ActionEvent event) {
    	
    	int randomNum = ThreadLocalRandom.current().nextInt(0, 10);
    	
    	mp.stop();
		mp.dispose();
    	
    	if (randomNum < 5) {
    		
    		try {
    			AnchorPane newGamePane = (AnchorPane)FXMLLoader.load(getClass().getResource("/application/fxml/areas/Willow.fxml"));
    			this.root.getChildren().setAll(newGamePane);
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    	}
    	else {
    		
    		try {
    			AnchorPane newGamePane = (AnchorPane)FXMLLoader.load(getClass().getResource("/application/fxml/areas/DarkWillow.fxml"));
    			this.root.getChildren().setAll(newGamePane);
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    		
    	}
    }

    
    
    @FXML
    void loadCliffs(ActionEvent event) {

    	mp.stop();
		mp.dispose();
    	
    	try {
			AnchorPane newGamePane = (AnchorPane)FXMLLoader.load(getClass().getResource("/application/fxml/areas/Cliffs.fxml"));
			this.root.getChildren().setAll(newGamePane);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    
    
    @FXML
    void loadCityGraves(ActionEvent event) {

    	mp.stop();
		mp.dispose();
    	
    	try {
			AnchorPane newGamePane = (AnchorPane)FXMLLoader.load(getClass().getResource("/application/fxml/areas/CityGraves.fxml"));
			this.root.getChildren().setAll(newGamePane);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    
    
    @FXML
    void loadCitySubmerged(ActionEvent event) {

    	mp.stop();
		mp.dispose();
    	
    	try {
			AnchorPane newGamePane = (AnchorPane)FXMLLoader.load(getClass().getResource("/application/fxml/areas/CitySubmerged.fxml"));
			this.root.getChildren().setAll(newGamePane);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    
    
    @FXML
    void loadShip(ActionEvent event) {

    	mp.stop();
		mp.dispose();
    	
    	try {
			AnchorPane newGamePane = (AnchorPane)FXMLLoader.load(getClass().getResource("/application/fxml/areas/Ship.fxml"));
			this.root.getChildren().setAll(newGamePane);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    
    
    @FXML
    void loadDepths(ActionEvent event) {

    	mp.stop();
		mp.dispose();
    	
    	try {
			AnchorPane newGamePane = (AnchorPane)FXMLLoader.load(getClass().getResource("/application/fxml/areas/Depths.fxml"));
			this.root.getChildren().setAll(newGamePane);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    
    
	@Override
	public void initialize(URL url, ResourceBundle rb) {

		String path1 = Main.class.getResource("/application/resources/in_game/ambient_music/The Nexus Ambience.m4a").toString();
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
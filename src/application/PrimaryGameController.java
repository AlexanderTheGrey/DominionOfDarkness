package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.util.Duration;
import areas.*;

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
	
	@FXML private Text welcomeText1;
	@FXML private Text welcomeText2;
	
	public static Object currentArea;
				
	protected static boolean loadMusic = true;
	protected static boolean firstRun = true;
	
	private static MediaPlayer mp;
	
	
	
	@FXML
    void loadInventory(ActionEvent event) {
				
		loadMusic = false;
		
		try {
			AnchorPane primaryGamePane = (AnchorPane)FXMLLoader.load(getClass().getResource("/application/fxml/Inventory.fxml"));
			this.root.getChildren().setAll(primaryGamePane);
		} catch (IOException e) {
			e.printStackTrace();
		}

    }
	
	

    @FXML
    void loadStats(ActionEvent event) {
	
    }
    
    
    
    @FXML
    void loadPeak(ActionEvent event) {
    	
    	currentArea = PeakAreas.HOME;
    	    	
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
    	
    	currentArea = HallAreas.HOME;
    	    	
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
    	
    	currentArea = WoodsAreas.HOME;
    	    	
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
    	
    	currentArea = WatchTowerAreas.HOME;
    	    	
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
    		
    		currentArea = WillowAreas.HOME;
    		
    		try {
    			AnchorPane newGamePane = (AnchorPane)FXMLLoader.load(getClass().getResource("/application/fxml/areas/Willow.fxml"));
    			this.root.getChildren().setAll(newGamePane);
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    	}
    	else {
    		
    		currentArea = DarkWillowAreas.HOME;
    		
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
    	
    	currentArea = CliffsAreas.HOME;
    	    	
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
    	
    	currentArea = CityGravesAreas.HOME;
    	    	
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
    	
    	currentArea = CitySubmergedAreas.HOME;
    	    	
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
    	
    	currentArea = ShipAreas.HOME;
    	    	
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
    	
    	currentArea = DepthsAreas.HOME;
    	    	
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
		
		if(LauncherController.mp.getStatus() == MediaPlayer.Status.PLAYING) {
			LauncherController.mp.stop();
			LauncherController.mp.dispose();
		}
		
		if(loadMusic) {

			String path1 = Main.class.getResource("/application/resources/in_game/ambient_music/The Nexus Ambience.m4a").toString();
			Media musicmedia = new Media(path1);
			mp = new MediaPlayer(musicmedia);

			int loop = MediaPlayer.INDEFINITE;
			mp.setCycleCount(loop);

			mp.play();	
		}
		
		loadMusic = true;
		
		
		
		if (firstRun) {

			FadeTransition fadeIn1 = new FadeTransition(
					Duration.millis(4000)
					);


			FadeTransition fadeIn2 = new FadeTransition(
					Duration.millis(2500)
					);
			
			fadeIn1.setNode(welcomeText1);

			fadeIn1.setFromValue(0.0);
			fadeIn1.setToValue(0.5);
			fadeIn1.setCycleCount(2);
			fadeIn1.setAutoReverse(true);
			
			welcomeText1.setOpacity(0.0);
			welcomeText1.setVisible(true);
			
			fadeIn1.playFromStart();



			fadeIn1.setOnFinished(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					fadeIn2.setNode(welcomeText2);

					fadeIn2.setFromValue(0.0);
					fadeIn2.setToValue(0.5);
					fadeIn2.setCycleCount(2);
					fadeIn2.setAutoReverse(true);
					
					welcomeText2.setOpacity(0.0);
					welcomeText2.setVisible(true);

					fadeIn2.playFromStart();
				}
			});
			
			firstRun= false;
		}
	}

	
	
	@FXML
    void closeGameAction(ActionEvent event) {
		
		Platform.exit();
    }
}
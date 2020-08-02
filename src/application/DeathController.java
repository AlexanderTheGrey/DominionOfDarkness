package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class DeathController implements Initializable {

	@FXML AnchorPane root;

	@FXML private Button deathMainMenuButton;
	@FXML private Button deathNewGameButton;

	@FXML private Button deathExitButton;
	
	@FXML private Text gameOverText;
	@FXML private Text deathReasonText;

	public static MediaPlayer mp;

	

	@FXML void loadMainMenu(ActionEvent event) {

		PrimaryGameController.firstRun = true;
		GameMenuController.loadMusic = true;

		mp.stop();
		mp.dispose();

		try {
			AnchorPane primaryGamePane = (AnchorPane)FXMLLoader.load(getClass().getResource("/application/fxml/GameMenu.fxml"));
			this.root.getChildren().setAll(primaryGamePane);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	

	@FXML void loadNewGame(ActionEvent event) {

		PrimaryGameController.firstRun = true;

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
		
		FadeTransition fadeIn1 = new FadeTransition(
				Duration.millis(4000)
				);


		FadeTransition fadeIn2 = new FadeTransition(
				Duration.millis(2500)
				);
		
		fadeIn1.setNode(gameOverText);

		fadeIn1.setFromValue(0.0);
		fadeIn1.setToValue(0.5);
		fadeIn1.setCycleCount(1);
		fadeIn1.setAutoReverse(false);
		
		gameOverText.setOpacity(0.0);
		gameOverText.setVisible(true);
		
		fadeIn1.playFromStart();


		
		fadeIn1.setOnFinished(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				fadeIn2.setNode(deathReasonText);

				fadeIn2.setFromValue(0.0);
				fadeIn2.setToValue(0.5);
				fadeIn2.setCycleCount(1);
				fadeIn2.setAutoReverse(false);
				
				deathReasonText.setOpacity(0.0);
				deathReasonText.setVisible(true);

				fadeIn2.playFromStart();
				
				
			}
		});

	}

}

package application;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;

public class PeakController {
	
	@FXML AnchorPane root;

	@FXML private Button peakNexusButton;

	@FXML private Button peakExitButton;



	@FXML void loadNexus(ActionEvent event) {


		//String path = Main.class.getResource("/application/resources/in_game/sound_effects/Horror Scary Male Demon Talk 01.wav").toString();
		//AudioClip a = new AudioClip(path);
		//a.play();

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

}

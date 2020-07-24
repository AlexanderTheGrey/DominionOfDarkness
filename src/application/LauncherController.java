package application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class LauncherController {
	
	@FXML private AnchorPane root;
	
	@FXML private Button launchGameButton;
	@FXML private Button closeGameLauncherButton;
	
	protected static MediaPlayer mp;
	
	@FXML
	public void launchGame(ActionEvent event) {
		((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
		
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/application/fxml/GameMenu.fxml"));
			Scene scene = new Scene(root);
			Stage gameStage = new Stage();
			
			Main.mp.stop();
			Main.mp.dispose();
			
			String path = Main.class.getResource("/application/resources/game_menu/music/GameMenu.mp3").toString();
	        Media media = new Media(path);
	        mp = new MediaPlayer(media);
	        int loop = mp.INDEFINITE;
	        mp.setCycleCount(loop);
	        mp.play();
		    
			scene.getStylesheets().add(getClass().getResource("/application/fxml/application.css").toExternalForm());
			gameStage.setScene(scene);
			
			gameStage.setFullScreen(true);
			
			gameStage.setTitle("Dominion of Darkness");
			
			gameStage.getIcons().add(new Image(Main.class.getResource("/application/resources/Icon.png").toString()));

			gameStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
    void closeWindowAction(ActionEvent event) {
		
		Platform.exit();
    }
}
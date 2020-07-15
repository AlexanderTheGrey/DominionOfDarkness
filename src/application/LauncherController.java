package application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LauncherController {
	
	//@FXML private javafx.scene.control.Button exitButton;

	/*@FXML
	private void closeWindowAction(){
	    // get a handle to the stage
	    Stage stage = (Stage) exitButton.getScene().getWindow();
	    // do what you have to do
	    stage.close();
	}*/
	
	@FXML
	public void launchGame(ActionEvent event) {
		((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
		
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Game.fxml"));
			Scene scene = new Scene(root);
			Stage gameStage = new Stage();
			
			
			Image gameImageBackground = new Image("/application/TestGameBackground4.jpg");
			
		    BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
		    root.setBackground(new Background(new BackgroundImage(gameImageBackground,
		            BackgroundRepeat.NO_REPEAT,
		            BackgroundRepeat.NO_REPEAT,
		            BackgroundPosition.CENTER,
		            bSize)));

			
		    
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			gameStage.setScene(scene);
			
			gameStage.setFullScreen(true);
			//gameStage.setResizable(false);
			//gameStage.initStyle(StageStyle.UNDECORATED);
			
			gameStage.setTitle("Dominion of Darkness");

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
package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	
	protected static MediaPlayer mp;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/application/fxml/Launcher.fxml"));
			Scene scene = new Scene(root);
			
			scene.getStylesheets().add(getClass().getResource("/application/fxml/application.css").toExternalForm());
			primaryStage.setScene(scene);
			
			primaryStage.setResizable(false);
			primaryStage.initStyle(StageStyle.UNDECORATED);
			
			primaryStage.setTitle("Dominion of Darkness Launcher");
			
			String path = Main.class.getResource("/application/resources/launcher/music/launch-music.mp3").toString();
	        Media media = new Media(path);
	        mp = new MediaPlayer(media);
	        mp.play();
			
	        primaryStage.getIcons().add(new Image(Main.class.getResource("/application/resources/Icon.png").toString()));
	        
			primaryStage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

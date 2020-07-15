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
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Launcher.fxml"));
			Scene scene = new Scene(root);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			
			primaryStage.setResizable(false);
			primaryStage.initStyle(StageStyle.UNDECORATED);
			
			primaryStage.setTitle("Dominion of Darkness Launcher");
			
			String path = Main.class.getResource("/application/TestLaunchMusic.mp3").toString();
	        Media media = new Media(path);
	        MediaPlayer mp = new MediaPlayer(media);
	        mp.play();
	        
	        //String iconPath = Main.class.getResource("/application/DarkFireIcon.png").toString();
	        //Image icon = new Image(iconPath); 
	        //primaryStage.getIcons().add(icon);
			
	        primaryStage.getIcons().add(new Image(Main.class.getResource("/application/Ritual.png").toString()));
	        
			primaryStage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

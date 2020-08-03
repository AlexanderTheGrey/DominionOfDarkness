package model;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.util.concurrent.ThreadLocalRandom;

import application.*;
import areas.*;

public class Model {

	public static void goNorth(ImageView background, Button nexusButton) {

		String path;
		
		int randomNum = ThreadLocalRandom.current().nextInt(1, 10 + 1);

		// North Cliffs
		
		if(PrimaryGameController.currentArea == CliffsAreas.HOME) {

			CliffsController.mp.stop();
			CliffsController.mp.dispose();		// Maybe stop/play instead of reloading the ambient music every time?

			PrimaryGameController.currentArea = CliffsAreas.CATHEDRAL;

			nexusButton.setVisible(false);

			path = Main.class.getResource("/application/resources/in_game/graphics/The Cliffs of Ahm Ytr - Cathedral.jpg").toString();
			background.setImage(new Image(path));

			path = Main.class.getResource("/application/resources/in_game/ambient_music/Cliffs Ambience - Cathedral.mp3").toString();
			Media musicmedia = new Media(path);
			CliffsController.mp = new MediaPlayer(musicmedia);

			int loop = MediaPlayer.INDEFINITE;
			CliffsController.mp.setCycleCount(loop);

			CliffsController.mp.play();

		} else if (PrimaryGameController.currentArea == CliffsAreas.CATHEDRAL) {

			CliffsController.mp.stop();
			CliffsController.mp.dispose();

			PrimaryGameController.currentArea = CliffsAreas.GRAVEYARD;

			nexusButton.setVisible(false);

			path = Main.class.getResource("/application/resources/in_game/graphics/The Cliffs of Ahm Ytr - Cathedral Graveyard.jpg").toString();
			background.setImage(new Image(path));

			path = Main.class.getResource("/application/resources/in_game/ambient_music/Cliffs Ambience - Graveyard.mp3").toString();
			Media musicmedia = new Media(path);
			CliffsController.mp = new MediaPlayer(musicmedia);

			int loop = MediaPlayer.INDEFINITE;
			CliffsController.mp.setCycleCount(loop);

			CliffsController.mp.play();
		}
		
		
		
		
		
		// North City Graves
		
		else if (PrimaryGameController.currentArea == CityGravesAreas.HOME && randomNum <= 7) {

			PrimaryGameController.currentArea = CityGravesAreas.INNERCITY;

			nexusButton.setVisible(false);

			path = Main.class.getResource("/application/resources/in_game/graphics/City of Graves - Inner City.jpg").toString();
			background.setImage(new Image(path));
		
		// DEATH
		} else if (PrimaryGameController.currentArea == CityGravesAreas.HOME && randomNum >= 8) {
			
			CityGravesController.mp.stop();
			CityGravesController.mp.dispose();
			
			nexusButton.setVisible(false);
			
			PrimaryGameController.currentArea = DeathAreas.REAPER;
						
		} else if (PrimaryGameController.currentArea == CityGravesAreas.INNERCITY) {

			PrimaryGameController.currentArea = CityGravesAreas.OVERGROWN;

			nexusButton.setVisible(false);

			path = Main.class.getResource("/application/resources/in_game/graphics/City of Graves - Overgrown.jpg").toString();
			background.setImage(new Image(path));
		}
		
	}



	public static void goSouth(ImageView background, Button nexusButton) {

		String path;
		
		// South Cliffs

		if(PrimaryGameController.currentArea == CliffsAreas.CATHEDRAL) {

			CliffsController.mp.stop();
			CliffsController.mp.dispose();

			PrimaryGameController.currentArea = CliffsAreas.HOME;

			nexusButton.setVisible(true);

			path = Main.class.getResource("/application/resources/in_game/graphics/The Cliffs of Ahm Ytr.jpg").toString();
			background.setImage(new Image(path));

			path = Main.class.getResource("/application/resources/in_game/ambient_music/Cliffs Ambience.m4a").toString();
			Media musicmedia = new Media(path);
			CliffsController.mp = new MediaPlayer(musicmedia);

			int loop = MediaPlayer.INDEFINITE;
			CliffsController.mp.setCycleCount(loop);

			CliffsController.mp.play();
			
		} else if (PrimaryGameController.currentArea == CliffsAreas.GRAVEYARD) {

			CliffsController.mp.stop();
			CliffsController.mp.dispose();

			PrimaryGameController.currentArea = CliffsAreas.CATHEDRAL;

			nexusButton.setVisible(false);

			path = Main.class.getResource("/application/resources/in_game/graphics/The Cliffs of Ahm Ytr - Cathedral.jpg").toString();
			background.setImage(new Image(path));

			path = Main.class.getResource("/application/resources/in_game/ambient_music/Cliffs Ambience - Cathedral.mp3").toString();
			Media musicmedia = new Media(path);
			CliffsController.mp = new MediaPlayer(musicmedia);

			int loop = MediaPlayer.INDEFINITE;
			CliffsController.mp.setCycleCount(loop);

			CliffsController.mp.play();
		}
		
		
		
		
		
		// South City Graves
		
		else if (PrimaryGameController.currentArea == CityGravesAreas.INNERCITY) {

			PrimaryGameController.currentArea = CityGravesAreas.HOME;

			nexusButton.setVisible(true);

			path = Main.class.getResource("/application/resources/in_game/graphics/City of Graves.jpg").toString();
			background.setImage(new Image(path));
		} else if (PrimaryGameController.currentArea == CityGravesAreas.OVERGROWN) {

			PrimaryGameController.currentArea = CityGravesAreas.INNERCITY;

			nexusButton.setVisible(false);

			path = Main.class.getResource("/application/resources/in_game/graphics/City of Graves - Inner City.jpg").toString();
			background.setImage(new Image(path));			
		} 
	}



	public static void goEast(Object currentArea, ImageView background, MediaPlayer mp, Button nexusButton) {

	}



	public static void goWest(Object currentArea, ImageView background, MediaPlayer mp, Button nexusButton) {

	}



	public static void goNorthEast(Object currentArea, ImageView background, MediaPlayer mp, Button nexusButton) {

	}



	public static void goNorthWest(Object currentArea, ImageView background, MediaPlayer mp, Button nexusButton) {

	}



	public static void goSouthEast(Object currentArea, ImageView background, MediaPlayer mp, Button nexusButton) {

	}



	public static void goSouthWest(Object currentArea, ImageView background, MediaPlayer mp, Button nexusButton) {

	}
}
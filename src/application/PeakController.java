package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import model.Model;
import model.Puzzle8Model;

public class PeakController implements Initializable {
	
	@FXML AnchorPane root;
	
	@FXML private Button peakNexusButton;

	@FXML private Button peakExitButton;
	
	@FXML private Button northButton;
	@FXML private Button southButton;
	@FXML private Button eastButton;
	@FXML private Button westButton;
	@FXML private Button northEastButton;
	@FXML private Button northWestButton;
	@FXML private Button southEastButton;
	@FXML private Button southWestButton;
	
	
	@FXML public Button peakPuzzleButton;	
	@FXML public Button tile11;
	@FXML public Button tile21;
	@FXML public Button tile31;
	@FXML public Button tile12;
	@FXML public Button tile22;
	@FXML public Button tile32;
	@FXML public Button tile13;
	@FXML public Button tile23;
	@FXML public Button tile33;
	
	@FXML private Label peakMessage;
	
	public static ArrayList<Integer> solution = new ArrayList<Integer>();
	public static ArrayList<Integer> rows = new ArrayList<Integer>();
	
	public static String choice;
	public static int spaceX;
	public static int spaceY;
	public static int choiceX;
	public static int choiceY;
	
	public static boolean hasBeenSolved = false;
	
	
	@FXML private ImageView peakBackground;
			
	public static MediaPlayer mp;
	
	
	
	@FXML void goNorth(ActionEvent event) {
		
		Model.goNorth(peakBackground, peakNexusButton);
	}



	@FXML void goSouth(ActionEvent event) {
		
		Model.goSouth(peakBackground, peakNexusButton);
	}



	@FXML void goEast(ActionEvent event) {
	}



	@FXML void goWest(ActionEvent event) {
	}



	@FXML void goNorthEast(ActionEvent event) {
	}



	@FXML void goNorthWest(ActionEvent event) {
	}



	@FXML void goSouthEast(ActionEvent event) {
	}




	@FXML void goSouthWest(ActionEvent event) {
	}

	
	
	
	/** Implement puzzle game **/
	
	public void updateTiles () {
		tile11.setText(rows.get(0).toString());
		tile21.setText(rows.get(1).toString());
		tile31.setText(rows.get(2).toString());
		tile12.setText(rows.get(3).toString());
		tile22.setText(rows.get(4).toString());
		tile32.setText(rows.get(5).toString());
		tile13.setText(rows.get(6).toString());
		tile23.setText(rows.get(7).toString());
		tile33.setText(rows.get(8).toString());
		
			
	}
	
	public void lockTileButtons(boolean b) {
		tile11.setDisable(b);
		tile21.setDisable(b);
		tile31.setDisable(b);
		tile12.setDisable(b);
		tile22.setDisable(b);
		tile32.setDisable(b);
		tile13.setDisable(b);
		tile23.setDisable(b);
		tile33.setDisable(b);
	}
	
	// Projects the numbers to the tiles
	public void buildBoard() {
		tile11.setText(rows.get(0).toString());
		tile21.setText(rows.get(1).toString());
		tile31.setText(rows.get(2).toString());
		tile12.setText(rows.get(3).toString());
		tile22.setText(rows.get(4).toString());
		tile32.setText(rows.get(5).toString());
		tile13.setText(rows.get(6).toString());
		tile23.setText(rows.get(7).toString());
		tile33.setText(rows.get(8).toString());
	}
	
	@FXML void startPuzzleButton(ActionEvent event) {
		solution.clear();
		rows.clear();
		
		Puzzle8Model.makeSolution(solution);
		Puzzle8Model.makeSolution(rows);
		rows = Puzzle8Model.shuffleTiles(rows);
		
		// Puzzle must be solvable before it is given
		while(!Puzzle8Model.isSolvable(rows))
			rows = Puzzle8Model.shuffleTiles(rows);
		
		buildBoard();
		
		lockTileButtons(false);
		
		peakMessage.setText("Perhaps the tiles can be shifted.");
		
		peakPuzzleButton.setVisible(false);
	}
	
	
	// When tile button is pressed
	@FXML void tileButton(ActionEvent event) {
		Integer temp;
		Button btn = (Button) event.getSource();
		String id = btn.getId();
		Integer tileNum = Integer.parseInt(btn.getText());
		
		Pattern p = Pattern.compile("\\d{2}");
		Matcher m = p.matcher(id);
		if(m.find())
			choice = m.group(0); // get tile coordinates
		
		spaceX = ((rows.indexOf(0)%3)+1); // gets column of 0
		spaceY = ((rows.indexOf(0)+3)/3); // gets row of 0
		
		choiceX = choice.charAt(0)-48; // gets column of button
		choiceY = choice.charAt(1)-48; // gets row of button
		
			
		peakMessage.setText(Puzzle8Model.successMessage());
		
		if(!Puzzle8Model.isValidMove(rows, spaceX, spaceY, choiceX, choiceY)) {
			peakMessage.setText("\t[ " + tileNum + " ] appears to be immovable.\t");
		} else {
			// Shift column
			if(spaceX == choiceX) {
				// Swap if neighboring tiles
				temp = rows.indexOf(0);				
				rows.set(rows.indexOf(tileNum), 0);
				rows.set(temp, tileNum);
			}
			// Shift row
			else if (spaceY == choiceY) {
				// Swap if neighboring tiles
				temp = rows.indexOf(0);
				rows.set(rows.indexOf(tileNum), 0);
				rows.set(temp, tileNum);
			}
			peakMessage.setText("\tThe passage remains locked.\t");
		}
		
		// Update board
		updateTiles();
		
		
		
		if(Puzzle8Model.checkSolution(rows, solution)) {
			peakMessage.setText(Puzzle8Model.successMessage());
			hasBeenSolved = true;
			
			buildBoard();
			
			// Lock puzzle if already completed
			lockTileButtons(true);
		}
	} // end of tileButton(event)

	
	
	
	/** End of puzzle game implementation **/

	@FXML void loadNexus(ActionEvent event) {

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
		
		/** Initiate puzzle **/
		lockTileButtons(true);
		
		// Disable start if puzzle already completed
		if(hasBeenSolved) {
			peakPuzzleButton.setVisible(false);
			peakMessage.setText("The passage is open.");
			buildBoard();
		}

		
		
		String path1 = Main.class.getResource("/application/resources/in_game/ambient_music/Peak Ambience.m4a").toString();
		Media musicmedia = new Media(path1);
		mp = new MediaPlayer(musicmedia);
		
		int loop = MediaPlayer.INDEFINITE;
		mp.setCycleCount(loop);
		
		mp.play();	
		
	}

}

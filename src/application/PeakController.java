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
	public static ArrayList<Button> tileList = new ArrayList<Button>();
	
	
	// Tile pressed is interpreted by the XY value
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

	/** Unused compass functions **/

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

	
	
	/**** Implement puzzle game ****/
	
	// Create a list of buttons for easy iteration
	public void fillButtonList (ArrayList<Button> list) {
		list.add(tile11);
		list.add(tile21);
		list.add(tile31);
		list.add(tile12);
		list.add(tile22);
		list.add(tile32);
		list.add(tile13);
		list.add(tile23);
		list.add(tile33);
	}
	
	// Disables tile buttons
	public void lockTileButtons(boolean b) {
		for(int i = 0; i < tileList.size(); i++) {
			tileList.get(i).setDisable(b);
		}
	}
	
	// Projects the numbers to the tiles
	public void updateTiles() {
		// Iterate through tileList ( button list )
		for(int i = 0; i < tileList.size(); i++) {
			tileList.get(i).setText(rows.get(i).toString()); // Update tile number
			
			// Make tile "0" invisible ( so it acts as the "space" )
			if(Integer.parseInt(tileList.get(i).getText()) == 0)
				tileList.get(i).setVisible(false);
			else
				tileList.get(i).setVisible(true);
		}
		
		// Check if puzzle has been solved after each move
		if(Puzzle8Model.checkSolution(rows, solution)) {
			peakMessage.setText(Puzzle8Model.successMessage());
			hasBeenSolved = true;
			
			tileList.get(8).setText("9"); // monogram for PLuto ( Astrology easter egg for the former ninth planet )
			tileList.get(8).setVisible(true);
					
			lockTileButtons(true);
		}
	} // END of updateTiles()
	
	/** When puzzle is started, setup board **/
	@FXML void startPuzzleButton(ActionEvent event) {
		solution.clear();
		rows.clear();
		
		Puzzle8Model.makeSolution(solution);
		Puzzle8Model.makeSolution(rows);
		rows = Puzzle8Model.shuffleTiles(rows);
		
		// Puzzle must be solvable before it is given
		while(!Puzzle8Model.isSolvable(rows))
			rows = Puzzle8Model.shuffleTiles(rows);
		
		updateTiles();
		
		lockTileButtons(false);
		
		peakMessage.setText("Perhaps the tiles can be shifted.");
		
		peakPuzzleButton.setVisible(false);
	} // end of startPuzzleButton(event)
	
	
	/** When tile button is pressed **/
	@FXML void tileButton(ActionEvent event) {
		Integer temp;	 // set up swap variable ( for tile swapping )
		Integer tileNum; // actual number displayed on tile
		
		Button btn = (Button) event.getSource();
		String id = btn.getId();
		Pattern p = Pattern.compile("\\d{2}");
		
		Matcher m = p.matcher(id); // match "XY" in string "tileXY"
		if(m.find())
			choice = m.group(0); // get tile coordinates
		
		tileNum = Integer.parseInt(btn.getText()); // get actual number displayed on tile
		
		spaceX = ((rows.indexOf(0)%3)+1); // gets column of space
		spaceY = ((rows.indexOf(0)+3)/3); // gets row of space
		
		choiceX = choice.charAt(0)-48; // gets column of button
		choiceY = choice.charAt(1)-48; // gets row of button
		
		peakMessage.setText(Puzzle8Model.successMessage());
		
		// Swap tiles if valid move
		if(!Puzzle8Model.isValidMove(rows, spaceX, spaceY, choiceX, choiceY)) {
			peakMessage.setText("\t[ " + tileNum + " ] appears to be immovable.\t");
		} else {
			// Shift Column
			if(spaceX == choiceX) {
				// Swap if neighboring tiles
				temp = rows.indexOf(0);				
				rows.set(rows.indexOf(tileNum), 0);
				rows.set(temp, tileNum);
			}
			// Shift Row
			else if (spaceY == choiceY) {
				// Swap if neighboring tiles
				temp = rows.indexOf(0);
				rows.set(rows.indexOf(tileNum), 0);
				rows.set(temp, tileNum);
			} 
			peakMessage.setText("\tThe passage remains locked.\t");
		} // end of valid move
		
		updateTiles(); // Update tiles after swap
		 
	} // end of tileButton(event)	
	
	/**** END of puzzle game implementation ****/

	
	
	@FXML
	void loadNexus(ActionEvent event) {

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
		Platform.exit(); // exit game
	}



	@Override
	public void initialize(URL url, ResourceBundle resources) {
		
		/** Initiate puzzle **/
		tileList.clear(); // reset button list
		fillButtonList(tileList); // fill button list
		lockTileButtons(true);
		
		// Disable start button if puzzle already completed
		if(hasBeenSolved) {
			peakPuzzleButton.setVisible(false);
			peakMessage.setText("The passage is open.");
			updateTiles();
			//tileList.
		}
		/** END of initiate puzzle **/
		
		
		/** Play media **/
		String path1 = Main.class.getResource("/application/resources/in_game/ambient_music/Peak Ambience.m4a").toString();
		Media musicmedia = new Media(path1);
		mp = new MediaPlayer(musicmedia);
		
		int loop = MediaPlayer.INDEFINITE;
		mp.setCycleCount(loop);
		
		mp.play();	
		/** END of play media **/
	}

}

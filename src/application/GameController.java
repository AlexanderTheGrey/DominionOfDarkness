package application;

//weapons
import weapons.Weapon_Stick;
import weapons.Weapon_Knife;
import weapons.Weapon_Sword;
import weapons.Weapon_Lightsaber;

//player
import player.Player;

//enemies
import enemies.Enemy_Orc;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class GameController {
	
	@FXML private TextFlow gameText;
	
	@FXML
	public void initialize() {
		
		//player stats
		Player player = new Player();
		Text playerHP = new Text("Hello, Your HP is " + player.hp +"\n");
		playerHP.setFill(Color.ANTIQUEWHITE);
		playerHP.setFont(Font.font("Copperplate Gothic Bold", FontPosture.ITALIC, 25));
		gameText.getChildren().add(playerHP);
		
		//stick weapon 
		Weapon_Stick stick = new Weapon_Stick();
		Text weapon = new Text("Your weapon is " + stick.name +" and does " + stick.dmg + "damage!\n");
		weapon.setFill(Color.ANTIQUEWHITE);
		weapon.setFont(Font.font("Copperplate Gothic Bold", FontPosture.ITALIC, 25));
		gameText.getChildren().add(weapon);
		
		//orc stats
		Enemy_Orc orc = new Enemy_Orc();
		Text enemy = new Text("You encounter an " +orc.name+" with " + orc.hp +" hp and does " + orc.dmg + " damage!");
		enemy.setFill(Color.ANTIQUEWHITE);
		enemy.setFont(Font.font("Copperplate Gothic Bold", FontPosture.ITALIC, 25));
		gameText.getChildren().add(enemy);
		
		
		/* Text t1 = new Text("YOU HAVE ENTERED THE GREAT GATES OF AN UKNOWN LAND.\n\n\n\n\n");
		Text t2 = new Text("It's cold and wet. A strong stench of rotten flesh meets your nostrils and reminds you of the peril that has been bestowed upon these lands.\n\n");
		Text t3 = new Text("> ");

		t1.setFill(Color.ANTIQUEWHITE);
	    t1.setFont(Font.font("Copperplate Gothic Bold", FontPosture.ITALIC, 25));
	    
	    t2.setFill(Color.NAVAJOWHITE);
	    t2.setFont(Font.font("Copperplate Gothic Bold", FontPosture.ITALIC, 25));
	    
	    
	    t3.setFill(Color.ANTIQUEWHITE);
	    t3.setFont(Font.font("Helvetica", FontPosture.ITALIC, 50));
	    gameText.getChildren().add(t1);
	    gameText.getChildren().add(t2);
	    gameText.getChildren().add(t3);*/
		
		
		
		
		
		
		/*Text t2 = new Text("You overlook a living city, but all that can be heard is the harsh wind blowing from the east. The silence is deafening.\n\n");
		Text t3 = new Text("> ");

		t2.setFill(Color.NAVAJOWHITE);
		t2.setFont(Font.font("Copperplate Gothic Bold", FontPosture.ITALIC, 25));


		t3.setFill(Color.ANTIQUEWHITE);
		t3.setFont(Font.font("Helvetica", FontPosture.ITALIC, 50));
		gameText.getChildren().add(t2);
		gameText.getChildren().add(t3);*/
		
		/*Text t2 = new Text("You are near a dense forest with the pungent smell of rotting wood. The old, twisted oak tree groans at you as you approach, muffled by screaming crows. The taste of spoiled mist fills the air as you peer upon the gravestones.\n\n");
		Text t3 = new Text("> ");

		t2.setFill(Color.MAROON);
		t2.setFont(Font.font("Copperplate Gothic Bold", FontPosture.ITALIC, 25));
		t2.setStyle("-fx-font-weight: bold");



		t3.setFill(Color.DARKGOLDENROD);
		t3.setFont(Font.font("Helvetica", FontPosture.ITALIC, 50));
		gameText.getChildren().add(t2);
		gameText.getChildren().add(t3);
		
		//Cut off here.
		*/
	    
	    //gameText.getChildren().clear();
	    
		//BorderPane root;

	    
	    /*Image gameImageBackground = new Image("/application/TestGameBackground2.jpg");
		
	    BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
	    root.setBackground(new Background(new BackgroundImage(gameImageBackground,
	            BackgroundRepeat.NO_REPEAT,
	            BackgroundRepeat.NO_REPEAT,
	            BackgroundPosition.CENTER,
	            bSize)));*/

	}
	
	@FXML
    void closeGameAction(ActionEvent event) {
		
		Platform.exit();

    }
	
	
}


package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class CreditsController implements Initializable {
	
	@FXML private AnchorPane root;
	
	@FXML private Text creditAlexanderText;
	@FXML private Text creditMichaelText;
	@FXML private Text creditChristopherText;
	@FXML private Text creditAndreasText;
	@FXML private Text creditLukeText;

	
	@FXML private Button navigateToGameMenuButton;
	
	
	@FXML
    void navigateToGameMenu(ActionEvent event) {
		
		try {
			AnchorPane menuPane = (AnchorPane)FXMLLoader.load(getClass().getResource("/application/fxml/GameMenu.fxml"));
			this.root.getChildren().setAll(menuPane);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		FadeTransition fadeIn1 = new FadeTransition(
			    Duration.millis(5000)
			);
		FadeTransition fadeIn2 = new FadeTransition(
			    Duration.millis(7000)
			);
		FadeTransition fadeIn3 = new FadeTransition(
			    Duration.millis(9000)
			);
		FadeTransition fadeIn4 = new FadeTransition(
			    Duration.millis(11000)
			);
		FadeTransition fadeIn5 = new FadeTransition(
			    Duration.millis(13000)
			);
		
		
		// Alexander Allen
		fadeIn1.setNode(creditAlexanderText);

		fadeIn1.setFromValue(0.0);
		fadeIn1.setToValue(0.5);
		fadeIn1.setCycleCount(1);
		fadeIn1.setAutoReverse(false);
	    
	    creditAlexanderText.setVisible(true);
	    
	    fadeIn1.playFromStart();
        
        // Michael Bisping
        fadeIn2.setNode(creditMichaelText);

        fadeIn2.setFromValue(0.0);
        fadeIn2.setToValue(0.5);
        fadeIn2.setCycleCount(1);
        fadeIn2.setAutoReverse(false);
	    
        creditMichaelText.setVisible(true);
	    
        fadeIn2.playFromStart();
 
        // Christopher Martinez
        fadeIn3.setNode(creditChristopherText);

        fadeIn3.setFromValue(0.0);
        fadeIn3.setToValue(0.5);
        fadeIn3.setCycleCount(1);
        fadeIn3.setAutoReverse(false);
	    
        creditChristopherText.setVisible(true);
	    
        fadeIn3.playFromStart();
 
        // Andreas Gaul
        fadeIn4.setNode(creditAndreasText);

        fadeIn4.setFromValue(0.0);
        fadeIn4.setToValue(0.5);
        fadeIn4.setCycleCount(1);
        fadeIn4.setAutoReverse(false);
	    
        creditAndreasText.setVisible(true);
	    
        fadeIn4.playFromStart();
 
        // Luke Puente
        fadeIn5.setNode(creditLukeText);

        fadeIn5.setFromValue(0.0);
        fadeIn5.setToValue(0.5);
        fadeIn5.setCycleCount(1);
        fadeIn5.setAutoReverse(false);
	    
        creditLukeText.setVisible(true);
	    
        fadeIn5.playFromStart();
	}
}
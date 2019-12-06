package view;

import java.util.concurrent.ThreadLocalRandom;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.VillainGenerator;
import model.Writer;

public class GUI extends Application implements Runnable{
	@SuppressWarnings("deprecation")
	public void start(Stage myStage)throws Exception {
        myStage.setTitle("Main Menu");
        GridPane layout = new GridPane();
        layout.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(layout, 600, 600, Color.BLUE);
        layout.add(new Label("Vilain Generator"), 1, 0 );
        
        

        
        
        //------------- Buttons------------------------------------------------------
        Button buttonA = new Button("New Villain");
        layout.add(buttonA, 1, 2);
        GridPane.setHalignment(buttonA, HPos.LEFT);

        Button buttonD = new Button ("Exit");
        layout.add(buttonD, 1, 5);
        GridPane.setHalignment(buttonD, HPos.LEFT); 
        
        buttonA.setMinWidth(100);
        buttonD.setMinWidth(100);
        
        //------------Action calls------------------------------------------------------------
        buttonA.setOnAction(e -> {
            try {
            	
        		Thread t1 = new Thread(new VillainGenerator());
        		t1.start();
            }catch(Exception f) {
				Alert alert1 = new Alert(AlertType.WARNING);
				alert1.setTitle("Error");
				alert1.setHeaderText("Something went wrong!");
				alert1.setContentText("Happy little tree!");
				alert1.showAndWait();
        	}
		});
        
        buttonD.setOnAction(e -> { 
        	Writer.cleanDirectory();
        	System.out.println("Directory cleaned");
        	myStage.close();
        	System.exit(0);
        });
          
        //-----------Launch of stage--------------------------------------------------------
      //  myStage.addAll(selectedImage);
        myStage.setScene(myScene);	
        myStage.show();
	}
	
	public void run() {
        Application.launch();
       
    }


}

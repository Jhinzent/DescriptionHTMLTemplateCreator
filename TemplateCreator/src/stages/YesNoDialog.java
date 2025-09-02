package stages;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class YesNoDialog extends Stage {
	
	private DialogClass otherStage;
    
    public YesNoDialog(DialogClass otherStage) { 
    	this.otherStage = otherStage;
    	
        VBox vbox = new VBox();
        
        Text messageText = new Text("Are you sure you want to proceed?");
        vbox.getChildren().add(messageText);
        
        javafx.scene.control.Button yesButton = new javafx.scene.control.Button("Yes");
        yesButton.setOnAction(e -> {
        	yesAction();
            close();
        });
        
        javafx.scene.control.Button noButton = new javafx.scene.control.Button("No");
        noButton.setOnAction(e -> {
        	noAction();
            close();
        });
        
        vbox.getChildren().addAll(yesButton, noButton);
        
        Scene scene = new Scene(vbox, 300, 200);
        setScene(scene);
    }
    
    public void yesAction() {
    	otherStage.initTable();
    }
    
    public void noAction() {
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}
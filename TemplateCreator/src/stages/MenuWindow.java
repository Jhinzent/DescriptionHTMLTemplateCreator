package stages;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuWindow extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button goToPartOneButton = new Button("Go to Singles template creator");
        Button goToPartTwoButton = new Button("Go to Deck template creator");
        Button goToPartThreeButton = new Button("Go to Deck Core template creator");
        Button goToPartFourButton = new Button("Go to Invoice editor");

        goToPartOneButton.setOnAction(event -> {
            new SinglesWindow().show();
            primaryStage.close();
        });

        goToPartTwoButton.setOnAction(event -> {
        	new DeckWindow().show();
            primaryStage.close();
        });
        
        goToPartThreeButton.setOnAction(event -> {
        	new DeckCoreWindow().show();
            primaryStage.close();
        });
        
        goToPartFourButton.setOnAction(event -> {
        	new InvoiceWindow().show();
            primaryStage.close();
        });

        VBox vbox = new VBox(goToPartOneButton, goToPartTwoButton, goToPartThreeButton);
        Scene scene = new Scene(vbox, 500, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Menu");
        primaryStage.show();
    }
}
package stages;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import templateCreators.SinglesTemplateCreator;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.ChoiceBox;
import java.util.ArrayList;
import helpers.Card;

public class SinglesWindow extends Stage {

    ChoiceBox<String> languageBox = new ChoiceBox<>();
    ChoiceBox<String> conditionBox = new ChoiceBox<>();
    ChoiceBox<String> editionBox = new ChoiceBox<>();
    ChoiceBox<String> rarityBox = new ChoiceBox<>();
    ChoiceBox<String> playsetBox = new ChoiceBox<>();
    ChoiceBox<String> singedBox = new ChoiceBox<>();

    TextField nameTextField = new TextField();
    TextField expansionTextField = new TextField();
    
    Button addRelatedButton = new Button("+");
    Button saveButton = new Button("Save");
    
    private TextField[] textFields = new TextField[10];
    private ChoiceBox[] choiceBoxRarity = new ChoiceBox[10];
    
    private int textFieldCount = 0;

    public SinglesWindow() {
        Label nameLabel = new Label("Name:");
        Label langueLabel = new Label("Language:");
        Label conditionLabel = new Label("Condition:");
        Label expansionLabel = new Label("Expansion:");
        Label editionLabel = new Label("Edition:");
        Label rarityLabel = new Label("Rarity:");
        Label playsetLabel = new Label("Playset?");
        Label signedLabel = new Label("Signed?");
        Label relatedLabel = new Label("Related");

        languageBox.getItems().addAll("English", "German", "Korean", "Japanese");
        conditionBox.getItems().addAll("Near Mint", "Excellent", "Good", "Light Played", "Played", "Poor");
        editionBox.getItems().addAll("1st Edition", "Unlimited", "Limited Edition");
        rarityBox.getItems().addAll("Secret Rare", "Ultra Rare", "Super Rare", "Rare", "Common", "Ultimate Rare", "Collectors Rare", "Gold Rare");
        playsetBox.getItems().addAll("3x", "1x");
        singedBox.getItems().addAll("Yes", "No");

        languageBox.setValue("English");
        conditionBox.setValue("Excellent");
        editionBox.setValue("1st Edition");
        rarityBox.setValue("Ultra Rare");
        playsetBox.setValue("1x");
        singedBox.setValue("No");

        addRelatedButton.getStyleClass().add("save-button");
        saveButton.getStyleClass().add("save-button");

        GridPane inputGrid = new GridPane();
        inputGrid.setHgap(10);
        inputGrid.setVgap(10);
        inputGrid.addRow(0, nameLabel, nameTextField);
        inputGrid.addRow(1, langueLabel, languageBox);
        inputGrid.addRow(2, conditionLabel, conditionBox);
        inputGrid.addRow(3, expansionLabel, expansionTextField);
        inputGrid.addRow(4, editionLabel, editionBox);
        inputGrid.addRow(5, rarityLabel, rarityBox);
        inputGrid.addRow(6, playsetLabel, playsetBox);
        inputGrid.addRow(7, signedLabel, singedBox);
        inputGrid.addRow(8, relatedLabel, addRelatedButton);

        VBox vBox = new VBox(10, inputGrid, saveButton);
        vBox.getStyleClass().add("singles-vbox");
        
        addRelatedButton.setOnAction(event -> {
        	GridPane relatedGrid = new GridPane();
        	ColumnConstraints col1 = new ColumnConstraints(120);
        	ColumnConstraints col2 = new ColumnConstraints(120);
        	ColumnConstraints col3 = new ColumnConstraints(80);
        	relatedGrid.getColumnConstraints().addAll(col1, col2, col3);
        	
            // Create a new TextField
            TextField textFieldName = new TextField();
            
            ChoiceBox<String> relatedRarityBox = new ChoiceBox<>();
            relatedRarityBox.getItems().addAll("Secret Rare", "Ultra Rare", "Super Rare", "Rare", "Common", "Ultimate Rare", "Collectors Rare", "Gold Rare");
            relatedRarityBox.setValue("");
            
            Label textFieldLabel = new Label("Related No. " + textFieldCount);

            // Add the TextField to the global array
            choiceBoxRarity[textFieldCount] = relatedRarityBox;
            textFields[textFieldCount++] = textFieldName;

            
            relatedGrid.add(textFieldLabel, 0, textFieldCount);
            relatedGrid.add(textFieldName, 1, textFieldCount);
            relatedGrid.add(relatedRarityBox, 2, textFieldCount);

            // Create a VBox to hold the TextFields
            ObservableList<Node> children = vBox.getChildren();
            children.add(1, relatedGrid);
        });

        saveButton.setOnAction(e -> {
            String nameText = nameTextField.getText();
            String languageText = languageBox.getValue();
            String conditionText = conditionBox.getValue();
            String expansionText = expansionTextField.getText();
            String editionText = editionBox.getValue();
            String rarityText = rarityBox.getValue();
            String playsetText = playsetBox.getValue();
            String signedText = singedBox.getValue();
            ArrayList<Card> relatedCardsText = new ArrayList<Card>();
            
            for(int i = 0; i < textFieldCount; i++) {
            	TextField tempField = textFields[i];
            	ChoiceBox<String> tempBoxRarity = choiceBoxRarity[i];
            	
            	Card tempCard = new Card(tempField.getText(), tempBoxRarity.getValue(), 1);
            	
            	relatedCardsText.add(tempCard);
            }

            new SinglesTemplateCreator(playsetText, nameText, languageText, conditionText, expansionText, editionText, rarityText, signedText, relatedCardsText );
        });

        Scene scene = new Scene(vBox, 400, 500);
        scene.getStylesheets().add("style.css");
        
     // Set labels for input fields
        nameLabel.setLabelFor(nameTextField);
        langueLabel.setLabelFor(languageBox);
        conditionLabel.setLabelFor(conditionBox);
        expansionLabel.setLabelFor(expansionTextField);
        editionLabel.setLabelFor(editionBox);
        rarityLabel.setLabelFor(rarityBox);
        playsetLabel.setLabelFor(playsetBox);
        signedLabel.setLabelFor(singedBox);
        relatedLabel.setLabelFor(addRelatedButton);

        // Arrange input fields as a table with labels in left column and input in right column
        GridPane.setConstraints(nameLabel, 0, 0);
        GridPane.setConstraints(nameTextField, 1, 0);
        GridPane.setConstraints(langueLabel, 0, 1);
        GridPane.setConstraints(languageBox, 1, 1);
        GridPane.setConstraints(conditionLabel, 0, 2);
        GridPane.setConstraints(conditionBox, 1, 2);
        GridPane.setConstraints(expansionLabel, 0, 3);
        GridPane.setConstraints(expansionTextField, 1, 3);
        GridPane.setConstraints(editionLabel, 0, 4);
        GridPane.setConstraints(editionBox, 1, 4);
        GridPane.setConstraints(rarityLabel, 0, 5);
        GridPane.setConstraints(rarityBox, 1, 5);
        GridPane.setConstraints(playsetLabel, 0, 6);
        GridPane.setConstraints(playsetBox, 1, 6);
        GridPane.setConstraints(signedLabel, 0, 7);
        GridPane.setConstraints(singedBox, 1, 7);
        GridPane.setConstraints(signedLabel, 0, 7);
        GridPane.setConstraints(singedBox, 1, 7);
        GridPane.setConstraints(relatedLabel, 0, 8);
        GridPane.setConstraints(addRelatedButton, 1, 8);

        setTitle("Singles Form");
        setScene(scene);
    }
}
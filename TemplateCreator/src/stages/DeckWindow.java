package stages;

import java.util.ArrayList;

import helpers.Card;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import templateCreators.DeckTemplateCreator;

public class DeckWindow extends Stage {

    private int numMonsters;
    private int numSpellsTraps;
    private int numExtraDeck;
    private ArrayList<Card> monsterData;
    private ArrayList<Card> spellTrapData;
    private ArrayList<Card> extraDeckData;

    private BorderPane mainBorderPane;
    private VBox gridBox;
    
    private int relatedFieldCount;
    private ChoiceBox<String>[] choiceBoxRarity = new ChoiceBox[10];
    private TextField[] textFields = new TextField[10];

    public DeckWindow() {
    	
    	relatedFieldCount = 2;
    	
    	this.monsterData = new ArrayList<>();
    	this.spellTrapData = new ArrayList<>();
    	this.extraDeckData = new ArrayList<>();

        // Create labels and text fields for user input
        Label monstersLabel = new Label("Number of Monsters:");
        TextField monstersTextField = new TextField();
        Label spellsTrapsLabel = new Label("Number of Spells/Traps:");
        TextField spellsTrapsTextField = new TextField();
        Label extraDeckLabel = new Label("Number of Extra Deck cards:");
        TextField extraDeckTextField = new TextField();

        // Create button to submit user input and create table
        Button submitButton = new Button("Submit");
        Button saveButton = new Button("Save");

        submitButton.setOnAction(event -> {
            if(monstersTextField.getText().equals("")) {
                numMonsters = 0;
            }
            else {
                numMonsters = Integer.parseInt(monstersTextField.getText());
            }
            if(spellsTrapsTextField.getText().equals("")) {
                numSpellsTraps = 0;
            }
            else {
                numSpellsTraps = Integer.parseInt(spellsTrapsTextField.getText());
            }
            if(extraDeckTextField.getText().equals("")) {
                numExtraDeck = 0;
            }
            else {
                numExtraDeck = Integer.parseInt(extraDeckTextField.getText());
            }

            createTable();
            mainBorderPane.setCenter(gridBox);
        });
        
        saveButton.setOnAction(event -> {
        	saveData();
        });


        GridPane inputNumGrid = new GridPane();
        inputNumGrid.setHgap(10);
        inputNumGrid.setVgap(10);

        inputNumGrid.add(monstersLabel, 0, 0);
        inputNumGrid.add(spellsTrapsLabel, 1, 0);
        inputNumGrid.add(extraDeckLabel, 2, 0);
        inputNumGrid.add(monstersTextField, 0, 1);
        inputNumGrid.add(spellsTrapsTextField, 1, 1);
        inputNumGrid.add(extraDeckTextField, 2, 1);
        inputNumGrid.add(submitButton, 3, 0);
        

        // Create VBox to hold labels, text fields, and button
        VBox inputBox = new VBox(10, inputNumGrid);
        inputBox.setPadding(new Insets(10));
        inputBox.setAlignment(Pos.CENTER);

        // Create BorderPane to hold input VBox and table VBox
        mainBorderPane = new BorderPane();
        mainBorderPane.setTop(inputBox);
        mainBorderPane.setBottom(saveButton);
        

        // Create Scene and set it as the primary stage
        Scene scene = new Scene(mainBorderPane, 900, 400);
        this.setScene(scene);
        this.show();
    }

    private void saveData() {
        // save monster data

        for (int i = 2; i < numMonsters+2; i++) {
            Node nodeName = gridBox.lookup("#monsterNameField" + i);
            Node nodeType = gridBox.lookup("#monsterTypeField" + i);
            Node nodeCount = gridBox.lookup("#monsterCountField" + i);

            String monsterName = "";
            String monsterRarity = "";
            String monsterCount = "3";

            if (nodeName instanceof TextField) {
                monsterName = ((TextField) nodeName).getText();
            }
            if (nodeType instanceof ChoiceBox) {
                monsterRarity = (String) ((ChoiceBox) nodeType).getValue();
            }
            if (nodeCount instanceof TextField) {
                monsterCount = ((TextField) nodeCount).getText();
            }

            Card tempCard = new Card(monsterName, monsterRarity, Integer.parseInt(monsterCount));
            monsterData.add(tempCard);
        }

        // Extract spell/trap data
        for (int i = 2; i < numSpellsTraps+2; i++) {
            Node nodeName = gridBox.lookup("#spellTrapNameField" + i);
            Node spellTrapTypeNode = gridBox.lookup("#spellTrapTypeField" + i);
            Node nodeCount = gridBox.lookup("#spellTrapCountField" + i);

            String spellTrapName = "";
            String spellTrapRarity = "";
            String spellTrapCount = "3";

            if (nodeName instanceof TextField) {
                spellTrapName = ((TextField) nodeName).getText();
            }
            if (spellTrapTypeNode instanceof ChoiceBox) {
                spellTrapRarity = (String) ((ChoiceBox) spellTrapTypeNode).getValue();
            }
            if (nodeCount instanceof TextField) {
                spellTrapCount = ((TextField) nodeCount).getText();
            }

            Card tempCard = new Card(spellTrapName, spellTrapRarity, Integer.parseInt(spellTrapCount));
            spellTrapData.add(tempCard);
        }

        // Extract extra deck data
        for (int i = 2; i < numExtraDeck+2; i++) {
            Node nodeName = gridBox.lookup("#extraDeckNameField" + i);
            Node extraDeckTypeNode = gridBox.lookup("#extraDeckTypeField" + i);
            Node nodeCount = gridBox.lookup("#extraDeckCountField" + i);

            String extraDeckName = "";
            String extraDeckType = "";
            String extraDeckCount = "1";

            if (nodeName instanceof TextField) {
                extraDeckName = ((TextField) nodeName).getText();
            }
            if (extraDeckTypeNode instanceof ChoiceBox) {
                extraDeckType = (String) ((ChoiceBox) extraDeckTypeNode).getValue();
            }
            if (nodeCount instanceof TextField) {
                extraDeckCount = ((TextField) nodeCount).getText();
            }
            
            Card tempCard = new Card(extraDeckName, extraDeckType, Integer.parseInt(extraDeckCount));
            extraDeckData.add(tempCard);
        }
        
        ArrayList<Card> relatedCards = new ArrayList<>();
        for(int i = 2; i < relatedFieldCount; i++) {
        	TextField tempField = textFields[i];
        	ChoiceBox<String> tempBoxRarity = choiceBoxRarity[i];
        	
        	relatedCards.add(new Card(tempField.getText(), tempBoxRarity.getValue(), 1));
        }
        
        DeckTemplateCreator creator = new DeckTemplateCreator(monsterData, spellTrapData, extraDeckData, relatedCards);
        creator.createAndSave();
        
        this.monsterData = new ArrayList<>();
    	this.spellTrapData = new ArrayList<>();
    	this.extraDeckData = new ArrayList<>();
        
	}

	private void createTable() {
        // create the grid and its columns
        GridPane dataGridPlane = new GridPane();
        dataGridPlane.setHgap(10);
        dataGridPlane.setVgap(10);

        ColumnConstraints col1 = new ColumnConstraints(30);
        ColumnConstraints col2 = new ColumnConstraints(120);
        ColumnConstraints col3 = new ColumnConstraints(30);
        ColumnConstraints col4 = new ColumnConstraints(30);
        ColumnConstraints col5 = new ColumnConstraints(120);
        ColumnConstraints col6 = new ColumnConstraints(30);
        ColumnConstraints col7 = new ColumnConstraints(30);
        ColumnConstraints col8 = new ColumnConstraints(120);
        ColumnConstraints col9 = new ColumnConstraints(30);
        dataGridPlane.getColumnConstraints().addAll(col1, col2, col3, col4, col5, col6, col7, col8, col9);

     // add rows for monsters
        Label monsterLabel = new Label("Monsters:");
        Label monsterLabelName = new Label("Name:");
        Label monsterLabelType = new Label("Rarity:");
        Label monsterLabelCount = new Label("# of Cards:");
        dataGridPlane.add(monsterLabel, 0, 0);
        dataGridPlane.add(monsterLabelCount, 0, 1);
        dataGridPlane.add(monsterLabelName, 1, 1);
        dataGridPlane.add(monsterLabelType, 2, 1);

        for (int i = 2; i < numMonsters+2; i++) {
            TextField monsterCountField = new TextField();
            monsterCountField.setId("monsterCountField" + i);
            TextField monsterNameField = new TextField();
            monsterNameField.setId("monsterNameField" + i);
            
            ChoiceBox<String> monsterTypeField = new ChoiceBox<String>();
            monsterTypeField.setId("monsterTypeField" + i);
            monsterTypeField.getItems().addAll("Secret Rare", "Ultra Rare", "Super Rare", "Rare", "Common", "Ultimate Rare", "Collectors Rare", "Gold Rare");
            monsterTypeField.setValue("Ultra Rare");
            
            dataGridPlane.add(monsterCountField, 0, i);
            dataGridPlane.add(monsterNameField, 1, i);
            dataGridPlane.add(monsterTypeField, 2, i);
           
            monsterCountField.setText("3");
        }

        // add rows for spells/traps
        Label spellTrapLabel = new Label("Spells/Traps:");
        Label spellTrapLabelName = new Label("Name:");
        Label spellTrapLabelType = new Label("Rarity:");
        Label spellTrapLabelCount = new Label("# of Cards:");
        dataGridPlane.add(spellTrapLabel, 3, 0);
        dataGridPlane.add(spellTrapLabelCount, 3, 1);
        dataGridPlane.add(spellTrapLabelName, 4, 1);
        dataGridPlane.add(spellTrapLabelType, 5, 1);

        for (int i = 2; i < numSpellsTraps+2; i++) {
            TextField spellTrapCountField = new TextField();
            spellTrapCountField.setId("spellTrapCountField" + i);
            TextField spellTrapNameField = new TextField();
            spellTrapNameField.setId("spellTrapNameField" + i);
            
            ChoiceBox<String> spellTrapTypeField = new ChoiceBox<String>();
            spellTrapTypeField.setId("spellTrapTypeField" + i);
            spellTrapTypeField.getItems().addAll("Secret Rare", "Ultra Rare", "Super Rare", "Rare", "Common", "Ultimate Rare", "Collectors Rare", "Gold Rare");
            spellTrapTypeField.setValue("Ultra Rare");
            
            dataGridPlane.add(spellTrapCountField, 3, i);
            dataGridPlane.add(spellTrapNameField, 4, i);
            dataGridPlane.add(spellTrapTypeField, 5, i);
            spellTrapCountField.setText("3");
        }

        // add rows for extra deck
        Label extraDeckLabel = new Label("Extra Deck");
        Label extraLabelName = new Label("Name:");
        Label extraLabelType = new Label("Rarity:");
        Label extraLabelCount = new Label("# of Cards:");
        dataGridPlane.add(extraDeckLabel, 6, 0);
        dataGridPlane.add(extraLabelCount, 6, 1);
        dataGridPlane.add(extraLabelName, 7, 1);
        dataGridPlane.add(extraLabelType, 8, 1);

        // add rows for extra deck
        for (int i = 2; i < numExtraDeck+2; i++) {
            TextField extraDeckCountField = new TextField();
            extraDeckCountField.setId("extraDeckCountField" + i);
            TextField extraDeckNameField = new TextField();
            extraDeckNameField.setId("extraDeckNameField" + i);
            
            ChoiceBox<String> extraDeckTypeField = new ChoiceBox<String>();
            extraDeckTypeField.setId("extraDeckTypeField" + i);
            extraDeckTypeField.getItems().addAll("Secret Rare", "Ultra Rare", "Super Rare", "Rare", "Common", "Ultimate Rare", "Collectors Rare", "Gold Rare");
            extraDeckTypeField.setValue("Ultra Rare");
            
            dataGridPlane.add(extraDeckCountField, 6, i);
            dataGridPlane.add(extraDeckNameField, 7, i);
            dataGridPlane.add(extraDeckTypeField, 8, i);
            extraDeckCountField.setText("3");
        }
        
        Label relatedLabel = new Label("Related");
        Button addRelatedButton = new Button("+");
        
        addRelatedButton.getStyleClass().add("save-button");
        
        dataGridPlane.add(relatedLabel, 9, 0);
        dataGridPlane.add(addRelatedButton, 9, 1);
        
        addRelatedButton.setOnAction(event -> {
        	
        	ChoiceBox<String> relatedRarityBox = new ChoiceBox<>();
            relatedRarityBox.getItems().addAll("Secret Rare", "Ultra Rare", "Super Rare", "Rare", "Common", "Ultimate Rare", "Collectors Rare", "Gold Rare");
            relatedRarityBox.setValue("");
            
            // Add the TextField to the global array
            choiceBoxRarity[relatedFieldCount] = relatedRarityBox;
        	
            // Create a new TextField
            TextField textField = new TextField();
            
            textFields[relatedFieldCount++] = textField;
            
            dataGridPlane.add(textField, 9, relatedFieldCount);
            dataGridPlane.add(relatedRarityBox, 10, relatedFieldCount);
        });

        // create the VBox and add the grid to it
        gridBox = new VBox();
        gridBox.setAlignment(Pos.CENTER);
        gridBox.getChildren().add(dataGridPlane);
    }
}
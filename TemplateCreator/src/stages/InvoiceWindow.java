package stages;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class InvoiceWindow extends Stage implements DialogClass {

    private BorderPane mainBorderPane;
    private List<String> pdfContents = new ArrayList<>();

    public InvoiceWindow() {

        // Create button to submit user input and create table
        Button chooseDirectoryButton = new Button("Submit");
        Button saveButton = new Button("Save");

        chooseDirectoryButton.setOnAction(event -> {
            // Open a file chooser dialog to select a directory
            DirectoryChooser directoryChooser = new DirectoryChooser();
            File selectedDirectory = directoryChooser.showDialog(this);

            // Check if a directory is selected
            if (selectedDirectory != null) {
                // Search for .pdf files in the selected directory
                List<String> pdfContents = new ArrayList<>();
                searchAndReadPDFs(selectedDirectory, pdfContents);

                // You now have the content of all the PDFs in the pdfContents list
                // You can perform further operations with the content as needed
            }
        });

        saveButton.setOnAction(event -> {
            // Do something with the pdfContents array, e.g., print the contents
            pdfContents.forEach(System.out::println);
        });

        GridPane inputNumGrid = new GridPane();
        inputNumGrid.setHgap(10);
        inputNumGrid.setVgap(10);

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


    private void searchAndReadPDFs(File directory, List<String> pdfContents) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // Recursively search subdirectories
                    searchAndReadPDFs(file, pdfContents);
                } else if (file.getName().toLowerCase().endsWith(".pdf")) {
                    // Read the content of the PDF file and add it to the pdfContents list
                    try {
                        byte[] fileBytes = Files.readAllBytes(file.toPath());
                        String pdfContent = new String(fileBytes);
                        pdfContents.add(pdfContent);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
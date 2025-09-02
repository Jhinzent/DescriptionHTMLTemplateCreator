module TemplateCreator {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.base;
	requires javafx.graphics;
    
    exports stages;

    opens stages to javafx.fxml;
}
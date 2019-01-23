package ru.univeralex.algoritms_and_data_structures.coursework.gui;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.Iterator;
import java.util.Optional;

public class GUI extends Application {
    public static void main(String args[]) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Открыть организацию");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JSON", "*.json"));

        File file = fileChooser.showOpenDialog(stage);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(file);
        String filename = "Файл не выбран!";
        if (Optional.ofNullable(file).isPresent()) {
            filename = file.getName();
        }
        TreeItem<String> rootNode = new TreeItem<>(jsonNode.get("name").asText());
        Iterator<JsonNode> branchIterator = jsonNode.elements();
        while (branchIterator.hasNext()) {
            rootNode.getChildren().add(new TreeItem<>(branchIterator.next().get("name").asText()));
        }
        TreeView<String> treeView = new TreeView<>(rootNode);

        //Setting the title to Stage.
        stage.setTitle("Курсовая Костарев: " + filename);

        VBox box = new VBox();
        final Scene scene = new Scene(box, 400, 300);
        box.getChildren().add(treeView);
        stage.setScene(scene);
        //Displaying the stage
        stage.show();

    }
}

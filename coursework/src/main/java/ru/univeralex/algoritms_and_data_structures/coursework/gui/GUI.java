package ru.univeralex.algoritms_and_data_structures.coursework.gui;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import ru.univeralex.algoritms_and_data_structures.coursework.model.Branch;
import ru.univeralex.algoritms_and_data_structures.coursework.model.Organization;

import java.io.File;
import java.util.Optional;

public class GUI extends Application {
    private TreeView<String> treeView;
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
        Organization organization = objectMapper.readValue(file, Organization.class);
        String filename = "Файл не выбран!";
        if (Optional.ofNullable(file).isPresent()) {
            filename = file.getName();
        }
        TreeItem<String> rootNode = populateTree(organization);
        treeView = new TreeView<>(rootNode);
        EventHandler<MouseEvent> mouseEventHandle = this::handleMouseClicked;
        treeView.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEventHandle);
        stage.setTitle("Курсовая Костарев: " + filename);

        VBox box = new VBox();
        final Scene scene = new Scene(box, 400, 300);
        box.getChildren().add(treeView);
        stage.setScene(scene);
        //Displaying the stage
        stage.show();

    }

    private void handleMouseClicked(MouseEvent event) {
        Node node = event.getPickResult().getIntersectedNode();
        // Accept clicks only on node cells, and not on empty spaces of the TreeView
        if (node instanceof Text || (node instanceof TreeCell && ((TreeCell) node).getText() != null)) {
            String name = (String) ((TreeItem) treeView.getSelectionModel().getSelectedItem()).getValue();
            System.out.println("Node click: " + name);
        }
    }

    private TreeItem<String> populateTree(Organization organization) {
        TreeItem<String> rootNode = new TreeItem<>(organization.getName());
        Object[] branches = organization.getBranches().toArray();
        for (Object branch : branches) {
            TreeItem<String> item = new TreeItem<>(((Branch) branch).getName());
            rootNode.getChildren().add(item);
        }
        return rootNode;
    }

}

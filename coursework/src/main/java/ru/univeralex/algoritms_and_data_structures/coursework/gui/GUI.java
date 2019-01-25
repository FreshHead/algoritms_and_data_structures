package ru.univeralex.algoritms_and_data_structures.coursework.gui;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import ru.univeralex.algoritms_and_data_structures.coursework.model.Branch;
import ru.univeralex.algoritms_and_data_structures.coursework.model.Department;
import ru.univeralex.algoritms_and_data_structures.coursework.model.Organization;
import ru.univeralex.algoritms_and_data_structures.labs.lab1stacks.StaticStack;
import ru.univeralex.algoritms_and_data_structures.labs.lab1stacks.exceptions.StackIsFullException;

import java.io.File;
import java.util.List;
import java.util.Optional;

public class GUI extends Application {
    private TreeView<String> branchTreeView;
    private TableView<Department> departmentView = new TableView<>();
    private Branch selectedBranch;
    private Organization organization;
    private TextField depNameTextField;
    private TextField depEmployeesNumberTextField;
    public static void main(String args[]) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Выберите организацию");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JSON", "*.json"));

        File file = fileChooser.showOpenDialog(stage);
        ObjectMapper objectMapper = new ObjectMapper();

        TableColumn nameCol = new TableColumn("Название");
        nameCol.setMinWidth(100);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn employeesNumberCol = new TableColumn("Количество сотрудников");
        employeesNumberCol.setMinWidth(100);
        employeesNumberCol.setCellValueFactory(new PropertyValueFactory<>("employeesNumber"));

        departmentView.getColumns().addAll(nameCol, employeesNumberCol);

        organization = objectMapper.readValue(file, Organization.class);
        String filename = "Файл не выбран!";
        if (Optional.ofNullable(file).isPresent()) {
            filename = file.getName();
        }
        TreeItem<String> rootNode = populateTree(organization);
        branchTreeView = new TreeView<>(rootNode);
        EventHandler<MouseEvent> mouseEventHandle = this::handleMouseClicked;
        branchTreeView.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEventHandle);
        stage.setTitle("Курсовая Костарев: " + filename);
        depNameTextField = new TextField();
        depEmployeesNumberTextField = new TextField();
        Button addButton = new Button("Добавить отделение");
        addButton.setOnAction((ActionEvent e) -> {
            StaticStack<Department> departments = selectedBranch.getDepartments();
            int employeesNumber = Integer.parseInt(depEmployeesNumberTextField.getText());
            Department addedDepartment = new Department(depNameTextField.getText(), employeesNumber);
            try {
                departments.push(addedDepartment);
            } catch (StackIsFullException e1) {
                e1.printStackTrace();
            }
            populateDepartmentView();
        });
        Button deleteButton = new Button("Удалить отделение");
        deleteButton.setOnAction((ActionEvent e) -> {
            StaticStack<Department> departments = selectedBranch.getDepartments();
            departments.pop();
            populateDepartmentView();
        });

//      placement
        HBox textFieldBox = new HBox(depNameTextField, depEmployeesNumberTextField);
        HBox buttonBox = new HBox(addButton, deleteButton);
        VBox departmentBox = new VBox(textFieldBox, buttonBox, departmentView);
        HBox mainBox = new HBox(branchTreeView, departmentBox);

        final Scene scene = new Scene(mainBox, 400, 300);
        stage.setScene(scene);
        //Displaying the stage
        stage.show();
    }

    private void handleMouseClicked(MouseEvent event) {
        Node node = event.getPickResult().getIntersectedNode();
        // Accept clicks only on node cells, and not on empty spaces of the TreeView
        if (node instanceof Text || (node instanceof TreeCell && ((TreeCell) node).getText() != null)) {
            String name = (String) ((TreeItem) branchTreeView.getSelectionModel().getSelectedItem()).getValue();
            selectedBranch = organization.getBranches().findFirstByToString(name);
            populateDepartmentView();
        }
    }

    private void populateDepartmentView() {
        StaticStack<Department> departments = selectedBranch.getDepartments();
        if (departments != null) {
            List<Department> elements = departments.getElementsList();
            ObservableList<Department> observableList = FXCollections.observableArrayList();
            observableList.addAll(elements);
            departmentView.setItems(observableList);
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

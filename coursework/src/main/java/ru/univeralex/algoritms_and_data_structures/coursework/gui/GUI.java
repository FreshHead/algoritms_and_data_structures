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
import ru.univeralex.algoritms_and_data_structures.labs.lab2lists.DynamicList;
import ru.univeralex.algoritms_and_data_structures.labs.lab2lists.exceptions.NoSuchItemException;

import java.io.File;
import java.util.List;
import java.util.Optional;

public class GUI extends Application {
    private TreeView<String> branchTreeView;
    private TableView<Department> departmentView = new TableView<>();
    private Branch selectedBranch;
    private Organization organization;
    private TextField depNameTextField = new TextField();
    private TextField depEmployeesNumberTextField = new TextField();
    private TextField branchTextField = new TextField();

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
        TreeItem<String> rootNode = populateRootNode(organization);
        branchTreeView = new TreeView<>(rootNode);
        EventHandler<MouseEvent> mouseEventHandle = this::handleMouseClicked;
        branchTreeView.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEventHandle);
        stage.setTitle("Курсовая Костарев: " + filename);
        Button addDepButton = new Button("Добавить отделение");

        addDepButton.setOnAction((ActionEvent e) -> {
            if (selectedBranch != null) {
                StaticStack<Department> departments = selectedBranch.getDepartments();
                int employeesNumber = Integer.parseInt(depEmployeesNumberTextField.getText());
                Department addedDepartment = new Department(depNameTextField.getText(), employeesNumber);
                try {
                    departments.push(addedDepartment);
                } catch (StackIsFullException e1) {
                    e1.printStackTrace();
                }
                populateDepartmentView();
            }
        });

        Button deleteDepButton = new Button("Удалить отделение");
        deleteDepButton.setOnAction((ActionEvent e) -> {
            if (selectedBranch != null) {
                StaticStack<Department> departments = selectedBranch.getDepartments();
                departments.pop();
                populateDepartmentView();
            }
        });

        Button addBranchButton = new Button("Добавить филиал");
        addBranchButton.setOnAction((ActionEvent e) -> {
            DynamicList<Branch> branches = organization.getBranches();
            Branch addedBranch = new Branch(branchTextField.getText(), new StaticStack<>(20));
            if (selectedBranch != null) {
                try {
                    branches.insertAfter(branches.findFirst(selectedBranch), addedBranch);
                } catch (NoSuchItemException e1) {
                    e1.printStackTrace();
                }
            } else {
                branches.insertBefore(0, addedBranch);
            }
            branchTreeView.setRoot(populateRootNode(organization));
        });

        Button deleteBranchButton = new Button("Удалить филиал");
        deleteBranchButton.setOnAction((ActionEvent e) -> {
            DynamicList<Branch> branches = organization.getBranches();
            try {
                int selectedBranchIndex = branches.findFirst(selectedBranch);
                branches.delete(selectedBranchIndex);
                selectedBranch = null;
            } catch (NoSuchItemException e1) {
                e1.printStackTrace();
            }
            branchTreeView.setRoot(populateRootNode(organization));
        });

//      placement
        HBox branchButtonBox = new HBox(addBranchButton, deleteBranchButton);

        HBox depTextFieldBox = new HBox(depNameTextField, depEmployeesNumberTextField);
        HBox depButtonBox = new HBox(addDepButton, deleteDepButton);
        VBox branchBox = new VBox(branchTextField, branchButtonBox, branchTreeView);
        VBox departmentBox = new VBox(depTextFieldBox, depButtonBox, departmentView);
        HBox mainBox = new HBox(branchBox, departmentBox);

        final Scene scene = new Scene(mainBox);
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
            if (selectedBranch != null) {
                populateDepartmentView();
            }
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

    private TreeItem<String> populateRootNode(Organization organization) {
        TreeItem<String> rootNode = new TreeItem<>(organization.getName());
        Object[] branches = organization.getBranches().toArray();
        for (Object branch : branches) {
            TreeItem<String> item = new TreeItem<>(((Branch) branch).getName());
            rootNode.getChildren().add(item);
        }
        rootNode.setExpanded(true);
        return rootNode;
    }

}

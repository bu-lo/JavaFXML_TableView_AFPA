package fr.afpa.controllers;

import java.io.IOException;

import fr.afpa.models.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class UserManagementController {

    @FXML
    private Button saveButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Button deleteButton;

    @FXML
    private TextField textFieldFName;

    @FXML
    private TextField textFieldLName;

    @FXML
    private TextField textFieldCity;

    @FXML
    private TableView<Person> tableView3C;

    @FXML
    private TableColumn<Person, String> tableCFName;

    @FXML
    private TableColumn<Person, String> tableCLName;

    @FXML
    private TableColumn<Person, String> tableCCity;

    @FXML
    private ObservableList<Person> persons = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        persons.add(new Person("Josh", "Holy", "NYC"));
        persons.add(new Person("Dave", "Grow", "London"));
        persons.add(new Person("Robert", "Bon", "Paris"));

        tableView3C.setItems(persons); // LINK

        tableCFName.setCellValueFactory(cellData -> cellData.getValue().getFirstName());
        tableCLName.setCellValueFactory(cellData -> cellData.getValue().getLastName());
        tableCCity.setCellValueFactory(cellData -> cellData.getValue().getCity());
    }

    /**
     * Save new valors First Name + Last Name + City in the model
     * Creation of a new person and adding to "ObservableList"
     * 
     * @param e click on "Save" button
     */
    @FXML
    private void save(ActionEvent e) {

        String fName = textFieldFName.getText();
        String lName = textFieldLName.getText();
        String cityName = textFieldCity.getText();

        if (!fName.isEmpty() && !lName.isEmpty() && !cityName.isEmpty()) { // ARE NOT EMPTY
            persons.add(new Person(fName, lName, cityName));
            textFieldFName.clear();
            textFieldLName.clear();
            textFieldCity.clear();
        }
    }

    /**
     * Cancels the entries
     * 
     * @param e click on "Cancel" button
     */
    @FXML
    private void cancel(ActionEvent e) {
        textFieldFName.clear();
        textFieldLName.clear();
        textFieldCity.clear();
    }

    /**
     * Delete the line on the form
     * 
     * @param e click on "Delete" button
     */
    @FXML
    private void delete(ActionEvent e) {
        textFieldFName.clear();
        textFieldLName.clear();
        textFieldCity.clear();

        Person selectedPerson = tableView3C.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            persons.remove(selectedPerson);
        }
    }
}

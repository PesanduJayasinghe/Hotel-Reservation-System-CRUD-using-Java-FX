package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.DTO.CustomerInfoDTO;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerController implements Initializable {

    ObservableList<CustomerInfoDTO> customerInfoArray= FXCollections.observableArrayList(
            new CustomerInfoDTO("C001", "Alice Johnson", "555-1234", "New York", 28),
            new CustomerInfoDTO("C002", "Brian Smith", "555-5678", "Los Angeles", 35),
            new CustomerInfoDTO("C003", "Catherine Lee", "555-8765", "Chicago", 42),
            new CustomerInfoDTO("C004", "David Kim", "555-3456", "Houston", 31),
            new CustomerInfoDTO("C005", "Emma Brown", "555-7890", "Miami", 25)
    );

    @FXML
    private TableColumn<?, ?> ColumnAge;

    @FXML
    private TableColumn<?, ?> ColumnCity;

    @FXML
    private TableColumn<?, ?> ColumnCustId;

    @FXML
    private TableColumn<?, ?> ColumnName;

    @FXML
    private TableColumn<?, ?> ColumnPhoneNo;

    @FXML
    private TableView<CustomerInfoDTO> custTable;

    @FXML
    private TextField txtAge;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtCustId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhone;

    @FXML
    void btnAdd(ActionEvent event) {

    }

    @FXML
    void btnClear(ActionEvent event) {

    }

    @FXML
    void btnDelete(ActionEvent event) {

    }

    @FXML
    void btnUpdate(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        ColumnAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        ColumnCustId.setCellValueFactory(new PropertyValueFactory<>("id"));
        ColumnCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        ColumnPhoneNo.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));

        custTable.setItems(customerInfoArray);
    }
}

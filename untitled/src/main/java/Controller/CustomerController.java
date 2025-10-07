package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.DTO.CustomerInfoDTO;

import java.awt.event.ActionEvent;
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
    private javafx.scene.control.TableColumn<?, ?> ColumnAge;

    @FXML
    private javafx.scene.control.TableColumn<?, ?> ColumnCity;

    @FXML
    private javafx.scene.control.TableColumn<?, ?> ColumnCustId;

    @FXML
    private javafx.scene.control.TableColumn<?, ?> ColumnName;

    @FXML
    private TableColumn<?, ?> ColumnPhoneNo;

    @FXML
    private TableView<CustomerInfoDTO> custTable;

    @FXML
    private TextArea txtAge;

    @FXML
    private TextArea txtCity;

    @FXML
    private TextField txtCustId;

    @FXML
    private TextField txtName;

    @FXML
    private TextArea txtPhone;

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

    }
}

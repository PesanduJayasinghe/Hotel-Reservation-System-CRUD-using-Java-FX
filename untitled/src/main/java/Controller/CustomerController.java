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
import model.DTO.RoominfoDTO;

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
        String name=txtName.getText();
        String custID=txtCustId.getText();
        String phoneNo=txtPhone.getText();
        int age= Integer.parseInt(txtAge.getText());
        String city=txtCity.getText();

        CustomerInfoDTO customerInfoData=new CustomerInfoDTO(custID,name,phoneNo,city,age);
        customerInfoArray.add(customerInfoData);
    }

    @FXML
    void btnClear(ActionEvent event) {
        txtCustId.clear();
        txtName.clear();
        txtAge .clear();
        txtCity.clear();
        txtPhone.clear();

    }

    @FXML
    void btnDelete(ActionEvent event) {
        CustomerInfoDTO selectedItem=custTable.getSelectionModel().getSelectedItem();
        customerInfoArray.remove(selectedItem);
        custTable.refresh();
    }

    @FXML
    void btnUpdate(ActionEvent event) {
        CustomerInfoDTO selectedItem=custTable.getSelectionModel().getSelectedItem();

        selectedItem.setId(txtCustId.getText());
        selectedItem.setName(txtName.getText());
        selectedItem.setAge(Integer.parseInt(txtAge.getText()));
        selectedItem.setCity(txtCity.getText());
        selectedItem.setPhoneNo(txtPhone.getText());

        custTable.refresh();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        ColumnAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        ColumnCustId.setCellValueFactory(new PropertyValueFactory<>("id"));
        ColumnCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        ColumnPhoneNo.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));

        custTable.setItems(customerInfoArray);

        custTable.getSelectionModel().selectedItemProperty().addListener((observableValue, customerInfoDTO, t1) -> {
            if(t1!=null) {
                txtName.setText(t1.getName());
                txtAge.setText(String.valueOf(t1.getAge()));
                txtPhone.setText(t1.getPhoneNo());
                txtCity.setText(t1.getCity());
                txtCustId.setText(t1.getId());

            }
        });
    }


}

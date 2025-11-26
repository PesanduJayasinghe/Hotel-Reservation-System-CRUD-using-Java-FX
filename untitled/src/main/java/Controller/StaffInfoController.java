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
import model.DTO.StaffInfoDTO;

import java.net.URL;
import java.util.ResourceBundle;

public class StaffInfoController implements Initializable {

    ObservableList<StaffInfoDTO> staffInfoArray=FXCollections.observableArrayList(
            new StaffInfoDTO("S001", "Alice Johnson", "Receptionist", "alice.johnson@hotel.com", "555-1234", "45000"),
            new StaffInfoDTO("S002", "Brian Smith", "Manager", "brian.smith@hotel.com", "555-5678", "75000"),
            new StaffInfoDTO("S003", "Catherine Lee", "Housekeeping", "catherine.lee@hotel.com", "555-8765", "40000"),
            new StaffInfoDTO("S004", "David Kim", "Receptionist", "david.kim@hotel.com", "555-3456", "46000"),
            new StaffInfoDTO("S005", "Emma Brown", "Manager", "emma.brown@hotel.com", "555-7890", "78000")

    );

    @FXML
    private TableColumn<?, ?> ColumnEmail;

    @FXML
    private TableColumn<?, ?> ColumnName;

    @FXML
    private TableColumn<?, ?> ColumnPhoneNo;

    @FXML
    private TableColumn<?, ?> ColumnRole;

    @FXML
    private TableColumn<?, ?> ColumnSalary;

    @FXML
    private TableColumn<?, ?> ColumnStaffId;

    @FXML
    private TableView<StaffInfoDTO> staffTable;

    @FXML
    private TextField txtAge;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhone;

    @FXML
    private TextField txtRole;

    @FXML
    private TextField txtSalary;

    @FXML
    private TextField txtStaffId;

    @FXML
    void btnAdd(ActionEvent event) {
        String name=txtName.getText();
        String staffID=txtStaffId.getText();
        String phoneNo=txtPhone.getText();
        String salary= txtSalary.getText();
        String email=txtEmail.getText();
        String role=txtRole.getText();

        StaffInfoDTO staffInfoData=new StaffInfoDTO(staffID,name,role,email,phoneNo,salary);
        staffInfoArray.add(staffInfoData);
    }

    @FXML
    void btnClear(ActionEvent event) {
        txtEmail.clear();
        txtName.clear();
        txtAge .clear();
        txtRole.clear();
        txtPhone.clear();
        txtSalary.clear();
    }

    @FXML
    void btnDelete(ActionEvent event) {
        StaffInfoDTO selectedItem=staffTable.getSelectionModel().getSelectedItem();
        staffInfoArray.remove(selectedItem);
        staffTable.refresh();
    }

    @FXML
    void btnUpdate(ActionEvent event) {
        StaffInfoDTO selectedItem=staffTable.getSelectionModel().getSelectedItem();

        selectedItem.setStaffId(txtStaffId.getText());
        selectedItem.setName(txtName.getText());
        selectedItem.setSalary(txtSalary.getText());
        selectedItem.setRole(txtRole.getText());
        selectedItem.setPhoneNo(txtPhone.getText());
        selectedItem.setEmail(txtEmail.getText());

        staffTable.refresh();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        ColumnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        ColumnRole.setCellValueFactory(new PropertyValueFactory<>("role"));
        ColumnSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        ColumnStaffId.setCellValueFactory(new PropertyValueFactory<>("staffId"));
        ColumnPhoneNo.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));


        staffTable.setItems(staffInfoArray);

        staffTable.getSelectionModel().selectedItemProperty().addListener((observableValue, staffInfoDTO, t1) -> {
            if(t1!=null) {
                txtName.setText(t1.getName());
                txtStaffId.setText(t1.getStaffId());
                txtPhone.setText(t1.getPhoneNo());
                txtRole.setText(t1.getRole());
                txtEmail.setText(t1.getEmail());
                txtSalary.setText(t1.getSalary());
            }
        });
    }
}

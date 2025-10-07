package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.DTO.RoominfoDTO;

import java.net.URL;
import java.util.ResourceBundle;

public class RoomInformationController implements Initializable {

    ObservableList<RoominfoDTO> roominfoArray= FXCollections.observableArrayList(
            new RoominfoDTO("R001","Single","Single bed, Wifi",1000.00),
            new RoominfoDTO("R002","Double","Single bed, Wifi",2000.00),
            new RoominfoDTO("R003","Single","Single bed, Wifi,A/C",3000.00),
            new RoominfoDTO("R004","Family","Single bed, Wifi,Pool",5000.00)
    );

    @FXML
    private TableColumn<?, ?> ColumnDescription;

    @FXML
    private TableColumn<?, ?> ColumnPrice;

    @FXML
    private TableColumn<?, ?> ColumnType;

    @FXML
    private TableColumn<?, ?> ColumnRoomId;
    
    @FXML
    private TableView<RoominfoDTO> reloadTable;

    @FXML
    void reloadBtn(ActionEvent event) {
        ColumnRoomId.setCellValueFactory(new PropertyValueFactory<>("roomID"));
        ColumnType.setCellValueFactory(new PropertyValueFactory<>("type"));
        ColumnDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        ColumnPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        reloadTable.setItems(roominfoArray);
    }


    @FXML
    private TextArea txtDesc;

    @FXML
    private TextArea txtPrice;

    @FXML
    private TextField txtRoomId;

    @FXML
    private TextField txtType;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ColumnRoomId.setCellValueFactory(new PropertyValueFactory<>("roomID"));
        ColumnType.setCellValueFactory(new PropertyValueFactory<>("type"));
        ColumnDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        ColumnPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        reloadTable.setItems(roominfoArray);

        reloadTable.getSelectionModel().selectedItemProperty().addListener((observableValue, roominfoDTO, t1) -> {
            if(t1!=null) {
                txtRoomId.setText(t1.getRoomID());
                txtType.setText(t1.getType());
                txtDesc.setText(t1.getDescription());
                txtPrice.setText(String.valueOf(t1.getPrice()));

            }
        });
    }

    @FXML
    void btnAdd(ActionEvent event) {
        String roomID=txtRoomId.getText();
        String type=txtType.getText();
        String description=txtDesc.getText();
        double price= Double.parseDouble(txtPrice.getText());

        RoominfoDTO roomInfoData=new RoominfoDTO(roomID,type,description,price);
        roominfoArray.add(roomInfoData);
    }

    @FXML
    void btnClear(ActionEvent event) {
            txtRoomId.clear();
            txtType.clear();
            txtDesc.clear();
            txtPrice.clear();
    }

    @FXML
    void btnDelete(ActionEvent event) {
        RoominfoDTO selectedItem=reloadTable.getSelectionModel().getSelectedItem();
        roominfoArray.remove(selectedItem);
        reloadTable.refresh();
    }

    @FXML
    void btnUpdate(ActionEvent event) {
        RoominfoDTO selectedItem=reloadTable.getSelectionModel().getSelectedItem();

        selectedItem.setRoomID(txtRoomId.getText());
        selectedItem.setType(txtType.getText());
        selectedItem.setDescription(txtDesc.getText());
        selectedItem.setPrice(Double.parseDouble(txtPrice.getText()));

        reloadTable.refresh();

    }


}
package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.DTO.RoominfoDTO;

import java.io.IOException;

public class DashboardController {

    ObservableList<RoominfoDTO> roominfoArray=FXCollections.observableArrayList(
        new RoominfoDTO()

    );

    Stage stage=new Stage();

    @FXML
    void btnCustomerInfo(ActionEvent event) {

    }

    @FXML
    void btnRoomInfo(ActionEvent event) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/roomInfo.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setTitle("Book karapn");
        stage.show();
    }

}

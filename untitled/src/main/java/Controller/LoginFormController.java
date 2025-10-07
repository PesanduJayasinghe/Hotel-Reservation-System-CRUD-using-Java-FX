package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class LoginFormController {

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUsername;

    Stage stage=new Stage();
    @FXML
    void btnLogin(ActionEvent event) throws IOException {

        String name = "Admin";
        int pw = 1234;

        if (txtUsername.getText().equalsIgnoreCase(name) && Integer.parseInt(txtPassword.getText()) == pw) {

            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/dashboard.fxml"))));
            stage.show();


        }else{
            System.out.println("Wrong Username or Password");
            JOptionPane.showMessageDialog(null,"Wrong details");

            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid User");
            alert.setContentText("Please eneter a valid usernmae");
            alert.showAndWait();

            txtUsername.clear();
            txtPassword.clear();
        }
    }

}
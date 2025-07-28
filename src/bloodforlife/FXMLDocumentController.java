package bloodforlife;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;

public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label1;
    @FXML
    private MenuBar menubar;
    @FXML
    private Button searchdonorbutton;
    @FXML
    private Button registerbutton;
    @FXML
    private Button loginbutton;
    @FXML
    private Label label2;

    @FXML
    private void handleSearchButton(ActionEvent event) throws IOException {
        SceneUtil.switchScene(event, "Search.fxml", "Search Donor");
    }

    @FXML
    private void handleRegisterButton(ActionEvent event) throws IOException {
        SceneUtil.switchScene(event, "Register.fxml", "Register");
    }

    @FXML
    private void handleLoginButton(ActionEvent event) throws IOException {
        SceneUtil.switchScene(event, "Login.fxml", "Login");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Optional: Initialize any components here
    }
}

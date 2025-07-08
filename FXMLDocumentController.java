package bloodforlife;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;

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
    private void handleSearchButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Search.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Search Donor");
        stage.show();
    }

    @FXML
    private void handleRegisterButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Register.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Register");
        stage.show();
    }

    @FXML
    private void handleLoginButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Login");
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
     
    }
}

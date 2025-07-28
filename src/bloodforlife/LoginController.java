package bloodforlife;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController implements Initializable {

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    private void handleLogin(ActionEvent event) {
        Connection conn = DBConnect.connect();
        String query = "SELECT * FROM history WHERE email = ? AND password = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, emailField.getText());
            pst.setString(2, passwordField.getText());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                System.out.println("Login Successful!");
            } else {
                System.out.println("Invalid Credentials");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Optional initialization
    }

    @FXML
    private void goToRegister(ActionEvent event) {
        // Optional: navigation to Register page
    }
}

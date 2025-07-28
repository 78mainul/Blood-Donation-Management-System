package bloodforlife;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterController implements Initializable {

    @FXML
    private TextField nameField, emailField, contactField, bloodGroupField;

    @FXML
    private TextField passwordField;
    @FXML
    private Label labelreg1;
    @FXML
    private Label labelreg11;
    @FXML
    private Label labelreg;

    @FXML
    private void handleRegister(ActionEvent event) {
        Connection conn = DBConnect.connect();
        String query = "INSERT INTO history (name, email, contact, blood_group, password) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, nameField.getText());
            pst.setString(2, emailField.getText());
            pst.setString(3, contactField.getText());
            pst.setString(4, bloodGroupField.getText());
            pst.setString(5, passwordField.getText());
            pst.executeUpdate();
            System.out.println("Donor Registered!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) { }
}

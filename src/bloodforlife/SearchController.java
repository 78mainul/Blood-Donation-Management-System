package bloodforlife;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class SearchController implements Initializable {

    @FXML
    private ComboBox<String> bloodGroupCombo; // Changed from TextField to ComboBox

    @FXML
    private TableView<Donor> tableView;

    @FXML
    private TableColumn<Donor, String> nameCol, emailCol, contactCol;

    @FXML
    private TableColumn<?, ?> habitlCol;

    @FXML
    private Label searchlabel;

    @FXML
    private Label blooddonorlable;

    @FXML
    private Label detailslabel;

    @FXML
    private Button homebtn;

    ObservableList<Donor> donorList = FXCollections.observableArrayList();

    @FXML
    private void handleSearch(ActionEvent event) {
        donorList.clear();
        String selectedGroup = bloodGroupCombo.getValue(); // get selected item
        if (selectedGroup == null || selectedGroup.isEmpty()) {
            System.out.println("No blood group selected.");
            return;
        }

        Connection conn = DBConnect.connect();
        String query = "SELECT * FROM history WHERE blood_group = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, selectedGroup);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                donorList.add(new Donor(rs.getString("name"), rs.getString("email"), rs.getString("contact")));
            }
            tableView.setItems(donorList);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    private void handleHomeButton(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        contactCol.setCellValueFactory(new PropertyValueFactory<>("contact"));

        // Set blood groups in ComboBox
        bloodGroupCombo.setItems(FXCollections.observableArrayList(
            "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"
        ));
    }
}

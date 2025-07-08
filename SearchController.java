package bloodforlife;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class SearchController implements Initializable {

    @FXML
    private TextField bloodGroupField;

    @FXML
    private TableView<Donor> tableView;

    @FXML
    private TableColumn<Donor, String> nameCol, emailCol, contactCol;

    ObservableList<Donor> donorList = FXCollections.observableArrayList();

    @FXML
    private void handleSearch(ActionEvent event) {
        donorList.clear();
        Connection conn = DBConnect.connect();
        String query = "SELECT * FROM history WHERE blood_group = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, bloodGroupField.getText());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                donorList.add(new Donor(rs.getString("name"), rs.getString("email"), rs.getString("contact")));
            }
            tableView.setItems(donorList);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        contactCol.setCellValueFactory(new PropertyValueFactory<>("contact"));
    }
}

package bloodforlife;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneUtil {

    /**
     * Loads and sets a new scene in the current window (stage).
     *
     * @param event    The ActionEvent from the button click
     * @param fxmlFile The FXML file name (e.g., "Login.fxml")
     * @param title    The window title
     * @throws IOException if the FXML file cannot be loaded
     */
    public static void switchScene(ActionEvent event, String fxmlFile, String title) throws IOException {
        Parent root = FXMLLoader.load(SceneUtil.class.getResource(fxmlFile));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle(title);
        stage.show();
    }
}

package DonorDetails;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class donorDetailsController {
    @FXML
    private Pane DonorDetailsPane;

    @FXML
    private void handleUpdate() throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("updateDonorDetails.fxml"));
        DonorDetailsPane.getChildren().setAll(pane);
    }

    @FXML
    private void handleAddNew() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("addDonor.fxml"));
        DonorDetailsPane.getChildren().setAll(pane);
    }
}

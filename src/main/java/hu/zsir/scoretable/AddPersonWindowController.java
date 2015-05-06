/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.zsir.scoretable;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Feco
 */
public class AddPersonWindowController implements Initializable {

    public AddPersonWindowController() {

    }

    @FXML
    private GridPane mainPane;
    @FXML
    private TextField nameField;
    @FXML
    private Text warningText;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void cancel() {
        AddPersonStage.getAddpersonstage().close();
    }

    @FXML
    private void savePerson() {
        if (nameField.getText().isEmpty()) {
            warningText.setVisible(true);
        }
        else {
            System.out.println(nameField.getText());
            AddPersonStage.getAddpersonstage().close();
        }
    }

}
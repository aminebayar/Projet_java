package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

import connexion.connexion;
public class loginContro {

    public loginContro() {

    }
    @FXML
    private Button cancel;
    @FXML
    private Button button;

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;



    public void userLogIn(ActionEvent event) throws IOException {
        checkLogin();

    }

    private void checkLogin() throws IOException {
        Main m = new Main();
        if(username.getText().toString().equals("admin") && password.getText().toString().equals("123")) {
            m.changeScene("Dashboard.fxml");
        }

        else if(username.getText().isEmpty() && password.getText().isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Login");
    		alert.setHeaderText("Remplir les champs");

    		alert.showAndWait();
        }


        else {
        	  Alert alert = new Alert(AlertType.ERROR);
      		alert.setTitle("Login");
      		alert.setHeaderText("Wrong username or password!");

      		alert.showAndWait();
       
        }
    }
    @FXML

    protected void cancel() {       

       Platform.exit();
    }
}
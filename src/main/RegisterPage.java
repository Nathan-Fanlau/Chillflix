package main;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableSelectionModel;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import models.User;
import database.Connect;

public class RegisterPage extends Application  {
	
	@Override
    public void start(Stage primaryStage) {
        // Login Page UI
        GridPane loginPane = createLoginPane(primaryStage);

        // Register Page UI
        GridPane registerPane = createRegisterPane(primaryStage);

        // Initial Scene (Login Page)
        Scene loginScene = new Scene(loginPane, 400, 300);
        Scene registerScene = new Scene(registerPane, 400, 300);

        // Button to switch from Login to Register
        Button goToRegister = new Button("Don't have an account? Register here!");
        goToRegister.setOnAction(e -> primaryStage.setScene(registerScene));
        loginPane.add(goToRegister, 0, 4, 2, 1);

        // Button to switch from Register to Login
        Button goToLogin = new Button("Already have an account? Login here!");
        goToLogin.setOnAction(e -> primaryStage.setScene(loginScene));
        registerPane.add(goToLogin, 0, 5, 2, 1);

        primaryStage.setTitle("Login/Register App");
        primaryStage.setScene(loginScene); // Start with the Login Page
        primaryStage.show();
    }

    private GridPane createLoginPane(Stage stage) {
        GridPane loginPane = new GridPane();
        loginPane.setPadding(new Insets(10));
        loginPane.setVgap(8);
        loginPane.setHgap(10);

        // Email Label and Field
        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();
        loginPane.add(emailLabel, 0, 0);
        loginPane.add(emailField, 1, 0);

        // Password Label and Field
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        loginPane.add(passwordLabel, 0, 1);
        loginPane.add(passwordField, 1, 1);

        // Login Button
        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> {
            String email = emailField.getText();
            String password = passwordField.getText();
            // Process login logic here
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Login");
            alert.setContentText("Email: " + email + "\nPassword: " + password);
            alert.showAndWait();
        });
        loginPane.add(loginButton, 1, 2);

        return loginPane;
    }

    private GridPane createRegisterPane(Stage stage) {
        GridPane registerPane = new GridPane();
        registerPane.setPadding(new Insets(10));
        registerPane.setVgap(8);
        registerPane.setHgap(10);

        // Username Label and Field
        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();
        registerPane.add(usernameLabel, 0, 0);
        registerPane.add(usernameField, 1, 0);

        // Email Label and Field
        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();
        registerPane.add(emailLabel, 0, 1);
        registerPane.add(emailField, 1, 1);

        // Password Label and Field
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        registerPane.add(passwordLabel, 0, 2);
        registerPane.add(passwordField, 1, 2);

        // Register Button
        Button registerButton = new Button("Register");
        registerButton.setOnAction(e -> {
            String username = usernameField.getText();
            String email = emailField.getText();
            String password = passwordField.getText();
            // Process registration logic here
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Register");
            alert.setContentText("Username: " + username + "\nEmail: " + email + "\nPassword: " + password);
            alert.showAndWait();
        });
        registerPane.add(registerButton, 1, 3);

        return registerPane;
    }

    public static void main(String[] args) {
        launch(args);
    }

}

package main;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableSelectionModel;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import models.User;
import database.Connect;

public class Main extends Application {
	Scene mainScene, loginScene, registerScene;
	VBox root, formVbox; 
	GridPane formGp; 
	Label nameLabel, emailLabel, passLabel; 
	TextField nameField, emailField;
	PasswordField passField; 
	Button submitButton, updateButton, deleteButton, loginButton, registerButton;
	TableView<User> userTable; 
	TableColumn<User, String> idCol, nameCol, emailCol; 
	HBox buttonHbox; 
	
	private Connect connect = Connect.getInstance(); 
	ArrayList<User> userList = new ArrayList<>(); 
	Random rand = new Random(); 
	
	String tempId; 
	
	public void init() {
		root = new VBox(); 
		mainScene = new Scene(root, 1000, 600); 
		formGp = new GridPane(); 
		nameLabel = new Label("Username"); 
		emailLabel = new Label("Email"); 
		passLabel = new Label("Password"); 
		nameField = new TextField(); 
		emailField = new TextField();
		passField = new PasswordField(); 
		submitButton = new Button("Submit"); 
		formVbox = new VBox(); 
		userTable = new TableView<>(); 
		updateButton = new Button("Update"); 
		deleteButton = new Button("Delete"); 
		buttonHbox = new HBox(); 
		
        loginButton = new Button("Go to Login");
        registerButton = new Button("Go to Register");
	}
	
	public void layout() {
		formGp.add(nameLabel, 0, 0);
		formGp.add(nameField, 1, 0);
		formGp.add(emailLabel, 0, 1);
		formGp.add(emailField, 1, 1);
		formGp.add(passLabel, 0, 2);
		formGp.add(passField, 1, 2);
		buttonHbox.getChildren().addAll(submitButton, updateButton, deleteButton); 
		formVbox.getChildren().addAll(formGp, buttonHbox); 
		root.getChildren().addAll(loginButton, registerButton, formVbox, userTable); 
	}
	
	public void style() {
		root.setStyle("-fx-background-color : lightblue");
		userTable.setStyle("-fx-background-color : lavender");
		formGp.setAlignment(Pos.CENTER);
		formVbox.setAlignment(Pos.CENTER);
		formGp.setHgap(20);
		formGp.setVgap(10);
		formVbox.setSpacing(20);
		formVbox.setPadding(new Insets(20));
		buttonHbox.setAlignment(Pos.CENTER);
		buttonHbox.setSpacing(20);
	}
	
	private GridPane createLoginPane(Stage stage) {
        GridPane loginPane = new GridPane();
        loginPane.setPadding(new Insets(10));
        loginPane.setVgap(8);
        loginPane.setHgap(10);
        loginPane.setAlignment(Pos.CENTER);

        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();
        loginPane.add(emailLabel, 0, 0);
        loginPane.add(emailField, 1, 0);

        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        loginPane.add(passwordLabel, 0, 1);
        loginPane.add(passwordField, 1, 1);

        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> {
            String email = emailField.getText();
            String password = passwordField.getText();

            try {
                String query = "SELECT * FROM users WHERE Email = ? AND Password = ?";
                PreparedStatement ps = connect.preparedStatement(query);
                ps.setString(1, email);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Login Successful!", ButtonType.OK);
                    alert.showAndWait();
                    stage.setScene(mainScene); // Navigate to main scene after login
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid email or password!", ButtonType.OK);
                    alert.showAndWait();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        loginPane.add(loginButton, 1, 2);

        Button goToRegister = new Button("Don't have an account? Register here!");
        goToRegister.setOnAction(e -> stage.setScene(registerScene));
        loginPane.add(goToRegister, 1, 3);

        return loginPane;
    }
	
	private GridPane createRegisterPane(Stage stage) {
        GridPane registerPane = new GridPane();
        registerPane.setPadding(new Insets(10));
        registerPane.setVgap(8);
        registerPane.setHgap(10);
        registerPane.setAlignment(Pos.CENTER);

        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();
        registerPane.add(usernameLabel, 0, 0);
        registerPane.add(usernameField, 1, 0);

        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();
        registerPane.add(emailLabel, 0, 1);
        registerPane.add(emailField, 1, 1);

        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        registerPane.add(passwordLabel, 0, 2);
        registerPane.add(passwordField, 1, 2);

        Button registerButton = new Button("Register");
        registerButton.setOnAction(e -> {
            String username = usernameField.getText();
            String email = emailField.getText();
            String password = passwordField.getText();

            try {
                String query = "INSERT INTO users (Username, Email, Password) VALUES (?, ?, ?)";
                PreparedStatement ps = connect.preparedStatement(query);
                ps.setString(1, username);
                ps.setString(2, email);
                ps.setString(3, password);

                ps.executeUpdate();
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Registration Successful!", ButtonType.OK);
                alert.showAndWait();
                stage.setScene(loginScene); // Navigate to login scene after registration
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        registerPane.add(registerButton, 1, 3);

        Button goToLogin = new Button("Already have an account? Login here!");
        goToLogin.setOnAction(e -> stage.setScene(loginScene));
        registerPane.add(goToLogin, 1, 4);

        return registerPane;
    }
	
	public void setTable() {
		idCol = new TableColumn<>("User ID");
		idCol.setCellValueFactory(new PropertyValueFactory<User, String>("id"));
		nameCol = new TableColumn<>("Username"); 
		nameCol.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
		emailCol = new TableColumn<>("User Email"); 
		emailCol.setCellValueFactory(new PropertyValueFactory<User, String>("email")); 
		
		idCol.setMinWidth(root.getWidth() / 3);
		nameCol.setMinWidth(root.getWidth() / 3);
		emailCol.setMinWidth(root.getWidth() / 3);
		
		userTable.getColumns().addAll(idCol, nameCol, emailCol);
		
		refreshTable(); 
	}
	
	public void setEventHandler() {
//		insert data 
		submitButton.setOnAction(e -> {
			int num1 = rand.nextInt(10); 
			int num2 = rand.nextInt(10); 
			int num3 = rand.nextInt(10); 
			String id = "US" + num1 + num2 + num3; 
			String username = nameField.getText(); 
			String email = emailField.getText(); 
			String pass = passField.getText(); 
			String role = "customer"; 
			
			String query = String.format("INSERT INTO users VALUES ('%s', '%s', '%s', '%s', '%s')",
					id, username, email, pass, role); 
			connect.execUpdate(query);
			refreshTable(); 
		});
		
//		select data 
		userTable.setOnMouseClicked(e -> {
			TableSelectionModel<User> tsm = userTable.getSelectionModel(); 
			tsm.setSelectionMode(SelectionMode.SINGLE);
			User user = tsm.getSelectedItem(); 
			tempId = user.getId(); 
			
			nameField.setText(user.getName());
			emailField.setText(user.getEmail());
			passField.setText(user.getPass());
		});
		
//		update data 
		updateButton.setOnAction(e -> {
			String username = nameField.getText(); 
			String email = emailField.getText(); 
			String pass = passField.getText(); 
			
//			Pake Statement biasa 
//			String query = String.format("UPDATE MsUser\r\n" + 
//					"SET UserName = '%s', UserEmail = '%s', UserPassword = '%s'\r\n" + 
//					"WHERE UserID = '%s'", username, email, pass, tempId); 
//			connect.execUpdate(query);
			
//			Pake Prepared Statement 
			String query = "UPDATE users\r\n" + 
					"SET Username = ?, Email = ?, Password = ?\r\n" + 
					"WHERE ID = ?"; 
			
			PreparedStatement ps = connect.preparedStatement(query); 
			
			try {
				ps.setString(1, username);
				ps.setString(2, email);
				ps.setString(3, pass);
				ps.setString(4, tempId);
				
				ps.execute();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			refreshTable(); 
			nameField.clear();
			emailField.clear();
			passField.clear();
		});
		
//		delete data 
		deleteButton.setOnAction(e -> {
			String query = String.format("DELETE FROM users\r\n" + 
					"WHERE ID = '%s'", tempId); 
			connect.execUpdate(query); 
			
			refreshTable(); 
			nameField.clear();
			emailField.clear();
			passField.clear();
		});
		
	}
	
	public void getData() {
		String query = "SELECT * FROM users"; 
		connect.execQuery(query); 
		
		try {
			while(connect.rs.next()) {
				String id = connect.rs.getString("ID"); 
				String username = connect.rs.getString("Username"); 
				String email = connect.rs.getString("Email"); 
				String pass = connect.rs.getString("Password");
				String role = connect.rs.getString("Role");
				
				userList.add(new User(id, username, email, pass, role)); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void refreshTable() {
		userList.clear();
		getData(); 
		ObservableList<User> userObsList = FXCollections.observableArrayList(userList);
		userTable.setItems(userObsList);
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		init(); 
		layout(); 
		style(); 
		setTable(); 
		setEventHandler(); 
		
		// Create Login and Register Scenes
        GridPane loginPane = createLoginPane(stage);
        loginScene = new Scene(loginPane, 1000, 600);

        GridPane registerPane = createRegisterPane(stage);
        registerScene = new Scene(registerPane, 1000, 600);

        // Login/Register Navigation from Main Scene
        loginButton.setOnAction(e -> stage.setScene(loginScene));
        registerButton.setOnAction(e -> stage.setScene(registerScene));
		
		stage.setScene(mainScene);
		stage.show();
	}

}

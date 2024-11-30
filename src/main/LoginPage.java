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

public class LoginPage extends Application  {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	Stage stage; // Windowsnya
	Scene loginScene, homeScene; // Halamannya
	BorderPane loginBp, homeBp; // Layout halamannya
	Label loginLabel, idLabel, nameLabel, priceLabel;
	Button loginButton, submitButton;
	VBox loginVBox, formVBox; // VBox (Vertical box: Komponen ke bawah), HBox (Horizontal box: Komponen ke kanan)
	MenuBar menuBar; // Menu bar utamanya
	Menu menu, profileMenu; // Nama tabnya
	MenuItem menuItem; // Pilihan di dropdown menu
	MenuItem[] profileItem; // Pilihan di dropdown profile
	TableView<Food> foodTable; 
	TableColumn<Food, String> idCol;
	TableColumn<Food, String> nameCol;
	TableColumn<Food, Integer> priceCol;
//	ScrollPane scrollPane;
	GridPane formGp;
	TextField idField, nameField, priceField;
	
	public void init() {
		loginBp = new BorderPane();
		loginScene = new Scene(loginBp, 750, 500);
		loginLabel = new Label("Welcome");
		loginButton = new Button("Log In");
		loginVBox = new VBox();
		loginVBox.getChildren().addAll(loginLabel, loginButton);
		
		homeBp = new BorderPane();
		homeScene = new Scene(homeBp, 750, 500);
		menuBar = new MenuBar(); 
		menu = new Menu("Menu"); 
		menuItem = new MenuItem("Exit"); 
		profileMenu = new Menu("Profile");
		profileItem = new MenuItem[] {
				new MenuItem("View Profile"),
				new MenuItem("Edit Profile")
		};
		menu.getItems().addAll(menuItem);
		profileMenu.getItems().addAll(profileItem);
		menuBar.getMenus().addAll(menu, profileMenu);
		
		foodTable = new TableView<>();
//		scrollPane = new ScrollPane();
//		scrollPane.setContent(foodTable);
		
		formVBox = new VBox();
		formGp = new GridPane();
		idLabel = new Label("Food ID");
		nameLabel = new Label("Food Name");
		priceLabel = new Label("Food Price");
		idField = new TextField();
		nameField = new TextField();
		priceField = new TextField();
		submitButton = new Button("Submit");
		formGp.add(idLabel, 0, 0);
		formGp.add(idField, 1, 0);
		formGp.add(nameLabel, 0, 1);
		formGp.add(nameField, 1, 1);
		formGp.add(priceLabel, 0, 2);
		formGp.add(priceField, 1, 2);
	}
	
	public void layout() {
		loginBp.setCenter(loginVBox);
		loginVBox.setAlignment(Pos.CENTER);
		loginVBox.setSpacing(12);
		
		homeBp.setTop(menuBar);
		homeBp.setCenter(foodTable);

		formVBox.getChildren().addAll(formGp, submitButton);
		formVBox.setPadding(new Insets(12));
		formVBox.setSpacing(12);
		formGp.setAlignment(Pos.CENTER);
		formVBox.setAlignment(Pos.CENTER);
		
		homeBp.setBottom(formVBox);

	}
	
	public void style() {
		loginLabel.setFont(new Font("Helvetica", 30));
		loginLabel.setStyle("-fx-font-weight: bolder;" +
							"-fx-text-fill: #2F2F2F");
		loginButton.setFont(new Font("Helvetica", 15));
	}
	
	public void setEventHandler() {
		loginButton.setOnAction(e -> {
			System.out.println("Login");
			stage.setTitle("Home Page");
			stage.setScene(homeScene);
		});
		
		menuItem.setOnAction(e -> {
			System.out.println("Exit");
			stage.setScene(loginScene);
		});
		profileItem[0].setOnAction(e -> {
			System.out.println("View Profile");
		});
		profileItem[1].setOnAction(e -> {
			System.out.println("Edit Profile");
		});
		
		submitButton.setOnAction(e -> {
			if(idField.getText().isEmpty() || nameField.getText().isEmpty() || priceField.getText().isEmpty()) {
				Alert errorAlert = new Alert(AlertType.WARNING);
				errorAlert.setContentText("All fields must be filled.");
				errorAlert.show();
			}
			
			else {
				foodTable.getItems().add(new Food(idField.getText(), 
						nameField.getText(), 
						Integer.parseInt(priceField.getText())));
				
				idField.clear();
				nameField.clear();
				priceField.clear();
			}
		});
	}
	
	public void setTable() {
		idCol = new TableColumn<>("Food ID");
		nameCol = new TableColumn<>("Food Name");
		priceCol = new TableColumn<>("Food Price");
		
		idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
		nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
		priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
		
		idCol.setMinWidth(homeBp.getWidth() / 4);
		nameCol.setMinWidth((homeBp.getWidth() / 4) * 2);
		priceCol.setMinWidth(homeBp.getWidth() / 4);
		
		foodTable.getColumns().addAll(idCol, nameCol, priceCol);
	}

	@Override
	public void start(Stage stage) throws Exception {
		this.stage = stage;
		
		init();
		layout();
		style();
		setEventHandler();
		setTable();
		stage.setTitle("Login Page");
		stage.setScene(loginScene);
		stage.show();
	}


}

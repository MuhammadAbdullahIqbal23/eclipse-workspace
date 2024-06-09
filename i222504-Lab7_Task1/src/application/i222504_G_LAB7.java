package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class i222504_G_LAB7 extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label nameLabel = new Label("Full Name:");
        TextField name = new TextField();
        name.setPromptText("Enter your name");
        name.setMaxWidth(200);

        Label dobLabel = new Label("Date of Birth:");
        DatePicker dob = new DatePicker();

        Label genderLabel = new Label("Gender:");
        ToggleGroup genderGroup = new ToggleGroup();
        
        RadioButton ButtonForMale = new RadioButton("Male");
        ButtonForMale.setToggleGroup(genderGroup);
        
        RadioButton ButtonForFemale = new RadioButton("Female");
        ButtonForFemale.setToggleGroup(genderGroup);
        
        RadioButton ButtonForOther = new RadioButton("Other");
        ButtonForOther.setToggleGroup(genderGroup);

       


        Label emailLabel = new Label("Email:");
        TextField email = new TextField();
        email.setPromptText("Enter your Email");
        email.setMaxWidth(200);

        Label contactLabel = new Label("Contact Number:");
        TextField contactNumber = new TextField();
        contactNumber.setPromptText("Enter your Contact number");
        contactNumber.setMaxWidth(200);

        Label addressLabel = new Label("Address:");
        TextArea address = new TextArea();
        address.setPromptText("Enter your address");
        address.setPrefHeight(350); 

        Label coursesLabel = new Label("Courses:");
        ListView<String> courses = new ListView<>();
        courses.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        courses.getItems().add("English");
        courses.getItems().add("Maths");
        courses.getItems().add("Physics");
        courses.getItems().add("Chemistry");

        Button submitButton = new Button("Submit form");

        HBox nameBox = new HBox(10);  
        nameBox.getChildren().add(nameLabel);
        nameBox.getChildren().add(name);

        HBox dobBox = new HBox(10); 
        dobBox.getChildren().add(dobLabel);
        dobBox.getChildren().add(dob);

        VBox genderBox = new VBox(5);
        genderBox.getChildren().add(genderLabel);
        genderBox.getChildren().add(ButtonForMale);
        genderBox.getChildren().add(ButtonForFemale);
        genderBox.getChildren().add(ButtonForOther);
        HBox emailBox = new HBox(10); 
        emailBox.getChildren().add(emailLabel);
        emailBox.getChildren().add(email);

        HBox contactBox = new HBox(10); 
        contactBox.getChildren().add(contactLabel);
        contactBox.getChildren().add(contactNumber);

        VBox formBox = new VBox(10);
        formBox.getChildren().add(nameBox);
        formBox.getChildren().add(dobBox);
        formBox.getChildren().add(genderBox);
        formBox.getChildren().add(emailBox);
        formBox.getChildren().add(contactBox);
        formBox.getChildren().add(addressLabel);
        formBox.getChildren().add(address);
        formBox.getChildren().add(coursesLabel);
        formBox.getChildren().add(courses);

        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        MenuItem clearForm = new MenuItem("Clear Form");
        MenuItem exitMenuItem = new MenuItem("Exit");
        fileMenu.getItems().add(clearForm);
        fileMenu.getItems().add(exitMenuItem);

        menuBar.getMenus().add(fileMenu);

        VBox root = new VBox(10);
        root.getChildren().add(menuBar);
        root.getChildren().add(formBox);
        root.getChildren().add(submitButton);


        clearForm.setOnAction(e -> {
            name.clear();
            dob.setValue(null);
            genderGroup.selectToggle(null); 
            email.clear();
            contactNumber.clear();
            address.clear();
            courses.getSelectionModel().clearSelection();
        });

        exitMenuItem.setOnAction(e -> primaryStage.close());


        
        submitButton.setOnAction(e -> {
        	  boolean isValid = true;

        	  // Validate Full Name
        	  if (name.getText().isEmpty()) {
        	    isValid = false;
        	    Alert alert = new Alert(Alert.AlertType.ERROR);
        	    alert.setTitle("Validation Error");
        	    alert.setHeaderText("Full Name cannot be empty");
        	    alert.setContentText("Please enter your full name.");
        	    alert.showAndWait();
        	  }

        	  // Validate Date Picker
        	  if (dob.getValue() == null) {
        	    isValid = false;
        	    Alert alert = new Alert(Alert.AlertType.ERROR);
        	    alert.setTitle("Validation Error");
        	    alert.setHeaderText("Date not selected");
        	    alert.setContentText("Please select a date from the calendar.");
        	    alert.showAndWait();
        	  }

        	  // Validate Email
        	  if (email.getText().isEmpty()) {
        	    isValid = false;
        	    Alert alert = new Alert(Alert.AlertType.ERROR);
        	    alert.setTitle("Validation Error");
        	    alert.setHeaderText("Email cannot be empty");
        	    alert.setContentText("Please enter your email address.");
        	    alert.showAndWait();
        	  }

        	  // Validate Contact Number
        	  if (contactNumber.getText().isEmpty()) {
        	    isValid = false;
        	    Alert alert = new Alert(Alert.AlertType.ERROR);
        	    alert.setTitle("Validation Error");
        	    alert.setHeaderText("Contact Number cannot be empty");
        	    alert.setContentText("Please enter your contact number.");
        	    alert.showAndWait();
        	  }

        	  // Validate Address
        	  if (address.getText().isEmpty()) {
        	    isValid = false;
        	    Alert alert = new Alert(Alert.AlertType.ERROR);
        	    alert.setTitle("Validation Error");
        	    alert.setHeaderText("Address cannot be empty");
        	    alert.setContentText("Please enter your address.");
        	    alert.showAndWait();
        	  }

        	  // Validate Course Selection
        	  if (courses.getSelectionModel().getSelectedIndices().isEmpty()) {
        	    isValid = false;
        	    Alert alert = new Alert(Alert.AlertType.ERROR);
        	    alert.setTitle("Validation Error");
        	    alert.setHeaderText("No course selected");
        	    alert.setContentText("Please select at least one course.");
        	    alert.showAndWait();
        	  }

        	  if (isValid) {
        		  Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
          	    alert.setTitle("Submission Confirmation");
          	    alert.setHeaderText("Form Submitted.");
          	    alert.showAndWait();
        	    System.out.println("Form Submitted.");
        	  }
        	});


        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Student Registration Form");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

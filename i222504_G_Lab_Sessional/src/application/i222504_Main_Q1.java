package application;
	
import javafx.application.Application;
import javafx.fxml.*;
import javafx.stage.*;
import javafx.scene.*;



public class i222504_Main_Q1 extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			 Parent root = FXMLLoader.load(getClass().getResource("I222504_G_Lab_Sessional_File_Q1.fxml"));
			 Scene scene = new Scene(root);
			 
			primaryStage.setTitle("Library Management System");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

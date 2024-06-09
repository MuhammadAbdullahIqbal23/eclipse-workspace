package application;
	
import javafx.application.Application;
import javafx.fxml.*;
import javafx.stage.*;
import javafx.scene.*;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			 Parent root = FXMLLoader.load(getClass().getResource("addBookScreen.fxml"));
			 Scene scene = new Scene(root);
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

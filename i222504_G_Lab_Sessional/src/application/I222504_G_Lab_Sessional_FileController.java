package application;


import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;

public class I222504_G_Lab_Sessional_FileController implements Initializable {

    @FXML
    private TableView<i222504_Book_Q1> table;
    @FXML
    private TableColumn<i222504_Book_Q1, Integer> ISBNColumn;
    @FXML
    private TableColumn<i222504_Book_Q1, Integer> id;
    @FXML
    private TableColumn<i222504_Book_Q1, String> authorColumn;
    @FXML
    private TableColumn<i222504_Book_Q1, Boolean> availabilityColumn;
    @FXML
    private TableColumn<i222504_Book_Q1, String> titleColumn;
    @FXML
    private TextField authorField;
    @FXML
    private TextField availabilityField;
    @FXML
    private TextField editAuthor;
    @FXML
    private TextField editAvailability;
    @FXML
    private TextField editBook;
    @FXML
    private TextField editISBN;
    @FXML
    private TextField isbnField;
    @FXML
    private Label statusLabel;
    @FXML
    private TextField titleField;
    @FXML
    private TextField titlesearchfeild;
    @FXML
    private TextField authorsearchfeild;

    ObservableList<i222504_Book_Q1> list = FXCollections.observableArrayList(
            new i222504_Book_Q1(1, "Harry potter", "Abdullah", 978006112, true),
            new i222504_Book_Q1(2, "Tableg", "Qasim", 978006432, true),
            new i222504_Book_Q1(3, "Huawei and its strugle", "Arham", 978243615, false),
            new i222504_Book_Q1(4, "India's history", "Ali", 978897697, false),
            new i222504_Book_Q1(5, "Pakistan's history", "Usman", 978532429, true)
    );

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        ISBNColumn.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
        availabilityColumn.setCellValueFactory(new PropertyValueFactory<>("availability"));

        table.setItems(list);
    }

    @FXML
    void handleAddBook(ActionEvent event) throws IOException {

//        Stage newStage = new Stage();
//
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("addBookScreen.fxml"));
//        Parent root = loader.load();
//
//        Scene newScene = new Scene(root);
//
//        newStage.setScene(newScene);
//        newStage.setTitle("Add Book");
//        newStage.show();
        
        String title = titleField.getText();
        String author = authorField.getText();
        String isbnText = isbnField.getText();
        String availabilityText = availabilityField.getText();

        if (title.isEmpty() || author.isEmpty()) {
            statusLabel.setText("Title and Author fields cannot be empty.");
            return;
        }

        int isbn;
        try {
            isbn = Integer.parseInt(isbnText);
        } catch (NumberFormatException e) {
            statusLabel.setText("ISBN must be a valid integer.");
            return;
        }

        boolean availability;
        if (!availabilityText.equalsIgnoreCase("true") && !availabilityText.equalsIgnoreCase("false")) {
            statusLabel.setText("Availability must be 'true' or 'false'.");
            return;
        } else {
            availability = Boolean.parseBoolean(availabilityText);
        }

        i222504_Book_Q1 newBook = new i222504_Book_Q1(list.size() + 1, title, author, isbn, availability);
        list.add(newBook);
    	
    }

    @FXML
    void handleDeleteBook(ActionEvent event) {
        i222504_Book_Q1 selectedBook = table.getSelectionModel().getSelectedItem();
        if (selectedBook != null) {
            selectedBook.setTitle(null);
            selectedBook.setAuthor(null);
            selectedBook.setISBN(0);
            selectedBook.setAvailability(false);
            list.remove(selectedBook);
            table.refresh();
        } else {
            System.out.println("No book selected for deletion.");
        }
    }

    @FXML
    void handleEditBook(ActionEvent event) {

        String newTitle = editBook.getText();
        String newAuthor = editAuthor.getText();
        String isbnText = editISBN.getText();
        String availabilityText = editAvailability.getText();

        i222504_Book_Q1 selectedBook = table.getSelectionModel().getSelectedItem();

        if (selectedBook == null) {
            System.out.println("No book selected for editing.");
            statusLabel.setText("No book selected for editing.");

            
            return;
        }
       
        if (newTitle.isEmpty()) {
            System.out.println("Title cannot be empty.");
            statusLabel.setText("Title cannot be empty.");

            return;
        }

        if (newAuthor.isEmpty()) {
            System.out.println("Author cannot be empty.");
            statusLabel.setText("Author cannot be empty.");

            return;
        }

        int newISBN = 0;
        try {

            newISBN = Integer.parseInt(isbnText);
        } catch (NumberFormatException e) {
            System.out.println("ISBN must be a valid integer.");
            return;
        }

        boolean newAvailability;
        if (availabilityText.equalsIgnoreCase("true")) {
            newAvailability = true;
        } else if (availabilityText.equalsIgnoreCase("false")) {

            newAvailability = false;
        } else {

            System.out.println("Availability must be 'true' or 'false'.");
            return;
        }
        selectedBook.setTitle(newTitle);
        selectedBook.setAuthor(newAuthor);
        selectedBook.setISBN(newISBN);
        selectedBook.setAvailability(newAvailability);

        table.refresh();
    }


    @FXML
    void handleSearchByTitle(ActionEvent event) {
        String searchKeyword = titlesearchfeild.getText().toLowerCase();
        ObservableList<i222504_Book_Q1> searchResult = FXCollections.observableArrayList();

        if (!searchKeyword.isEmpty()) {
            for (i222504_Book_Q1 book : list) {
                if (book.getTitle().toLowerCase().contains(searchKeyword)) {
                    searchResult.add(book);
                }
            }
        } else {
            searchResult.addAll(list);
        }

        table.setItems(searchResult);
    }

    @FXML
    void handleSearchByAuthor(ActionEvent event) {
        String searchKeyword = authorsearchfeild.getText().toLowerCase();
        ObservableList<i222504_Book_Q1> searchResult = FXCollections.observableArrayList();

        if (!searchKeyword.isEmpty()) {
            for (i222504_Book_Q1 book : list) {
                if (book.getAuthor().toLowerCase().contains(searchKeyword)) {
                    searchResult.add(book);
                }
            }
        } else {
            searchResult.addAll(list);
        }

        table.setItems(searchResult);
    }

    @FXML
    void handleExit(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void handleNew(ActionEvent event) {
        table.getItems().clear();
        list.clear();
    }

    @FXML
    void handleOpen(ActionEvent event) {
    }

    @FXML
    void handleSave(ActionEvent event) {
    }

    @FXML
    void handleSaveAs(ActionEvent event) {
    }

    @FXML
    void handleSubmitButtonAddBook(ActionEvent event) throws IOException {
        handleAddBook(event);
    }

    @FXML
    void handleSubmitButtonEditBook(ActionEvent event) {
        handleEditBook(event);
    }

    @FXML
    void handleSortByTitle() {
        list.sort((b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()));
    }

    @FXML
    void handleSortByAuthor() {
        list.sort((b1, b2) -> b1.getAuthor().compareToIgnoreCase(b2.getAuthor()));
    }

    @FXML
    void handleSortByISBN() {
        list.sort((b1, b2) -> Integer.compare(b1.getISBN(), b2.getISBN()));
    }
}


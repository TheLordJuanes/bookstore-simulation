package ui;

import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
public class BookStoreGUI {

	private Stage primaryStage;

	public BookStoreGUI(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	@FXML
    private TextField numberOfShelves;

    @FXML
    private TextField numberOfCashiers;

    @FXML
    private TextField isbn;

    @FXML
    private TextField numberOfCopies;

    @FXML
    private TextField bookShelf;

    @FXML
    private TextField bookPrice;

	@FXML
    private TextField clientIdEnter;

    @FXML
    private TextField clientIdList;

    @FXML
    private TextField isbnList;

    @FXML
    public void addBook(ActionEvent event) {

    }

    @FXML
    public void goBack1(ActionEvent event) {

    }

    @FXML
    public void goForward(ActionEvent event) {

    }

    @FXML
    public void addClient(ActionEvent event) {

    }

    @FXML
    public void appendBook(ActionEvent event) {

    }

    @FXML
    public void giveResult(ActionEvent event) {

    }

    @FXML
    public void goBack2(ActionEvent event) {

    }

	@FXML
    public void startSimulation(ActionEvent event) {

    }
}
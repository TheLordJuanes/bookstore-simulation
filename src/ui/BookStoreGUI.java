/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-------
 * @Authors: Juan Pablo Ramos, Juan Esteban Caicedo and Jose Alejandro García
 * @Date: March, 21th 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-------
*/
package ui;

import javafx.stage.Stage;
import model.Bookstore;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import java.io.IOException;
import javafx.event.ActionEvent;

public class BookStoreGUI {

    // -----------------------------------------------------------------
	// Attributes
    // -----------------------------------------------------------------

    @FXML
    private TextField txtNumberOfShelves;

    @FXML
    private TextField txtNumberOfCashiers;

    @FXML
    private TextField txtISBN;

    @FXML
    private TextField txtNumberOfCopies;

    @FXML
    private TextField txtBookShelf;

    @FXML
    private TextField txtBookPrice;

	@FXML
    private TextField txtClientIdEnter;

    @FXML
    private TextField cbClientIdList;

    @FXML
    private TextField txtISBNList;

    private Stage primaryStage;

    private Bookstore bookstore;

    // -----------------------------------------------------------------
	// Methods
    // -----------------------------------------------------------------

    /**
     * Name: BookStoreGUI
     * GUI constructor method. <br>
     * @param primaryStage - GUI primary stage - primaryStage = Stage
    */
    public BookStoreGUI(Stage primaryStage) {
		this.primaryStage = primaryStage;
        bookstore = new Bookstore();
	}

	public void showErrorAlert(String title, String header, String content) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.showAndWait();
	}

	public void showWarningAlert(String title, String header, String content) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.showAndWait();
	}

	public void showInformationAlert(String title, String header, String content) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.showAndWait();
	}

    /**
     * Name: startSimulation
     * Method used to start the bookstore simulation. <br>
     * @param event - event representing starting the bookstore simulation - event = ActionEvent
    */
    @FXML
    public void startSimulation(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("initial-parameters1.fxml"));
        fxmlLoader.setController(this);
        try {
            Parent initialParameters = fxmlLoader.load();
            primaryStage.setTitle("Initial parameters");
            primaryStage.setScene(new Scene(initialParameters));
            primaryStage.show();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Name: goBack1
     * Method used to go back before the beginning of the simulation. <br>
     * @param event - event representing going back before the beginning of the simulation - event = ActionEvent
    */
    @FXML
    public void goBack1(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Are you sure?");
		alert.setHeaderText(null);
		alert.setContentText("If you go back, the book catalog will be lost.");
        if (alert.showAndWait().filter(t -> t == ButtonType.OK).isPresent()) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("start-simulation.fxml"));
            fxmlLoader.setController(this);
            try {
                Parent startSimulation = fxmlLoader.load();
                primaryStage.setTitle("Initial parameters");
                primaryStage.setScene(new Scene(startSimulation));
                primaryStage.show();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    /**
     * Name: addBook
     * Method used to add a book in the system. <br>
     * @param event - event representing adding a book in the system - event = ActionEvent
    */
    @FXML
    public void addBook(ActionEvent event) {
        String bIsbn = txtISBN.getText();
        String numberOfCopies = txtNumberOfCopies.getText();
        char bookShelf = txtBookShelf.getText().charAt(0);
        double bookPrice = Double.parseDouble(txtBookPrice.getText());
        bookstore.addBook(bIsbn,numberOfCopies,bookShelf,bookPrice);
        txtISBN.setText("");
        txtBookShelf.setText("");
        txtBookPrice.setText("");
        txtNumberOfCopies.setText("");
    }

    /**
     * Name: goForward
     * Method used to continue with the second part of the input of the initial parameters. <br>
     * @param event - event representing going forward to the second part of the input of the initial parameters - event = ActionEvent
    */
    @FXML
    public void goForward(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("initial-parameters2.fxml"));
        fxmlLoader.setController(this);
        try {
            Parent initialParameters2 = fxmlLoader.load();
            primaryStage.setTitle("Initial parameters");
            primaryStage.setScene(new Scene(initialParameters2));
            primaryStage.show();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Name: goBack2
     * Method used to go back to the first part of the input of the initial parameters. <br>
     * @param event - event representing going back to the first part of the input of the initial parameters - event = ActionEvent
    */
    @FXML
    public void goBack2(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Are you sure?");
		alert.setHeaderText(null);
		alert.setContentText("If you go back, the book catalog will be lost.");
        if (alert.showAndWait().filter(t -> t == ButtonType.OK).isPresent()) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("initial-parameters1.fxml"));
            fxmlLoader.setController(this);
            try {
                Parent initialParameters1 = fxmlLoader.load();
                primaryStage.setTitle("Initial parameters");
                primaryStage.setScene(new Scene(initialParameters1));
                primaryStage.show();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    /**
     * Name: addClient
     * Method used to add a client in the system. <br>
     * @param event - event representing adding a client in the system - event = ActionEvent
    */
    @FXML
    public void addClient(ActionEvent event) {

    }

    /**
     * Name: appendBook
     * Method used to append a book on a client's books list. <br>
     * @param event - event representing appending a book on a client's books list - event = ActionEvent
    */
    @FXML
    public void appendBook(ActionEvent event) {

    }

    /**
     * Name: giveResult
     * Method used to give the final result of the bookstore simulation. <br>
     * @param event - event representing giving the final result of the bookstore simulation - event = ActionEvent
    */
    @FXML
    public void giveResult(ActionEvent event) {

    }
}
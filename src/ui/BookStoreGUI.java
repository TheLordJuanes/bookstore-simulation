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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import java.io.IOException;
import exceptions.MyQueueException;
import exceptions.MyStackException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
    private TextField txtBookPrice;

    @FXML
    private TextField txtClientIdEnter;

    @FXML
    private Button btnContinue;

    @FXML
    private Button btnAddData;

    @FXML
    private Label lbStatusData;

    @FXML
    private TextField txtISBNList;

    @FXML
    private ChoiceBox<String> cbBookShelf;

    @FXML
    private ChoiceBox<String> cbClientIdList;

    @FXML
    private Button btnAddBook;

    @FXML
    private Button btAppendBook;

    @FXML
    private TextField txtISBNList2;

    @FXML
    private ChoiceBox<String> cbSortingAlgorithm;

    @FXML
    private Button btnDone;

    @FXML
    private TextArea textArea;

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
            txtNumberOfShelves.textProperty().addListener(new ChangeListener<String>() {

                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    if (!newValue.matches("\\d{0,20}?"))
                        txtNumberOfShelves.setText(oldValue);
                }
            });
            txtNumberOfCashiers.textProperty().addListener(new ChangeListener<String>() {

                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    if (!newValue.matches("\\d{0,20}?"))
                        txtNumberOfCashiers.setText(oldValue);
                }
            });
            txtISBN.textProperty().addListener(new ChangeListener<String>() {

                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    if (!newValue.matches("\\d{0,13}?"))
                        txtISBN.setText(oldValue);
                }
            });
            txtNumberOfCopies.textProperty().addListener(new ChangeListener<String>() {

                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    if (!newValue.matches("\\d{0,10}?"))
                        txtNumberOfCopies.setText(oldValue);
                }
            });
            txtBookPrice.textProperty().addListener(new ChangeListener<String>() {

                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    if (!newValue.matches("\\d{0,10}?"))
                        txtBookPrice.setText(oldValue);
                }
            });
            if (bookstore.getNumberOfCashiers() > 0 || bookstore.getNumberOfShelves() > 0) {
                txtISBN.setDisable(false);
                txtNumberOfCopies.setDisable(false);
                cbBookShelf.setDisable(false);
                txtBookPrice.setDisable(false);
                btnAddBook.setDisable(false);
                String[] identifiers = bookstore.getIdentifiers();
                for (int i = 0; i < identifiers.length; i++)
                    cbBookShelf.getItems().add(identifiers[i]);
            }
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
            bookstore = new Bookstore();
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
        if (txtISBN.getText().equals("") || txtNumberOfCopies.getText().equals("") || cbBookShelf.getValue() == null || txtBookPrice.getText().equals(""))
            showWarningAlert("Empty field", null, "Every field must be filled");
        else {
            int bIsbn = Integer.parseInt(txtISBN.getText());
            int numberOfCopies = Integer.parseInt(txtNumberOfCopies.getText());
            String bookShelf = cbBookShelf.getValue();
            double bookPrice = Double.parseDouble(txtBookPrice.getText());
            if (bookstore.addBook(bIsbn, numberOfCopies, bookShelf, bookPrice)) {
                showErrorAlert("Error adding book", null, "A book with the ISBN " + bIsbn + " has already been added to the library");
            }
            btnContinue.setDisable(bookstore.areShelvesEmpty());
            txtISBN.setText("");
            txtBookPrice.setText("");
            txtNumberOfCopies.setText("");
            cbBookShelf.setValue(null);
        }
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
            txtClientIdEnter.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    if (!newValue.matches("\\d{0,20}?"))
                        txtClientIdEnter.setText(oldValue);
                }
            });
            txtISBNList2.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    if (!newValue.matches("\\d{0,13}?"))
                        txtISBNList2.setText(oldValue);
                }
            });
            if (bookstore.getNumberOfClients() == 0) {
                cbClientIdList.setDisable(true);
                txtISBNList2.setDisable(true);
                btAppendBook.setDisable(true);
            } else {
                String[] ids = bookstore.getIds();
                for (int i = 0; i < ids.length; i++)
                    cbClientIdList.getItems().add(ids[i]);
            }
            primaryStage.show();
            cbSortingAlgorithm.getItems().add("Bubble sort");
            cbSortingAlgorithm.getItems().add("Merge sort");
            cbSortingAlgorithm.getItems().add("Heap sort");
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
        alert.setContentText("If you go back, the clients' information will be lost.");
        if (alert.showAndWait().filter(t -> t == ButtonType.OK).isPresent()) {
            bookstore.emptyClients();
            startSimulation(event);
        }
        txtNumberOfCashiers.setText(String.valueOf(bookstore.getNumberOfCashiers()));
        txtNumberOfShelves.setText(String.valueOf(bookstore.getNumberOfShelves()));
        txtNumberOfCashiers.setDisable(true);
        txtNumberOfShelves.setDisable(true);
        btnAddData.setDisable(true);
        btnContinue.setDisable(false);
    }

    /**
     * Name: addClient
     * Method used to add a client in the system. <br>
     * @param event - event representing adding a client in the system - event = ActionEvent
    */
    @FXML
    public void addClient(ActionEvent event) {
        String clientId = txtClientIdEnter.getText();
        if (clientId.equals(""))
            showWarningAlert("The text field is empty", null, "Please enter a client id");
        else {
            if (bookstore.addClient(clientId)) {
                showWarningAlert("The client was not added", null, "There is already a client with the id: " + clientId);
            }
            goForward(event);
        }
    }

    /**
     * Name: appendBook
     * Method used to append a book on a client's books list. <br>
     * @param event - event representing appending a book on a client's books list - event = ActionEvent
    */
    @FXML
    public void appendBook(ActionEvent event) {
        if (cbSortingAlgorithm.getValue() == null ||cbClientIdList.getValue() == null || txtISBNList2.getText().equals(""))
            showWarningAlert("Empty field", null, "Please fill the necessary information.");
        else {
            String clientId = cbClientIdList.getValue();
            int isbn = Integer.parseInt(txtISBNList2.getText());
            if (!bookstore.addBookToClient(clientId, isbn))
                showWarningAlert("Book not found", null, "The book with ISBN " + isbn + " doesn't exist in the system.");
            else
                btnDone.setDisable(false);
        }
    }

    /**
     * Name: giveResult
     * Method used to give the final result of the bookstore simulation. <br>
     * @param event - event representing giving the final result of the bookstore simulation - event = ActionEvent
    */
    @FXML
    public void giveResult(ActionEvent event) {
        char typeOfSort = cbSortingAlgorithm.getValue().charAt(0);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("result.fxml"));
        fxmlLoader.setController(this);
        try {
            Parent result = fxmlLoader.load();
            primaryStage.setTitle("Result");
            primaryStage.setScene(new Scene(result));
            textArea.setText(bookstore.giveResult(typeOfSort));
            primaryStage.show();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (MyQueueException mqe) {
            mqe.printStackTrace();
        } catch (MyStackException mse) {
            mse.printStackTrace();
        }
    }

    @FXML
    public void addData(ActionEvent event) {
        String shelves = txtNumberOfShelves.getText();
        String cashiers = txtNumberOfCashiers.getText();
        if (shelves.equals("") || cashiers.equals(""))
            showErrorAlert("At least one text field is empty", null, "Please fill both text fields (number of shelves, number of cashiers)");
        else if (Integer.parseInt(cashiers) <= 0)
            showErrorAlert("Invalid number of cashiers", null, "There must be at least one cashier");
        else {
            int nShelves = Integer.valueOf(shelves);
            int nCashiers = Integer.valueOf(cashiers);
            bookstore.addCashiers(nCashiers);
            bookstore.createShelves(nShelves);
            startSimulation(event);
            txtNumberOfCashiers.setText(String.valueOf(bookstore.getNumberOfCashiers()));
            txtNumberOfShelves.setText(String.valueOf(bookstore.getNumberOfShelves()));
            txtNumberOfCashiers.setDisable(true);
            txtNumberOfShelves.setDisable(true);
            btnAddData.setDisable(true);
        }
    }

    @FXML
    public void reload(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("start-simulation.fxml"));
		BookStoreGUI bookStoreGUI = new BookStoreGUI(primaryStage);
		fxmlLoader.setController(bookStoreGUI);
		Parent root;
		try {
			root = fxmlLoader.load();
			primaryStage.setScene(new Scene(root));
			primaryStage.setTitle("BookStore S.A.S.");
			primaryStage.show();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
    }
}
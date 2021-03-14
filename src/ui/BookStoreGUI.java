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
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import java.io.IOException;
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
                    if (!newValue.matches("\\d{0,3}?"))
                    	txtNumberOfCopies.setText(oldValue);
                }
            });
            txtBookPrice.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    if (!newValue.matches("\\d{0,3}?"))
                    	txtBookPrice.setText(oldValue);
                }
            });
            if(bookstore.getNumberOfCashiers()==0 || bookstore.getNumberOfShelves()==0) {
            	txtISBN.setDisable(true);
            	txtNumberOfCopies.setDisable(true);
            	cbBookShelf.setDisable(true);
            	txtBookPrice.setDisable(true);
            	btnAddBook.setDisable(true);
            }else {
            	String[] identifiers = bookstore.getIdentifiers();
            	for(int i=0; i<identifiers.length; i++)
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
        int bIsbn = Integer.parseInt(txtISBN.getText());
        int numberOfCopies = Integer.parseInt(txtNumberOfCopies.getText());
        String bookShelf = cbBookShelf.getValue();
        double bookPrice = Double.parseDouble(txtBookPrice.getText());
        if(bookstore.addBook(bIsbn,numberOfCopies,bookShelf,bookPrice))
            showErrorAlert("Error adding book",null,"A book with that ISBN has already been added to the library");
        txtISBN.setText("");
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
            cbSortingAlgorithm.getItems().add("Counting sort");
            cbSortingAlgorithm.getItems().add("Radix sort");
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
        if (alert.showAndWait().filter(t -> t == ButtonType.OK).isPresent())
            startSimulation(event);
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
            showErrorAlert("The text field is empty", null, "Please enter the client id");
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

    }

    /**
     * Name: giveResult
     * Method used to give the final result of the bookstore simulation. <br>
     * @param event - event representing giving the final result of the bookstore simulation - event = ActionEvent
    */
    @FXML
    public void giveResult(ActionEvent event) {
        if (cbSortingAlgorithm.getValue().equals("Bubble sort"))
            bookstore.orderClientsBooks('B');
        else if (cbSortingAlgorithm.getValue().equals("Counting sort"))
            bookstore.orderClientsBooks('C');
        else
            bookstore.orderClientsBooks('R');
    }

    @FXML
    public void addData(ActionEvent event) {
    	String shelves = txtNumberOfShelves.getText();
        String cashiers = txtNumberOfCashiers.getText();
        if (shelves.equals("") || cashiers.equals(""))
            showErrorAlert("At least one text field is empty", null, "Please fill both text fields (number of shelves, number of cashiers)");
        else {
            int nShelves = Integer.valueOf(shelves);
            int nCashiers = Integer.valueOf(cashiers);
            bookstore.setNumberOfCashiers(nCashiers);
            bookstore.createShelves(nShelves);
            startSimulation(event);
        }
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carDealership;

import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import prog24178.utils.Validator;

/**
 *
 * @author Frankie
 * @author Miguelle
 */
public class Store extends Application {

    VBox editorPane, inventoryDisplay, addForm, editForm, searchForm,
            deleteForm;
    BorderPane root;
    HBox bottomArea;
    Button add, edit, delete, showInventory, close, searchButton,
            backButton, submitAdd, submitEdit, submitSearch;
    TextArea txtDisplay;
    Label lblTitle, lblYear, lblMake, lblModel, lblVin, lblPrice, lblBc, lblBt,
            lblFt, lblMileage, lblSeats, lblColor, lblSelect;
    TextField txtYear, txtModel, txtVin, txtPrice, txtFt,
            txtMileage, txtSeats, txtColor;
    ComboBox cbMake, cbCondition, cbBT, cbFT;
    Validator yearValidator = new Validator();
    Validator priceValidator = new Validator();
    Validator stringValidator = new Validator();
    VehicleList vehicleList;

    @Override
    public void start(Stage primaryStage) throws IOException {

        /**
         * GUI Display areas
         */
        root = new BorderPane();
        editorPane = new VBox(15);
        inventoryDisplay = new VBox();
        bottomArea = new HBox(15);

        /**
         * Adding nodes
         */
        add = new Button("Add");
        edit = new Button("Edit");
        delete = new Button("Delete");
        searchButton = new Button("Search");
        showInventory = new Button("Show Inventory");

        close = new Button("Close");
        txtDisplay = new TextArea();
        txtDisplay.setPrefHeight(600);
        txtDisplay.setPrefWidth(300);
        txtDisplay.setEditable(false);
        txtDisplay.getStyleClass().add("txtDisplay");
        lblTitle = new Label("Welcome to shitty Car Inventory");
        lblTitle.getStyleClass().add("lblTitle");
        lblTitle.setPrefWidth(800);
        lblYear = new Label("Year: ");
        txtYear = new TextField();
        lblMake = new Label("Make: ");
        cbMake = new ComboBox();
        lblModel = new Label("Model: ");
        txtModel = new TextField();
        lblVin = new Label("VIN: ");
        txtVin = new TextField();
        lblPrice = new Label("Price: ");
        txtPrice = new TextField();
        lblBc = new Label("Body Condition: ");
        cbCondition = new ComboBox();
        lblBt = new Label("Body Type: ");
        cbBT = new ComboBox();
        lblMileage = new Label("Mileage: ");
        txtMileage = new TextField();
        lblFt = new Label("Fuel Type: ");
        cbFT = new ComboBox();
        lblSeats = new Label("Number of Seats: ");
        txtSeats = new TextField();
        lblColor = new Label("Color: ");
        txtColor = new TextField();
        submitAdd = new Button("Submit");
        submitEdit = new Button("Submit");
        submitSearch = new Button("Submit");
        backButton = new Button("Back");
        vehicleList = new VehicleList();

        /**
         * Creating Array for combo boxes
         */
        Make[] carMake = Make.values();
        cbMake.getItems().addAll(carMake);
        BodyCondition[] carCondition = BodyCondition.values();
        cbCondition.getItems().addAll(carCondition);
        BodyType[] carType = BodyType.values();
        cbBT.getItems().addAll(carType);
        Transmission[] fuelType = Transmission.values();
        cbFT.getItems().addAll(fuelType);

        /**
         * Assigning nodes to their boxes or panes
         */
        editorPane.getChildren().addAll(add, edit, delete, searchButton);
        bottomArea.getChildren().addAll(showInventory, close);
        bottomArea.setAlignment(Pos.CENTER);
        bottomArea.setPadding(new Insets(100));
        inventoryDisplay.getChildren().add(txtDisplay);
        root.setLeft(editorPane);
        root.setCenter(inventoryDisplay);
        root.setBottom(bottomArea);
        root.setTop(lblTitle);
        lblTitle.setPadding(new Insets(0, 0, 0, 225));
        editorPane.setPadding(new Insets(20));

        /**
         * Action events
         */
        searchButton.setOnAction(e -> eventCode(e));
        add.setOnAction(e -> eventCode(e));
        edit.setOnAction(e -> eventCode(e));
        close.setOnAction(e -> Platform.exit());
        delete.setOnAction(e -> eventCode(e));

        Scene scene = new Scene(root, 800, 800);
        scene.getStylesheets().add("styles.css");
        primaryStage.setTitle("Car inventory");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public VBox addForm() {
        addForm = new VBox();

        addForm.getChildren().addAll(lblYear, txtYear, lblMake, cbMake, lblModel,
                txtModel, lblVin, txtVin, lblPrice, txtPrice, lblBc,
                cbCondition, lblBt, cbBT, lblMileage, txtMileage, lblFt, cbFT,
                lblSeats, txtSeats, lblColor, txtColor, submitAdd,
                backButton);

        addForm.setAlignment(Pos.CENTER);

        backButton.setOnAction(e -> eventCode(e));

        return addForm;

    }

    /**
     * A form to populate a search field for the user to find data
     *
     * @return
     */
    public VBox searchBox() {
        searchForm = new VBox();
        searchForm.getChildren().addAll(lblYear, txtYear, lblMake, cbMake,
                submitSearch, backButton);
        searchForm.setAlignment(Pos.CENTER);
        submitSearch.setOnAction(e -> eventCode(e));
        backButton.setOnAction(e -> eventCode(e));
        return searchForm;
    }

    /**
     * A method to generate an edit form when the user presses edit
     *
     * @return editForm
     */
    public VBox editBox() {
        editForm = new VBox();
        editForm.getChildren().addAll(lblYear, txtYear, lblMake, cbMake, lblModel,
                txtModel, lblVin, txtVin, lblPrice, txtPrice, lblBc,
                cbCondition, lblBt, cbBT, lblMileage, txtMileage, lblFt, cbFT,
                lblSeats, txtSeats, lblColor, txtColor, submitEdit,
                backButton);
        editForm.setAlignment(Pos.CENTER);
        backButton.setOnAction(e -> eventCode(e));
        return editForm;

    }

    /**
     * A method to handle actions performed by the user
     *
     * @param e event that user performs
     */
    private void eventCode(ActionEvent e) {
        if (e.getSource() == add) {
            root.setLeft(addForm());
        }
        if (e.getSource() == backButton) {
            root.setLeft(editorPane);
        }
        if (e.getSource() == searchButton) {
            root.setLeft(searchBox());
        }
        if (e.getSource() == edit) {
            TextInputDialog input = new TextInputDialog();
            input.setTitle("Input Dialog");
            input.setContentText("Enter Record number to edit");

            Optional<String> record = input.showAndWait();
            if (record.isPresent()) {
                if (!vehicleList.checkRecord(Integer.parseInt(record.toString()))) {
                    txtDisplay.setText("Please enter a valid record number");
                }
                else{
                    root.setLeft(editBox());
                }

            }

        }
        if (e.getSource() == delete) {
        }
        if (e.getSource() == submitSearch) {
            //TO DO

        }
        if (e.getSource() == submitAdd) {
            if (!(isValidInteger(txtYear.getText()))) {
                txtDisplay.setText("Year invalid");
                lblYear.setTextFill(Color.RED);
            } else if (cbMake.getSelectionModel().getSelectedIndex() == -1) {
                txtDisplay.setText("You must choose the make of the car");
                lblYear.setTextFill(Color.BLACK);
                lblMake.setTextFill(Color.RED);
            } else if (txtModel.getText().equals("")) {
                txtDisplay.setText("You must input a model");
                lblModel.setTextFill(Color.RED);
                lblMake.setTextFill(Color.BLACK);
            } else if (txtVin.getText().equals("")) {
                txtDisplay.setText("You must enter the VIN");
                lblVin.setTextFill(Color.RED);
                lblModel.setTextFill(Color.BLACK);
            } else if (!(isValidDouble(txtPrice.getText()))) {
                txtDisplay.setText("Invalid price");
                lblPrice.setTextFill(Color.RED);
                lblVin.setTextFill(Color.BLACK);
            } else if (cbCondition.getSelectionModel().getSelectedIndex() == -1) {
                txtDisplay.setText("You must choose a condition");
                lblBc.setTextFill(Color.RED);
                lblPrice.setTextFill(Color.BLACK);
            } else if (cbBT.getSelectionModel().getSelectedIndex() == -1) {
                txtDisplay.setText("You must select a body type");
                lblBt.setTextFill(Color.RED);
                lblBc.setTextFill(Color.BLACK);
            } else if (!(isValidInteger(txtMileage.getText()))) {
                txtDisplay.setText("Invalid mileage");
                lblMileage.setTextFill(Color.RED);
                lblBt.setTextFill(Color.BLACK);
            } else if (cbFT.getSelectionModel().getSelectedIndex() == -1) {
                txtDisplay.setText("You must select a transmission type");
                lblFt.setTextFill(Color.RED);
                lblBt.setTextFill(Color.BLACK);
            } else if (!(isValidInteger(txtSeats.getText()))) {
                txtDisplay.setText("You must enter the number of seats");
                lblSeats.setTextFill(Color.RED);
                lblFt.setTextFill(Color.BLACK);
            } else if (txtColor.getText().equals("")) {
                txtDisplay.setText("You must enter the color of the car");
                lblColor.setTextFill(Color.RED);
                lblSeats.setTextFill(Color.BLACK);
            }
            if (e.getSource() == submitEdit) {
                
            }
            if (e.getSource() == showInventory) {
                //TO Do
            }

        }
    }

    public boolean isValidInteger(String val) {
        try {
            int num = Integer.parseInt(val);
            return true;
        } 
        catch (NumberFormatException e) {
        }
        return false;
    }

    public boolean isValidDouble(String val) {
        try {
            double num = Double.parseDouble(val);
            return true;
        } catch (NumberFormatException e) {
        }
        return false;
    }
 
    



    public void save() {

    }

}

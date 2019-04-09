/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carDealership;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

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
            backButton, submitAdd, submitEdit;
    TextArea txtDisplay;
    Label lblTitle, lblYear, lblMake, lblModel, lblVin, lblPrice, lblBc, lblBt,
            lblFt, lblMileage, lblSeats, lblColor, lblSelect;
    TextField txtYear, txtModel, txtVin, txtPrice, txtFt,
            txtMileage, txtSeats, txtColor;
    ComboBox cbMake, cbCondition, cbBT, cbFT;

    @Override
    public void start(Stage primaryStage) {

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
        txtDisplay.setPrefHeight(700);
        lblTitle = new Label("Welcome to shitty Car Inventory");
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
        backButton = new Button("Back");

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
        inventoryDisplay.getChildren().add(txtDisplay);
        root.setLeft(editorPane);
        root.setRight(inventoryDisplay);
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

        Scene scene = new Scene(root, 600, 600);

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
     * @return 
     */
    public VBox searchBox() {
        searchForm = new VBox();
        searchForm.getChildren().addAll(lblYear, txtYear, lblMake, cbMake,
                backButton);
        searchForm.setAlignment(Pos.CENTER);
        backButton.setOnAction(e -> eventCode(e));
        return searchForm;
    }

    /**
     * A method to generate an edit form when the user presses edit
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
            int num = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Enter a Record Number to edit"));
            root.setLeft(editBox());
        }
        if (e.getSource() == delete) {
            int num = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Enter a Record Number to Delete"));
        }
        if (e.getSource() == submitAdd) {
            //
        }
        if (e.getSource() == submitEdit) {
            //
        }


    }

    public void save() {
        
    }

}

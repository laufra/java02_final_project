/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carDealership;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
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
import javafx.scene.control.Alert.AlertType;
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
    Label lblTitle, lblYear, lblMake, lblModel, lblPrice, lblColor, lblSelect;
    TextField txtYear, txtModel, txtPrice, txtColor;
    ComboBox cbMake, cbColor;
    Validator yearValidator = new Validator();
    Validator priceValidator = new Validator();
    Validator stringValidator = new Validator();
    VehicleList vehicleList;
    Vehicle vehicle;
    int recNum;

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
        lblTitle = new Label("Welcome to Car Inventory");
        lblTitle.getStyleClass().add("lblTitle");
        lblTitle.setPrefWidth(800);
        lblYear = new Label("Year: ");
        txtYear = new TextField();
        lblMake = new Label("Make: ");
        cbMake = new ComboBox();
        lblModel = new Label("Model: ");
        txtModel = new TextField();
        lblPrice = new Label("Price: ");
        txtPrice = new TextField();
        lblColor = new Label("Color: ");
        cbColor = new ComboBox();
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

        String[] colors = {"Red", "Blue", "White", "Gray", "Silver"};
        cbColor.getItems().addAll(colors);
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
        showInventory.setOnAction(e -> eventCode(e));

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
                txtModel, lblPrice, txtPrice, lblColor, cbColor, submitAdd,
                backButton);

        addForm.setAlignment(Pos.CENTER);

        submitAdd.setOnAction(e -> eventCode(e));
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
                txtModel, lblPrice, txtPrice, lblColor, cbColor, submitEdit,
                backButton);
        editForm.setAlignment(Pos.CENTER);
        submitEdit.setOnAction(e -> eventCode(e));
        backButton.setOnAction(e -> eventCode(e));
        return editForm;

    }

    /**
     * A method to handle actions performed by the user
     *
     * @param e event that user performs
     */
    private void eventCode(ActionEvent e) {
        try {
            Validator yearValidator = new Validator(txtYear.getText());
            Validator priceValidator = new Validator(txtPrice.getText());
            vehicleList = new VehicleList();
            vehicle = new Vehicle();
            if (e.getSource() == add) {
                root.setLeft(addForm());
            }
            if (e.getSource() == backButton) {
                root.setLeft(editorPane);
            }
            if (e.getSource() == searchButton) {

                TextInputDialog input = new TextInputDialog();
                input.setTitle("Input Dialog");
                input.setHeaderText(null);
                input.setContentText("Enter a record number:");

                Optional<String> result = input.showAndWait();
                if (result.isPresent() && vehicleList.checkRecord(Integer.parseInt(result.get()))) {
                    //cbMake.getValue().toString();

                    if (vehicleList.checkRecord(Integer.parseInt(result.get()))) {

                        String filego = "vehicle.txt";
                        File file1 = new File(filego);
                        RandomAccessFile rand = new RandomAccessFile(file1, "rw");

                        int recNum = Integer.parseInt(result.get());

                        if (recNum >= 0 && recNum < rand.length() / VehicleList.RECORD_SIZE) {
                            rand.seek(VehicleList.RECORD_SIZE * recNum);

                            txtDisplay.setText("Year\t"
                                    + "\tMake" + "\t\tModel" + "\t\tPrice" + "\t\t\tColor");
                            txtDisplay.appendText("\n-------------------------------------"
                                    + "--------------------------------------------------\n");

                            txtDisplay.appendText(vehicleList.readFileIndex(recNum));
                        }
                    }
                }

            }
            if (e.getSource() == edit) {
                TextInputDialog input = new TextInputDialog();
                input.setTitle("Input Dialog");
                input.setHeaderText(null);
                input.setContentText("Enter record number:");

                Optional<String> result = input.showAndWait();
                if (result.isPresent() && vehicleList.checkRecord(Integer.parseInt(result.get()))) {
                    root.setLeft(editBox());
                    String filePath = "vehicle.txt";
                    File file = new File(filePath);
                    RandomAccessFile random = new RandomAccessFile(file, "rw");
                    recNum = Integer.parseInt(result.get());
                    if (recNum >= 0 && recNum < random.length() / VehicleList.RECORD_SIZE) {
                        random.seek(VehicleList.RECORD_SIZE * recNum);
                        txtYear.setText(Integer.toString(random.readInt()));
                        cbMake.setValue(vehicleList.readString(random, VehicleList.field_size));
                        txtModel.setText(vehicleList.readString(random, VehicleList.field_size));
                        txtPrice.setText(Double.toString(random.readDouble()));
                        cbColor.setValue(vehicleList.readString(random, VehicleList.field_size));
                    }

                }

            }

            if (e.getSource() == submitEdit) {

                Vehicle newVehicle = new Vehicle();
                newVehicle.setYear(Integer.parseInt(txtYear.getText()));
                int vehYear = newVehicle.getYear();
                String tempMake = cbMake.getValue().toString();
                switch (tempMake) {
                    case "Toyota":
                        newVehicle.setMake(Make.Toyota);
                        break;
                    case "Honda":
                        newVehicle.setMake(Make.Honda);
                        break;
                    case "Audi":
                        newVehicle.setMake(Make.Audi);
                        break;
                    case "BMW":
                        newVehicle.setMake(Make.BMW);
                        break;
                    case "Tesla":
                        newVehicle.setMake(Make.Tesla);
                        break;
                    case "Mazda":
                        newVehicle.setMake(Make.Mazda);
                        break;
                    case "Hyundai":
                        newVehicle.setMake(Make.Hyundai);
                        break;
                    case "Nissan":
                        newVehicle.setMake(Make.Nissan);
                        break;
                    case "Ford":
                        newVehicle.setMake(Make.Ford);
                        break;
                    case "MercedesBenz":
                        newVehicle.setMake(Make.MercedesBenz);
                        break;
                    case "Chevrolet":
                        newVehicle.setMake(Make.Chevrolet);
                        break;
                    case "VolksWagen":
                        newVehicle.setMake(Make.Volkswagen);
                        break;
                    case "Subaru":
                        newVehicle.setMake(Make.Subaru);
                        break;

                }
                newVehicle.setModel(txtModel.getText());
                newVehicle.setPrice(Double.parseDouble(txtPrice.getText()));
                newVehicle.setColor(cbColor.getValue().toString());
                
                Make vehMake = newVehicle.getMake();
                String vehModel = newVehicle.getModel();
                double vehPrice = newVehicle.getPrice();
                String vehColor = newVehicle.getColor();

                vehicleList.editRecord(newVehicle, recNum);
                txtDisplay.setText("Entry Saved");
            }

            if (e.getSource() == delete) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                        "Are you sure you wish to delete last entry?",
                        ButtonType.YES, ButtonType.NO);
                alert.setTitle("Delete Record");
                alert.setHeaderText(null);
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.YES) {
                    vehicleList.deleteRecord();
                }

            }
            if (e.getSource() == submitAdd) {
                if (!yearValidator.isValidInteger()) {
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
                } else if (!priceValidator.isValidDouble()) {
                    lblModel.setTextFill(Color.BLACK);
                    txtDisplay.setText("Invalid price");
                    lblPrice.setTextFill(Color.RED);
                } else if (cbColor.getSelectionModel().getSelectedIndex() == -1) {
                    lblPrice.setTextFill(Color.BLACK);
                    txtDisplay.setText("Must input a color");
                    lblColor.setTextFill(Color.RED);
                } else {

                    vehicleList = new VehicleList();
                    vehicle = new Vehicle();
                    vehicle.setYear(Integer.parseInt(txtYear.getText()));
                    vehicle.setMake(Make.valueOf(cbMake.getValue().toString()));
                    vehicle.setModel(txtModel.getText());
                    vehicle.setPrice(Double.parseDouble(txtPrice.getText()));
                    vehicle.setColor(cbColor.getValue().toString());
                    int vehYear = vehicle.getYear();
                    Make vehMake = vehicle.getMake();
                    String vehModel = vehicle.getModel();
                    double vehPrice = vehicle.getPrice();
                    String vehColor = vehicle.getColor();
                    Vehicle veh = new Vehicle(vehYear, vehMake, vehModel, vehPrice, vehColor);
                    vehicleList.add(veh);
                    vehicleList.writeRecord(vehicle);

                    txtDisplay.setText("Entry Saved");
                }
            }

            if (e.getSource() == showInventory) {

                txtDisplay.setText("Year\t"
                        + "\tMake" + "\t\tModel" + "\t\tPrice" + "\t\t\tColor");
                txtDisplay.appendText("\n-------------------------------------"
                        + "--------------------------------------------------");

                txtDisplay.appendText(vehicleList.readFile());
            }
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carDealership;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 *
 * @author Frankie
 */
public class Store extends Application {
    
    VBox editorPane, inventoryDisplay, addForm;
    BorderPane root;
    HBox bottomArea;
    Button add, edit, delete, showInventory, close, addFormBackButton;
    TextArea txtDisplay;
    Label lblTitle, lblYear, lblMake, lblModel, lblVin, lblPrice, lblBc, lblBt, lblFt, 
            lblMileage, lblSeats, lblColor;
    TextField txtModel, txtVin, txtPrice, txtFt,
            txtMileage, txtSeats, txtColor;
    ComboBox cbMake, cbCondition, cbBT, cbFT;
    DatePicker txtYear;
    
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
        showInventory = new Button("Show Inventory");
        close = new Button("Close");
        txtDisplay = new TextArea();
        lblTitle = new Label("Welcome to shitty Car Inventory");
        
        /**
         * Assigning nodes to their boxes or panes
         */
        editorPane.getChildren().addAll(add, edit, delete);
        bottomArea.getChildren().addAll(showInventory, close);
        inventoryDisplay.getChildren().add(txtDisplay);
        root.setLeft(editorPane);
        root.setRight(inventoryDisplay);
        root.setBottom(bottomArea);
        root.setTop(lblTitle);
        lblTitle.setPadding(new Insets(0, 0, 0, 225));
        editorPane.setPadding(new Insets(20));
        
        add.setOnAction(e -> switchPanes(e));
        
        Scene scene = new Scene(root, 600, 350);
        
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
    
    public VBox addForm(){
        addForm = new VBox();
        addFormBackButton = new Button("Back");
        /**
         * Adding text fields and labels
         */
        lblYear = new Label("Year: ");
        txtYear = new DatePicker();
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
        
        Make[] carMake = Make.values();
        cbMake.getItems().addAll(carMake);
        BodyCondition [] carCondition = BodyCondition.values();
        cbCondition.getItems().addAll(carCondition);
        BodyType[] carType = BodyType.values();
        cbBT.getItems().addAll(carType);
        FuelType[] fuelType = FuelType.values();
        cbFT.getItems().addAll(fuelType);
        
        addForm.getChildren().addAll(lblYear, txtYear,lblMake,cbMake,lblModel,
                txtModel, lblVin, txtVin, lblPrice, txtPrice, lblBc, 
                cbCondition, lblBt, cbBT, lblMileage, txtMileage, lblFt, cbFT,
                lblSeats, txtSeats, lblColor, txtColor, addFormBackButton);
        
        addForm.setAlignment(Pos.CENTER);
        
        addFormBackButton.setOnAction(e -> switchPanes(e));
        
        return addForm;
        
    }
    
    private void switchPanes(ActionEvent e){
        if (e.getSource() == add) {
            root.setLeft(addForm());
        }
        if (e.getSource() == addFormBackButton) {
            root.setLeft(editorPane);
        }
        if (e.getSource() == edit){
           
        }
        if (e.getSource() == delete) {
            
        }
    }
    
}

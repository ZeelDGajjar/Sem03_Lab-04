/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sem3_lab04;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author 2474008
 */
public class Sem3_Lab04 extends Application {
    //to add: css, Adding the variable to count seperatly
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage){
        stage.setTitle("Business Trip Calculating App"); 
        
        VBox pairsOfLabelsAndInputs = new VBox();
        HBox trips = new HBox();
        HBox airfare = new HBox();
        HBox carRentals = new HBox();
        HBox milesDriven = new HBox();
        HBox parkingFees = new HBox();
        HBox taxiCharges = new HBox();
        HBox registrationFees = new HBox();
        HBox lodgingCharges = new HBox();
        
        trips.setAlignment(Pos.CENTER_RIGHT);
        airfare.setAlignment(Pos.CENTER_RIGHT);
        carRentals.setAlignment(Pos.CENTER_RIGHT);
        milesDriven.setAlignment(Pos.CENTER_RIGHT);
        parkingFees.setAlignment(Pos.CENTER_RIGHT);
        taxiCharges.setAlignment(Pos.CENTER_RIGHT);
        registrationFees.setAlignment(Pos.CENTER_RIGHT);
        lodgingCharges.setAlignment(Pos.CENTER_RIGHT);
        
                
        Label numOfDaysAsk = new Label("Number of days on the trip: "); 
        Label amtOfAirfareAsk = new Label("Amount of Airfare: "); 
        Label amtOfCarRentalsAsk = new Label("Amount of car rental fees: "); 
        Label numOfMilesAsk = new Label("Number of miles driven: "); 
        Label amtOfParkingFeesAsk = new Label("Amount of parking fees: "); 
        Label amtOfTaxiChargesAsk = new Label("Amount of taxi charges: "); 
        Label RegistrationFeesAsk = new Label("Conference or seminar registration fees: "); 
        Label LodgingChargesAsk = new Label("Lodging charges: "); 
        
        TextField numOfDaysIn = new TextField();
        TextField amtOfAirfareIn = new TextField();
        TextField amtOfCarRentalsIn = new TextField();
        TextField numOfMilesIn = new TextField();
        TextField amtOfParkingFeesIn = new TextField();
        TextField amtOfTaxiChargesIn = new TextField();
        TextField RegistrationFeesIn = new TextField();
        TextField LodgingChargesIn = new TextField();
        
        numOfMilesIn.setOnKeyReleased(e -> {
            amtOfTaxiChargesIn.setText("0");
            amtOfTaxiChargesIn.setDisable(true);
            
            if (numOfMilesIn.getText().isBlank()) {
                amtOfTaxiChargesIn.setDisable(false);
            }
        });
        
        amtOfTaxiChargesIn.setOnKeyReleased(e -> {
            numOfMilesIn.setText("0");
            numOfMilesIn.setDisable(true);
            
            if (amtOfTaxiChargesIn.getText().isBlank()) {
                numOfMilesIn.setDisable(false);
            }
        });
        
        trips.getChildren().addAll(numOfDaysAsk, numOfDaysIn);
        airfare.getChildren().addAll(amtOfAirfareAsk, amtOfAirfareIn);
        carRentals.getChildren().addAll(amtOfCarRentalsAsk, amtOfCarRentalsIn);
        milesDriven.getChildren().addAll(numOfMilesAsk, numOfMilesIn);
        parkingFees.getChildren().addAll(amtOfParkingFeesAsk, amtOfParkingFeesIn);
        taxiCharges.getChildren().addAll(amtOfTaxiChargesAsk, amtOfTaxiChargesIn);
        registrationFees.getChildren().addAll(RegistrationFeesAsk, RegistrationFeesIn);
        lodgingCharges.getChildren().addAll(LodgingChargesAsk, LodgingChargesIn);
        
        pairsOfLabelsAndInputs.getChildren().addAll(trips, airfare, carRentals, milesDriven, parkingFees, taxiCharges, registrationFees, lodgingCharges);
        pairsOfLabelsAndInputs.setAlignment(Pos.CENTER);
        
        VBox results = new VBox();
        Label totalExpenses = new Label("Total Expense: ");
        Label totalAllowableExpenses = new Label("Total Allowable Expense: ");
        Label excessToBePaid = new Label("The Excess to be Paid: ");
        Label amountSaved = new Label("The Amount Saved by the Business Person: ");
        results.getChildren().addAll(totalExpenses, totalAllowableExpenses, excessToBePaid, amountSaved);
        
        Label error = new Label("");
        
        Button btnEnter = new Button("Enter");
        btnEnter.setOnAction(e -> {
            try {
            int numOfDays = Integer.parseInt(numOfDaysIn.getText());
            double amtOfAirfare = Double.parseDouble(amtOfAirfareIn.getText());
            double amtOfCarRentals = Double.parseDouble(amtOfCarRentalsIn.getText());
            double numOfMiles = Double.parseDouble(numOfMilesIn.getText());
            double amtOfParkingFees = Double.parseDouble(amtOfParkingFeesIn.getText());
            double amtOfTaxiCharges = Double.parseDouble(amtOfTaxiChargesIn.getText());
            double RegistrationFees = Double.parseDouble(RegistrationFeesIn.getText());
            double LodgingCharges = Double.parseDouble(LodgingChargesIn.getText());
            
            BusinessPerson businessPerson1 = new BusinessPerson(numOfDays, amtOfAirfare, amtOfCarRentals, numOfMiles, amtOfParkingFees, amtOfTaxiCharges, RegistrationFees, LodgingCharges);
            
            totalExpenses.setText(String.format("Total Expense: %.2f", businessPerson1.calculateTotalExpenses()));
            totalAllowableExpenses.setText(String.format("Total Allowable Expense: %.2f", businessPerson1.calculateTotalAllowableCharges()));
            excessToBePaid.setText(String.format("The Excess to be Paid: %.2f", businessPerson1.calculateExcessToPay()));
            amountSaved.setText(String.format("The Amount Saved by the Business Person: %.2f", businessPerson1.calculateAmountSaved()));
            } catch (NumberFormatException ex) {
                error.setText("Please enter valid numbers in all fields!");
            }
        });
        
        GridPane root = new GridPane();
        root.add(pairsOfLabelsAndInputs, 2, 2);
        root.add(btnEnter, 10, 3);
        root.add(results, 2, 4);
        root.add(error, 2, 0);
        root.setAlignment(Pos.CENTER);
        
        pairsOfLabelsAndInputs.setSpacing(3);
        error.getStyleClass().add("error");
        Scene scene = new Scene(root, 800, 600);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene); 
        stage.show(); 
    }
}

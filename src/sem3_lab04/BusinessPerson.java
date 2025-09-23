/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sem3_lab04;

/**
 *
 * @author zeelg
 */
public class BusinessPerson {
    int numOfDays;
    double amtOfAirfare;
    double amtOfCarRentalFees;
    double numOfMiles;
    double amtOfParkingFees;
    double amtOfTaxiCharges;
    double conferenceRegistrationFees;
    double LodgingFees;

    public BusinessPerson(int numOfDays) {
        this.numOfDays = numOfDays;
    }

    public BusinessPerson(int numOfDays, double amtOfAirfare, double amtOfCarRentalFees, double numOfMiles, double amtOfParkingFees, double amtOfTaxiCharges, double conferenceRegistrationFees, double LodgingFees) {
        this.numOfDays = numOfDays;
        this.amtOfAirfare = amtOfAirfare;
        this.amtOfCarRentalFees = amtOfCarRentalFees;
        this.numOfMiles = numOfMiles;
        this.amtOfParkingFees = amtOfParkingFees;
        this.amtOfTaxiCharges = amtOfTaxiCharges;
        this.conferenceRegistrationFees = conferenceRegistrationFees;
        this.LodgingFees = LodgingFees;
    }

    public double calculateMeals() {
        return numOfDays * 37;
    }

    public double calculateParkingFees() {
        return numOfDays * 10.00;
    }

    public double calculateTaxiCharges() {
        return numOfDays * 20.00;
    }

    public double calculateLodgingCharges() {
        return numOfDays * 95.00;
    }

    public double calculateExtraParkingFees() {
        if (amtOfTaxiCharges != 0) {
            return numOfMiles * 0.27;
        }
        return 0;
    }

    public double calculateTotalExpenses() {
        return amtOfAirfare + amtOfCarRentalFees + amtOfParkingFees + amtOfTaxiCharges + conferenceRegistrationFees + LodgingFees;
    }

    public double calculateTotalAllowableCharges() {
        return calculateMeals() + calculateParkingFees() + calculateTaxiCharges() + calculateLodgingCharges() + calculateExtraParkingFees();
    }

    public double calculateExcessToPay() {
        if (calculateTotalExpenses() > calculateTotalAllowableCharges()) {
            return calculateTotalExpenses() - calculateTotalAllowableCharges();
        }
        return 0;
    }

    public double calculateAmountSaved() {
        if (calculateTotalAllowableCharges() > calculateTotalExpenses()) {
            return calculateTotalAllowableCharges() - calculateTotalExpenses();
        }
        return 0;
    }

    @Override
    public String toString() {
        return "BusinessPerson{" +
                "numOfDays=" + numOfDays +
                ", amtOfAirfare=" + amtOfAirfare +
                ", amtOfCarRentalFees=" + amtOfCarRentalFees +
                ", numOfMiles=" + numOfMiles +
                ", amtOfParkingFees=" + amtOfParkingFees +
                ", amtOfTaxiCharges=" + amtOfTaxiCharges +
                ", conferenceRegistrationFees=" + conferenceRegistrationFees +
                '}';
    }
}

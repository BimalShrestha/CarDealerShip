package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);

    public void display(){
        init();
        while(true){
            option();
            try {
                int userInput = scanner.nextInt();
                switch (userInput) {
                    case 1:
                        //price range

                       processGetByPriceRequest();
                        break;
                    case 2:
                        //Make and Model
                       processGetByMakeModelRequest();
                        break;
                    case 3:
                        //year
                        processGetByYearRequest();
                        break;
                    case 4:
                        //color
                       processGetByColorRequest();
                        break;
                    case 5:
                        //mileage
                        processGetByMileageRequest();
                        break;
                    case 6:
                        //type
                       processGetByVehicleTypeRequest();
                        break;
                    case 7:
                        //display inventory
                        processGetAllVehiclesRequest();
                        break;
                    case 8:
                        //add vehicle
                       processAddVehiclesRequest();
                        break;
                    case 9:
                        //remove vehicle
                        processRemoveVehicleRequest();
                        break;
                    case 10:
                        //purchase finance lease
                        processPurchaseFinanceLeaseVehicle();
                        break;
                    case 0:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Please chose the correct option");
                        break;

                }
            }
            catch (InputMismatchException exception){
                System.out.println("Enter an integer input");
                scanner.nextLine();
            }


        }


    }
    private void option(){
        System.out.println("Welcome to Buck and Bear's car dealership");
        System.out.println("Chose the following options");
        System.out.println("1> By Price\n2> By MakeModel\n3> By Year\n4> By Color\n5> By Mileage\n" +
                "6> By Vehicle Type\n7> Show All Vehicles\n8> Add Vehicle\n" +
                "9> Remove Vehicle\n10>Purchase Finance or lease Vehicle\n0> Exit");

    }
    private void init(){

        DealerShipFileManager.getDealership();

    }
     private void displayVehicles(ArrayList<Vehicle> vehicles){
        for(Vehicle vehicle: vehicles){
            System.out.println(vehicles);
        }

     }
     public void processGetAllVehiclesRequest(){

        DealerShipFileManager.dealership.getAllVehicles(DealerShipFileManager.dealership.inventory);

     }
     private void processGetByPriceRequest() {
         while (true) {
             try {
                 System.out.println("Enter you minimum price range");
                 int min = scanner.nextInt();
                 System.out.println("Enter your maximum price range");
                 int max = scanner.nextInt();
                 ArrayList<Vehicle> vehicles = DealerShipFileManager.dealership.getVehiclesByPrice(min, max);
                 if (vehicles.isEmpty()) {
                     System.out.println("No vehicles of the specified price range found.");
                     return;
                 } else {
                     System.out.println("Vehicles of the specified price range:");
                     displayVehicles(vehicles);
                     break;
                 }
         }
        catch(InputMismatchException exception){
             System.out.println("Enter the correct input format");
             scanner.nextLine();
         }
     }
     }
     private void processGetByMakeModelRequest(){
        try {
            System.out.println("Enter the make of the vehicle");
            scanner.nextLine();
            String make = scanner.nextLine();

            System.out.println("Enter the model of the vehicle");
            String model = scanner.nextLine();
            ArrayList<Vehicle> vehicles = DealerShipFileManager.dealership.getVehiclesByMakeModel(make, model);
            if (vehicles.isEmpty()) {
                System.out.println("No vehicles of the specified make and model found.");
            } else {
                System.out.println("Vehicles of the specified make and model:");
                displayVehicles(vehicles);
            }
        }
        catch (Exception exception){
            System.out.println("exception");
        }
     }
     private void processGetByYearRequest(){
        while(true) {
            try {
                System.out.println("Enter you minimum year");
                int minYear = scanner.nextInt();
                System.out.println("Enter your maximum year");
                int maxYear = scanner.nextInt();
                ArrayList<Vehicle> vehicles = DealerShipFileManager.dealership.getVehiclesByYear(minYear, maxYear);
                if (vehicles.isEmpty()) {
                    System.out.println("No vehicles of the specified year range found.");
                    return;
                } else {
                    System.out.println("Vehicles of the specified year range:");
                    displayVehicles(vehicles);
                    break;
                }
            } catch (InputMismatchException exception) {
                System.out.println("Enter the correct Input");
                scanner.nextLine();
            }
        }
     }
     private void processGetByColorRequest(){
        try {
            System.out.println("Enter the color you want");
            scanner.nextLine();
            String color = scanner.nextLine();

            ArrayList<Vehicle> vehicles = DealerShipFileManager.dealership.getVehiclesByColor(color);
            if (vehicles.isEmpty()) {
                System.out.println("No vehicles of the specified color found.");
            } else {
                System.out.println("Vehicles of the specified color:");
               displayVehicles(vehicles);
            }
        }
        catch (InputMismatchException exception){
            System.out.println("Enter the correct Input");
        }
     }
     private void processAddVehiclesRequest(){
        while(true) {
            try {
                System.out.println("Enter your vehicle vin");
                int newVin = scanner.nextInt();
                System.out.println("Enter you vehicle year");
                int newYear = scanner.nextInt();
                System.out.println("Enter the make of your vehicle");
                scanner.nextLine();
                String newMake = scanner.nextLine();

                System.out.println("Enter the model of your vehicle");
                String newModel = scanner.nextLine();
                System.out.println("Enter your vehicle Type");
                String newVehicleType = scanner.nextLine();
                System.out.println("Enter the color of the vehicle");
                String newColor = scanner.nextLine();
                System.out.println("Enter the odometer value of the vehicle");
                int newOdometer = scanner.nextInt();
                System.out.println("Enter the price of the vehicle");
                double newPrice = scanner.nextDouble();
                Vehicle vehicle = new Vehicle(newVin, newYear, newMake, newModel, newVehicleType, newColor, newOdometer, newPrice);
                DealerShipFileManager.dealership.addVehicle(vehicle);
                System.out.println("Vehicle has been added: " + vehicle);
                DealerShipFileManager.saveDealership(DealerShipFileManager.dealership);
                break;
            }
            catch (InputMismatchException exception) {
                System.out.println("Enter the correct Input");
                scanner.nextLine();
            }
        }
     }
     private void processGetByMileageRequest(){
        while(true) {
            try {
                System.out.println("Enter you minimum odometer range");
                int minOdometer = scanner.nextInt();
                System.out.println("Enter your maximum odometer range");
                int maxOdometer = scanner.nextInt();
                ArrayList<Vehicle> vehicles = DealerShipFileManager.dealership.getVehiclesByMileage(minOdometer, maxOdometer);
                if (vehicles.isEmpty()) {
                    System.out.println("No vehicles of the specified range found.");
                    return;
                } else {
                    System.out.println("Vehicles of the specified mileage range:");
                    displayVehicles(vehicles);
                    break;
                }
            } catch (InputMismatchException exception) {
                System.out.println("Enter the correct Input");
                scanner.nextLine();
            }
        }
     }
     private void processGetByVehicleTypeRequest(){
        try {
            System.out.println("Enter the type of the vehicle");
            scanner.nextLine();
            String vehicleType = scanner.nextLine();

            ArrayList<Vehicle> vehicles = DealerShipFileManager.dealership.getVehiclesByType(vehicleType);

            if (vehicles.isEmpty()) {
                System.out.println("No vehicles of the specified type found.");
            } else {
                System.out.println("Vehicles of the specified type:");
                displayVehicles(vehicles);
            }
        }
        catch (InputMismatchException exception){
            System.out.println("Enter the correct Input");
        }
     }

     private void processRemoveVehicleRequest() {
         while (true) {
             try {
                 System.out.println("Enter the vin of the vehicle you want to remove");
                 int vinUserInput = scanner.nextInt();
                 Vehicle foundVehicle = null;
                 for (Vehicle v : DealerShipFileManager.dealership.inventory) {
                     if (vinUserInput == v.getVin()) {
                         foundVehicle = v;
                     }
                 }
                 if (foundVehicle != null) {
                     System.out.println("Vehicle removed: "+foundVehicle);
                     DealerShipFileManager.dealership.removeVehicle(foundVehicle);
                     DealerShipFileManager.saveDealership(DealerShipFileManager.dealership);
                     break;
                 } else {
                     System.out.println("We do not have the vehicle with that vin number");
                     return;
                 }
             }
            catch(InputMismatchException exception){
                     System.out.println("Enter the correct Input");
                     scanner.nextLine();
                 }
         }
     }

     private void processPurchaseFinanceLeaseVehicle(){
        System.out.println("Here is the list of our vehicles ");
        processGetAllVehiclesRequest();
        while(true) {
            try {
                System.out.println("Chose an option:\n1> Purchase\n2> Finance\n3> Lease\n0> Return to the main menu");
                int userInput = scanner.nextInt();
                switch (userInput) {
                    case 1:
                        getPurchase();
                        break;
                    case 2:
                        getFinance();
                        break;
                    case 3:
                        getLease();
                        break;
                    case 0:
                        System.out.println("You are returning to the main menu");
                        return;
                    default:
                        System.out.println("Pick a correct option");
                        break;
                }
            } catch (InputMismatchException exception) {
                System.out.println("Choose the correct input");
                scanner.nextLine();
            }
        }



     }
     private void getPurchase(){
        while(true) {
            try {
                System.out.println("Enter customer name please");
                scanner.nextLine();
                String name = scanner.nextLine().trim();
                System.out.println("Enter customer email address ");
                String email = scanner.nextLine().trim();
                System.out.println("Enter the vin number of the car to purchase");
                int vinNumber = scanner.nextInt();
                scanner.nextLine();

                Vehicle foundVehicle = null;

                for (Vehicle v : DealerShipFileManager.dealership.inventory) {
                    if (vinNumber == v.getVin()) {
                        foundVehicle = v;
                    }
                }
                while(true) {
                    try {
                        if (foundVehicle != null) {
                            SalesContract sc = new SalesContract(LocalDate.now(), name, email, foundVehicle, false);
                            System.out.println("Your Total payment will be:\n" + foundVehicle + "\nTotal Payment: " + sc.getTotalPrice() + "$");
                            System.out.println("Final confirmation do you still wanna purchase it:\n1> yes\n2> no");
                            int userInput = scanner.nextInt();

                            switch (userInput) {

                                case 1:
                                    System.out.println("Vehicle Purchased. Thank you for your business.");
                                    ContractDataManager.saveContract(sc);
                                    DealerShipFileManager.dealership.removeVehicle(foundVehicle);
                                    DealerShipFileManager.saveDealership(DealerShipFileManager.dealership);

                                    return;
                                case 2:
                                    System.out.println("Your are returning to the purchase/lease/finance menu");
                                    return;
                                default:
                                    System.out.println("chose the correct option");
                                    break;
                            }
                        } else {
                            System.out.println("We do not have the vehicle with that VIN number.");
                            return;
                        }
                    }
                    catch (InputMismatchException exception){
                        System.out.println("invalid input");
                        scanner.nextLine();
                    }
                }
            } catch (InputMismatchException exception) {
                System.out.println("Enter a valid Input");
            }
        }

     }
     private void getFinance(){
        while(true) {
            try {
                System.out.println("Enter customer name please");
                scanner.nextLine();
                String name = scanner.nextLine().trim();
                System.out.println("Enter customer email address ");
                String email = scanner.nextLine().trim();
                System.out.println("Enter the vin number of the car to Finance");
                int vinNumber = scanner.nextInt();

                Vehicle foundVehicle = null;

                for (Vehicle v : DealerShipFileManager.dealership.inventory) {
                    if (vinNumber == v.getVin()) {
                        foundVehicle = v;
                        break;
                    }
                }
                while (true) {
                    try {
                        if (foundVehicle != null) {
                            SalesContract sc = new SalesContract(LocalDate.now(), name, email, foundVehicle, true);
                            System.out.println("Your monthly payment for: " + foundVehicle + "\nMonthly Payment: " + sc.getMonthlyPayment() + "$");
                            System.out.println("Final confirmation do you still wanna Finance it:\n1> yes\n2> no");
                            int userInput = scanner.nextInt();
                            switch (userInput) {

                                case 1:
                                    System.out.println("Vehicle financed. Thank you for your business.");
                                    ContractDataManager.saveContract(sc);
                                    DealerShipFileManager.dealership.removeVehicle(foundVehicle);
                                    DealerShipFileManager.saveDealership(DealerShipFileManager.dealership);
                                    return;
                                case 2:
                                    System.out.println("Your are returning to the purchase/lease/finance menu");
                                    return;
                                default:
                                    System.out.println("chose the correct option");
                                    break;
                            }
                        } else {
                            System.out.println("We do not have the vehicle with that VIN number.");
                            return;
                        }
                    }
                    catch (InputMismatchException exception){
                        System.out.println("Invalid Input");
                        scanner.nextLine();
                    }
                }
            } catch (InputMismatchException exception) {
                System.out.println("Invalid input");
            }
        }

     }
    private void getLease(){
        while(true) {
            try {
                System.out.println("Enter Customer name please");
                scanner.nextLine();
                String name = scanner.nextLine().trim();
                System.out.println("Enter Customer email address ");
                String email = scanner.nextLine().trim();
                System.out.println("Enter the vin number of the car to Lease");
                int vinNumber = scanner.nextInt();

                Vehicle foundVehicle = null;

                for (Vehicle v : DealerShipFileManager.dealership.inventory) {
                    if (vinNumber == v.getVin()) {
                        foundVehicle = v;
                        break;
                    }
                }
                while (true) {
                    try {
                        if (foundVehicle != null) {
                            LeaseContract lc = new LeaseContract(LocalDate.now(), name, email, foundVehicle);
                            System.out.println("Your monthly payment will be:\n" + foundVehicle + "\nMonthly Payment: " + lc.getMonthlyPayment() + "$");
                            System.out.println("Final confirmation do you still wanna lease it:\n1> yes\n2> no");
                            int userInput = scanner.nextInt();
                            switch (userInput) {

                                case 1:
                                    System.out.println("Vehicle leased. Thank you for your business.");

                                    ContractDataManager.saveContract(lc);
                                    DealerShipFileManager.dealership.removeVehicle(foundVehicle);
                                    DealerShipFileManager.saveDealership(DealerShipFileManager.dealership);
                                    return;
                                case 2:
                                    System.out.println("Your are returning to the purchase/finance/lease menu");
                                    return;
                                default:
                                    System.out.println("chose the correct option");
                                    break;
                            }
                        } else {
                            System.out.println("We do not have the vehicle with that VIN number.");
                            return;
                        }
                    }
                    catch (InputMismatchException exception){
                        System.out.println("Invalid Input");
                        scanner.nextLine();
                    }
                }
            } catch (InputMismatchException exception) {
                System.out.println("Enter a valid Input");
            }
        }


    }


     //throw new UnsupportedOperationException("This method hasn't been implemented yet.");

}

package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    DealerShipFileManager dfm = new DealerShipFileManager();

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
                "6> By Vehicle Type\n7> Show All Vehicles\n8> Add Vehicle\n9> Remove Vehicle\n0> Exit");

    }
    private void init(){

        dfm.getDealership();

    }
    //Why not use this helper method to display your vehicles?
     private void displayVehicles(ArrayList<Vehicle> inventory){
        for(Vehicle vehicle: inventory){
            System.out.println(inventory);
        }

     }
     public void processGetAllVehiclesRequest(){

        dfm.dealership.getAllVehicles(dfm.dealership.inventory);

     }
     private void processGetByPriceRequest(){
         System.out.println("Enter you minimum price range");
         int min = scanner.nextInt();
         System.out.println("Enter your maximum price range");
         int max = scanner.nextInt();
         ArrayList<Vehicle> vehicles =dfm.dealership.getVehiclesByPrice(min, max);
         if (vehicles.isEmpty()) {
             System.out.println("No vehicles of the specified price range found.");
         } else {
             System.out.println("Vehicles of the specified price range:");
             //for example, you can use your helper like this
             displayVehicles(vehicles);
         }
     }
     private void processGetByMakeModelRequest(){
         System.out.println("Enter the make of the vehicle");
         scanner.nextLine();
         String make = scanner.nextLine();

         System.out.println("Enter the model of the vehicle");
         String model = scanner.nextLine();
         ArrayList<Vehicle> vehicles = dfm.dealership.getVehiclesByMakeModel(make, model);
         if (vehicles.isEmpty()) {
             System.out.println("No vehicles of the specified make and model found.");
         } else {
             System.out.println("Vehicles of the specified make and model:");
             for (Vehicle vehicle : vehicles) {
                 System.out.println(vehicle);
             }
         }
     }
     private void processGetByYearRequest(){
         System.out.println("Enter you minimum year");
         int minYear = scanner.nextInt();
         System.out.println("Enter your maximum year");
         int maxYear = scanner.nextInt();
         ArrayList<Vehicle> vehicles = dfm.dealership.getVehiclesByYear(minYear, maxYear);
         if (vehicles.isEmpty()) {
             System.out.println("No vehicles of the specified year range found.");
         } else {
             System.out.println("Vehicles of the specified year range:");
             for (Vehicle vehicle : vehicles) {
                 System.out.println(vehicle);
             }
         }
     }
     private void processGetByColorRequest(){
         System.out.println("Enter the color you want");
         scanner.nextLine();
         String color = scanner.nextLine();

         ArrayList<Vehicle> vehicles= dfm.dealership.getVehiclesByColor(color);
         if (vehicles.isEmpty()) {
             System.out.println("No vehicles of the specified color found.");
         } else {
             System.out.println("Vehicles of the specified color:");
             for (Vehicle vehicle : vehicles) {
                 System.out.println(vehicle);
             }
         }
     }
     private void processAddVehiclesRequest(){
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
         dfm.dealership.addVehicle(vehicle);
         System.out.println("Vehicle has been added: "+vehicle);
         dfm.saveDealership(vehicle);
     }
     private void processGetByMileageRequest(){
         System.out.println("Enter you minimum odometer range");
         int minOdometer = scanner.nextInt();
         System.out.println("Enter your maximum odometer range");
         int maxOdometer = scanner.nextInt();
         ArrayList<Vehicle> vehicles= dfm.dealership.getVehiclesByMileage(minOdometer, maxOdometer);
         if (vehicles.isEmpty()) {
             System.out.println("No vehicles of the specified range found.");
         } else {
             System.out.println("Vehicles of the specified mileage range:");
             for (Vehicle vehicle : vehicles) {
                 System.out.println(vehicle);
             }
         }
     }
     private void processGetByVehicleTypeRequest(){
         System.out.println("Enter the type of the vehicle");
         scanner.nextLine();
         String vehicleType = scanner.nextLine();

         ArrayList<Vehicle> vehicles = dfm.dealership.getVehiclesByType(vehicleType);

         if (vehicles.isEmpty()) {
             System.out.println("No vehicles of the specified type found.");
         } else {
             System.out.println("Vehicles of the specified type:");
             for (Vehicle vehicle : vehicles) {
                 System.out.println(vehicle);
             }
         }
     }
     private void processRemoveVehicleRequest(){
         System.out.println("Enter the vin of the vehicle you want to remove");
         int vinUserInput = scanner.nextInt();
         for (Vehicle v : dfm.dealership.inventory) {
             if (vinUserInput == v.getVin()) {
                 System.out.println("Vehicle removed: "+v);
                 dfm.dealership.removeVehicle(v);
                 break;
             } else {
                 System.out.println("We do not have the vehicle with that vin number");
                 break;
             }
         }
     }
     //throw new UnsupportedOperationException("This method hasn't been implemented yet.");

}

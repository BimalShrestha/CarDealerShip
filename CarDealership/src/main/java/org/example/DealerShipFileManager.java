package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DealerShipFileManager {

    public static Dealership dealership = new Dealership("Buck and Bear's Dealership","111 bark lane","bear-food-1111");

    private DealerShipFileManager(){

    }

    public static Dealership saveDealership(Dealership dealership){
        try {

            File file = new File("src/main/resources/inventory.csv");
            boolean fileExists = file.exists();
            FileWriter fileWriter = new FileWriter(file);


            if (!fileExists || file.length() == 0) {
                // Write the header line
                fileWriter.write((String.format("%s|%s|%s\n",dealership.getName(),dealership.getAddress(),dealership.getPhone())));
            }
            for(Vehicle vehicle: dealership.inventory) {
                String s = String.format("%d|%d|%s|%s|%s|%s|%d|%.2f\n", vehicle.getVin(), vehicle.getYear(),
                        vehicle.getMake(), vehicle.getModel(), vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice());
                fileWriter.write(s);
            }
            fileWriter.close();
        }
        catch (IOException exception){
            System.out.println("File cannot be written");
        }
        return dealership;
    }
    public static void getDealership(){
        try{
            FileInputStream fis = new FileInputStream("src/main/resources/inventory.csv");
            Scanner scanner = new Scanner(fis);
            scanner.nextLine();
            while(scanner.hasNextLine()){
                String input = scanner.nextLine();
                String [] rowArray = input.split("\\|");
                Vehicle vehicle = new Vehicle(Integer.parseInt(rowArray[0]),Integer.parseInt(rowArray[1]),rowArray[2],rowArray[3],rowArray[4],rowArray[5],Integer.parseInt(rowArray[6]),Double.parseDouble(rowArray[7]));
                dealership.addVehicle(vehicle);
            }
        }
        catch(FileNotFoundException exception){
            System.out.println("Sorry file not found");
        }
    }


}

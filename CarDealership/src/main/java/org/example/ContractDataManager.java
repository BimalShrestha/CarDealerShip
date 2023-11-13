package org.example;

import java.io.*;
import java.util.Scanner;

public class ContractDataManager {
    private ContractDataManager(){

    }
    public static void saveContract(Contract contract){

        try{
            File file = new File("src/main/resources/contract.csv");
            FileWriter fileWriter = new FileWriter(file,true);
            if (contract instanceof SalesContract) {
                String s = String.format("SALE|%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%.2f|%.2f|%.2f|%.2f|%.2f|%s|%.2f\n"
                        , contract.getDateOfContract(), contract.getCustomerName(), contract.getCustomerEmail()
                        , contract.getVehicleSold().getVin(), contract.getVehicleSold().getYear(),
                        contract.getVehicleSold().getMake(), contract.getVehicleSold().getModel(),
                        contract.getVehicleSold().getVehicleType(), contract.getVehicleSold().getColor(), contract.getVehicleSold().getOdometer(),
                        contract.getVehicleSold().getPrice(), ((SalesContract) contract).salesTaxAmount(),
                        ((SalesContract) contract).recordingFee(), ((SalesContract) contract).processingFee(),
                        contract.getTotalPrice(), ((SalesContract) contract).isFinanced(),
                        contract.getMonthlyPayment());
                fileWriter.write(s);
            }
                else{
                    String s = String.format("LEASE|%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%.2f|%.2f|%.2f|%.2f|%."
                            ,contract.getDateOfContract(),contract.getCustomerName(),contract.getCustomerEmail()
                            ,contract.getVehicleSold().getVin(),contract.getVehicleSold().getYear(),
                            contract.getVehicleSold().getMake(),contract.getVehicleSold().getModel(),
                            contract.getVehicleSold().getVehicleType(),contract.getVehicleSold().getColor(),contract.getVehicleSold().getOdometer(),
                            contract.getVehicleSold().getPrice(),((LeaseContract)contract).getExpectedEndingValue(),
                            ((LeaseContract)contract).getLeaseFee(), contract.getTotalPrice(),
                            contract.getMonthlyPayment());
                    fileWriter.write(s);

                }
                fileWriter.close();
        }
        catch (IOException exception){
            System.out.println("File not found");
        }
    }
    /*public static void getContract(){
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/contract.csv");
            Scanner scanner = new Scanner(fis);

            while(scanner.hasNextLine()){
                String input = scanner.nextLine();
                String []rowArray = input.split("\\|");
                Contract contract=new SalesContract(rowArray[0], rowArray[1], rowArray[2], rowArray[3], Integer.parseInt(rowArray[4]), Integer.parseInt(rowArray[5]), rowArray[6], rowArray[7], rowArray[8], rowArray[9], rowArray[10], rowArray[11], rowArray[12], rowArray[13], rowArray[14], rowArray[15], rowArray[16], rowArray[17]);
                if (contract instanceof SalesContract){
                    contract =


            }
        }
        catch (FileNotFoundException exception){
            System.out.println("File not found");
        }
    }*/

}

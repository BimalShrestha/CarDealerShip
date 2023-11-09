package org.example;

public class LeaseContract extends Contract{
    public LeaseContract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
    }
    public double getExpectedEndingValue(){
        return 0.5*getVehicleSold().getPrice();
    }
    public double getLeaseFee(){
        return 0.07*getVehicleSold().getPrice();
    }
    @Override
    public double getTotalPrice() {
        return getVehicleSold().getPrice() - getExpectedEndingValue()+getLeaseFee();
    }

    @Override
    public double getMonthlyPayment() {
        return (getVehicleSold().getPrice() - getExpectedEndingValue())/36+((getVehicleSold().getPrice() + getExpectedEndingValue())* (4/2400));
    }
}

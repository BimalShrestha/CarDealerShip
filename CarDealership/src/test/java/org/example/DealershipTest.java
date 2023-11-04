package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DealershipTest {

    @org.junit.jupiter.api.Test
    public void getVehiclesByPrice_IF_The_Price_Is_With_IN_Range() {
        //arrange
        Dealership d = new Dealership("lewisville Honda", "45454 fit st","454646548");
        Vehicle v = new Vehicle(1,2012,"honda","civic","sedan","silver",78979879,15000);
        d.inventory.add(v);
        //act
        ArrayList<Vehicle> vehicle = d.getVehiclesByPrice(10000,20000);
        //assert
        assertEquals(d.inventory,vehicle);
    }
    @org.junit.jupiter.api.Test
    public void getVehiclesByPrice_IF_The_Price_Is_Not_With_IN_Range() {
        //arrange
        Dealership d = new Dealership("lewisville Honda", "45454 fit st","454646548");
        Vehicle v = new Vehicle(1,2012,"honda","civic","sedan","silver",78979879,15000);
        d.inventory.add(v);
        //act
        ArrayList<Vehicle> vehicle = d.getVehiclesByPrice(19000,20000);
        //assert
        assertNotEquals(d.inventory,vehicle);
    }

    @org.junit.jupiter.api.Test
    void getVehiclesByMakeModel_If_It_Matches() {
        //arrange
        Dealership d = new Dealership("lewisville Honda", "45454 fit st","454646548");
        Vehicle v = new Vehicle(1,2012,"honda","civic","sedan","silver",78979879,15000);
        d.inventory.add(v);
        //act
        ArrayList<Vehicle> vehicle = d.getVehiclesByMakeModel("honda","civic");
        //assert
        assertEquals(d.inventory,vehicle);
    }
    @org.junit.jupiter.api.Test
    void getVehiclesByMakeModel_If_It_DoNot_Matches() {
        //arrange
        Dealership d = new Dealership("lewisville Honda", "45454 fit st","454646548");
        Vehicle v = new Vehicle(1,2012,"honda","civic","sedan","silver",78979879,15000);
        d.inventory.add(v);
        //act
        ArrayList<Vehicle> vehicle = d.getVehiclesByMakeModel("Toyota","camry");
        //assert
        assertNotEquals(d.inventory,vehicle);
    }
    @org.junit.jupiter.api.Test
    void getVehiclesByYear_If_It_Match() {
        //arrange
        Dealership d = new Dealership("lewisville Honda", "45454 fit st","454646548");
        Vehicle v = new Vehicle(1,2012,"honda","civic","sedan","silver",78979879,15000);
        d.inventory.add(v);
        //act
        ArrayList<Vehicle> vehicle = d.getVehiclesByYear(2012,2015);
        //assert
        assertEquals(d.inventory,vehicle);
    }
    @org.junit.jupiter.api.Test
    void getVehiclesByYear_If_It_DoNot_Match() {
        //arrange
        Dealership d = new Dealership("lewisville Honda", "45454 fit st","454646548");
        Vehicle v = new Vehicle(1,2012,"honda","civic","sedan","silver",78979879,15000);
        d.inventory.add(v);
        //act
        ArrayList<Vehicle> vehicle = d.getVehiclesByYear(2014,2015);
        //assert
        assertNotEquals(d.inventory,vehicle);
    }
    @org.junit.jupiter.api.Test
    void getVehiclesByColorIf_It_Match() {
        //arrange
        Dealership d = new Dealership("lewisville Honda", "45454 fit st","454646548");
        Vehicle v = new Vehicle(1,2012,"honda","civic","sedan","silver",78979879,15000);
        d.inventory.add(v);
        //act
        ArrayList<Vehicle> vehicle = d.getVehiclesByColor("silver");
        //assert
        assertEquals(d.inventory,vehicle);
    }
    @org.junit.jupiter.api.Test
    void getVehiclesByColorIf_It_DoNot_Match() {
        //arrange
        Dealership d = new Dealership("lewisville Honda", "45454 fit st","454646548");
        Vehicle v = new Vehicle(1,2012,"honda","civic","sedan","silver",78979879,15000);
        d.inventory.add(v);
        //act
        ArrayList<Vehicle> vehicle = d.getVehiclesByColor("red");
        //assert
        assertNotEquals(d.inventory,vehicle);
    }
    @org.junit.jupiter.api.Test
    void getVehiclesByMileageIf_It_Match() {
        //arrange
        Dealership d = new Dealership("lewisville Honda", "45454 fit st","454646548");
        Vehicle v = new Vehicle(1,2012,"honda","civic","sedan","silver",5000,15000);
        d.inventory.add(v);
        //act
        ArrayList<Vehicle> vehicle = d.getVehiclesByMileage(5000,15000);
        //assert
        assertEquals(d.inventory,vehicle);
    }
    @org.junit.jupiter.api.Test
    void getVehiclesByMileageIf_It_DoNot_Match() {
        //arrange
        Dealership d = new Dealership("lewisville Honda", "45454 fit st","454646548");
        Vehicle v = new Vehicle(1,2012,"honda","civic","sedan","silver",78979879,15000);
        d.inventory.add(v);
        //act
        ArrayList<Vehicle> vehicle = d.getVehiclesByMileage(5000,1500);
        //assert
        assertNotEquals(d.inventory,vehicle);
    }
    @Test
    void getVehiclesByTypeIf_It_Match() {
        //arrange
        Dealership d = new Dealership("lewisville Honda", "45454 fit st","454646548");
        Vehicle v = new Vehicle(1,2012,"honda","civic","sedan","silver",78979879,15000);
        d.inventory.add(v);
        //act
        ArrayList<Vehicle> vehicle = d.getVehiclesByType("sedan");
        //assert
        assertEquals(d.inventory,vehicle);
    }

    @org.junit.jupiter.api.Test
    void getVehiclesByTypeIf_It_DoNot_Match() {
        //arrange
        Dealership d = new Dealership("lewisville Honda", "45454 fit st","454646548");
        Vehicle v = new Vehicle(1,2012,"honda","civic","sedan","silver",78979879,15000);
        d.inventory.add(v);
        //act
        ArrayList<Vehicle> vehicle = d.getVehiclesByType("suv");
        //assert
        assertNotEquals(d.inventory,vehicle);
    }

    @org.junit.jupiter.api.Test
    void getAllVehicles() {
        Dealership d = new Dealership("lewisville Honda", "45454 fit st","454646548");
        Vehicle v = new Vehicle(1,2012,"honda","civic","sedan","silver",78979879,15000);
        d.inventory.add(v);
        d.getAllVehicles(d.inventory);
        //act
        ArrayList<Vehicle> vehicle = new ArrayList<>();
        vehicle.add(v);
        d.getAllVehicles(vehicle);
        String output = vehicle.toString().trim();
        String expected = d.inventory.toString().trim();
        //assert
        assertEquals(expected,output);
    }

    @org.junit.jupiter.api.Test
    void addVehicle_Is_Correct() {
        Dealership d = new Dealership("lewisville Honda", "45454 fit st","454646548");
        Vehicle v = new Vehicle(1,2012,"honda","civic","sedan","silver",78979879,15000);
        //act
       d.addVehicle(v);
       ArrayList<Vehicle> vehicle = new ArrayList<>();
       vehicle.add(v);
        //assert
       assertEquals(vehicle,d.inventory);
    }
    @org.junit.jupiter.api.Test
    void addVehicle_Is_Not_Correct() {
        Dealership d = new Dealership("lewisville Honda", "45454 fit st","454646548");
        Vehicle v = new Vehicle(1,2012,"honda","civic","sedan","silver",78979879,15000);
        //act
        ArrayList<Vehicle> vehicle = new ArrayList<>();
        vehicle.add(v);
        //assert
        assertNotEquals(vehicle,d.inventory);
    }

    @org.junit.jupiter.api.Test
    void removeVehicle_Is_Correct() {
        Dealership d = new Dealership("lewisville Honda", "45454 fit st","454646548");
        Vehicle v = new Vehicle(1,2012,"honda","civic","sedan","silver",78979879,15000);
        //act
        d.removeVehicle(v);
        ArrayList<Vehicle> vehicle = new ArrayList<>();
        vehicle.remove(v);
        //assert
        assertEquals(vehicle,d.inventory);
    }
}
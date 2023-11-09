package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalesContractTest {
    @Test
    public void salesContract_Monthly_Payment_under_Ten_Thousand(){
        Vehicle vehicle = new Vehicle(1,2021,"honda","civic","sedan","silver",4564,9000);
        SalesContract sc = new SalesContract("2012/12/12","Bimal","sdfsdfa",vehicle,true);

        double monthlyPayment = sc.getMonthlyPayment();

        assertEquals(433.01693678515494,monthlyPayment);
    }

}
package org.example;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LeaseContractTest {
    @Test
    public void getMonthlyPayment_Checking_The_Value(){
        Vehicle vehicle = new Vehicle(1,2021,"honda","civic","sedan","silver",4564,11000);
      LeaseContract lc = new LeaseContract(LocalDate.now(),"Bimal","sdfsdfa",vehicle);

        double monthlyPayment = lc.getMonthlyPayment();

        assertEquals(152.77777777777777,monthlyPayment);

    }

}
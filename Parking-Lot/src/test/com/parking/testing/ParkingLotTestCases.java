/**
 * Alipay.com Inc.
 * <p>
 * Copyright (c) 2004-2017 All Rights Reserved.
 */

package com.parking.testing;

import com.parking.system.impl.ParkingLot;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**

 * @author Prateek.Rustagi

 * @version $Id: ParkingLotTestCases.java, v 0.1 2017-12-16 10:36 AM Prateek.Rustagi Exp $$

 */
public class ParkingLotTestCases {

        private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        private ParkingLot parkingLot;

        @Before
        public void setUpStreams() {
            parkingLot = new ParkingLot();
            System.setOut(new PrintStream(outContent));
        }

        @After
        public void cleanUpStreams() {
            System.setOut(null);
        }
        @Test
        public void createParkingLot() throws Exception {
            parkingLot.createParkingLot("6");
            assertEquals(6, parkingLot.getMAX_SIZE());
            assertEquals(6, parkingLot.getAvailableSlotList().size());
            assertTrue("createdparkinglotwith6slots".equalsIgnoreCase(outContent.toString().trim().replace(" ", "")));
        }

        // Park a car and occupy slot Test case
        @Test
        public void park() throws Exception {
            parkingLot.park("KA-01-HH-1234", "White");
            parkingLot.park("KA-01-HH-9999", "White");
            assertEquals("Sorry,parkinglotisnotcreated\n" +
                    "\n" +
                    "Sorry,parkinglotisnotcreated", outContent.toString().trim().replace(" ", ""));
            parkingLot.createParkingLot("6");
            parkingLot.park("KA-01-HH-1234", "White");
            parkingLot.park("KA-01-HH-9999", "White");
            assertEquals(4, parkingLot.getAvailableSlotList().size());
        }

        // Parking slot leave test case
        @Test
        public void leave() throws Exception {
            parkingLot.leave("2");
            assertEquals("Sorry,parkinglotisnotcreated", outContent.toString().trim().replace(" ", ""));
            parkingLot.createParkingLot("6");
            parkingLot.park("KA-01-HH-1234", "White");
            parkingLot.park("KA-01-HH-9999", "White");
            parkingLot.leave("4");
            assertEquals("Sorry,parkinglotisnotcreated\n" +
                    "\n" +
                    "Createdparkinglotwith6slots\n" +
                    "\n" +
                    "Allocatedslotnumber:1\n" +
                    "\n" +
                    "Allocatedslotnumber:2\n" +
                    "\n" +
                    "Slotnumber4isalreadyempty", outContent.toString().trim().replace(" ", ""));
        }

        // Parking lot status test case
        @Test
        public void status() throws Exception {
            parkingLot.status();
            assertEquals("Sorry,parkinglotisnotcreated", outContent.toString().trim().replace(" ", ""));
            parkingLot.createParkingLot("6");
            parkingLot.park("KA-01-HH-1234", "White");
            parkingLot.park("KA-01-HH-9999", "White");
            parkingLot.status();
            assertEquals("Sorry,parkinglotisnotcreated\n" +
                    "\n" +
                    "Createdparkinglotwith6slots\n" +
                    "\n" +
                    "Allocatedslotnumber:1\n" +
                    "\n" +
                    "Allocatedslotnumber:2\n" +
                    "\n" +
                    "SlotNo.\tRegistrationNo.\tColor\n" +
                    "1\tKA-01-HH-1234\tWhite\n" +
                    "2\tKA-01-HH-9999\tWhite", outContent.toString().trim().replace(" ", ""));
        }

        // Retrieve registered plate number corresponding to car color test case
        @Test
        public void getRegistrationNumbersFromColor() throws Exception {
            parkingLot.getRegistrationNumbersFromColor("White");
            assertEquals("Sorry,parkinglotisnotcreated", outContent.toString().trim().replace(" ", ""));
            parkingLot.createParkingLot("6");
            parkingLot.park("KA-01-HH-1234", "White");
            parkingLot.park("KA-01-HH-9999", "White");
            parkingLot.getRegistrationNumbersFromColor("White");
            assertEquals("Sorry,parkinglotisnotcreated\n" +
                    "\n" +
                    "Createdparkinglotwith6slots\n" +
                    "\n" +
                    "Allocatedslotnumber:1\n" +
                    "\n" +
                    "Allocatedslotnumber:2\n" +
                    "\n" +
                    "\n" +
                    "KA-01-HH-1234,KA-01-HH-9999", outContent.toString().trim().replace(" ", ""));
            parkingLot.getRegistrationNumbersFromColor("Red");
            assertEquals("Sorry,parkinglotisnotcreated\n" +
                    "\n" +
                    "Createdparkinglotwith6slots\n" +
                    "\n" +
                    "Allocatedslotnumber:1\n" +
                    "\n" +
                    "Allocatedslotnumber:2\n" +
                    "\n" +
                    "\n" +
                    "KA-01-HH-1234,KA-01-HH-9999Notfound", outContent.toString().trim().replace(" ", ""));
        }

        // Retrieve slot number corresponding to car color test case
        @Test
        public void getSlotNumbersFromColor() throws Exception {
            parkingLot.getSlotNumbersFromColor("White");
            assertEquals("Sorry,parkinglotisnotcreated", outContent.toString().trim().replace(" ", ""));
            parkingLot.createParkingLot("6");
            parkingLot.park("KA-01-HH-1234", "White");
            parkingLot.park("KA-01-HH-9999", "White");
            parkingLot.getSlotNumbersFromColor("White");
            assertEquals("Sorry,parkinglotisnotcreated\n" +
                    "\n" +
                    "Createdparkinglotwith6slots\n" +
                    "\n" +
                    "Allocatedslotnumber:1\n" +
                    "\n" +
                    "Allocatedslotnumber:2\n" +
                    "\n" +
                    "\n" +
                    "1,2", outContent.toString().trim().replace(" ", ""));
            parkingLot.getSlotNumbersFromColor("Red");
            assertEquals("Sorry,parkinglotisnotcreated\n" +
                    "\n" +
                    "Createdparkinglotwith6slots\n" +
                    "\n" +
                    "Allocatedslotnumber:1\n" +
                    "\n" +
                    "Allocatedslotnumber:2\n" +
                    "\n" +
                    "\n" +
                    "1,2\n" +
                    "Notfound", outContent.toString().trim().replace(" ", ""));
        }

        // Retrieve slot number corresponding to car registered plate number test case
        @Test
        public void getSlotNumberFromRegNo() throws Exception {
            parkingLot.getSlotNumberFromRegNo("KA-01-HH-1234");
            assertEquals("Sorry,parkinglotisnotcreated", outContent.toString().trim().replace(" ", ""));
            parkingLot.createParkingLot("6");
            parkingLot.park("KA-01-HH-1234", "White");
            parkingLot.park("KA-01-HH-9999", "White");
            parkingLot.getSlotNumberFromRegNo("KA-01-HH-1234");
            assertEquals("Sorry,parkinglotisnotcreated\n" +
                    "\n" +
                    "Createdparkinglotwith6slots\n" +
                    "\n" +
                    "Allocatedslotnumber:1\n" +
                    "\n" +
                    "Allocatedslotnumber:2\n" +
                    "\n" +
                    "1", outContent.toString().trim().replace(" ", ""));
            parkingLot.getSlotNumberFromRegNo("KA-01-HH-9999");
            assertEquals("Sorry,parkinglotisnotcreated\n" +
                    "\n" +
                    "Createdparkinglotwith6slots\n" +
                    "\n" +
                    "Allocatedslotnumber:1\n" +
                    "\n" +
                    "Allocatedslotnumber:2\n" +
                    "\n" +
                    "1\n" +
                    "2", outContent.toString().trim().replace(" ", ""));
            parkingLot.leave("1");
            parkingLot.getSlotNumberFromRegNo("KA-01-HH-1234");
            assertEquals("Sorry,parkinglotisnotcreated\n" +
                    "\n" +
                    "Createdparkinglotwith6slots\n" +
                    "\n" +
                    "Allocatedslotnumber:1\n" +
                    "\n" +
                    "Allocatedslotnumber:2\n" +
                    "\n" +
                    "1\n" +
                    "2\n" +
                    "Slotnumber1isfree\n" +
                    "\n" +
                    "Notfound", outContent.toString().trim().replace(" ", ""));
        }

}

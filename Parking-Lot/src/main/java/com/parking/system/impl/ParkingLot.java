/**
 * Alipay.com Inc.
 * <p>
 * Copyright (c) 2004-2017 All Rights Reserved.
 */

package com.parking.system.impl;

import com.parking.system.api.BaseParkingLot;
import com.parking.system.api.ParkingLotService;
import com.parking.system.constants.ParkingConstants;
import com.parking.system.entity.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**

 * @author Prateek.Rustagi

 * @version $Id: ParkingLot.java, v 0.1 2017-12-16 1:07 AM Prateek.Rustagi Exp $$

 */
public class ParkingLot extends BaseParkingLot implements ParkingLotService {

        /**
        * Function for creation of the parking slot
        *
        * @param slotCount Parking lot slot count
        * @return return type is void
        */
        public void createParkingLot(String slotCount) {
            try {
                this.MAX_SIZE = Integer.parseInt(slotCount);
            } catch (Exception e) {
                System.out.println(ParkingConstants.ErrorMessages.INVALID_LOT_COUNT);
                System.out.println();
            }
            initializeParkingLotStructures();
            for (int i=1; i<= this.MAX_SIZE; i++) {
                availableSlotList.add(i);
            }
            System.out.println("Created parking lot with " + slotCount + " slots");
            System.out.println();
        }

        /**
         * Function for performing initialization of
         * the structures used for parking lot system
         */
        public void initializeParkingLotStructures(){
            this.availableSlotList = new ArrayList<Integer>() {};
            this.slotCarMap = new HashMap<String, Car>();
            this.registereddNoSlotMap = new HashMap<String, String>();
            this.colorRegisteredNoMap = new HashMap<String, ArrayList<String>>();
        }

        /**
        * Function for parking a car by occupying a slot in parking lot
        *
        * @param registeredNo car's registered plate number ,
         * @param color car color
        * @return return type is void
        */
        public void park(String registeredNo, String color) {
            if (this.MAX_SIZE == 0) {
                System.out.println(ParkingConstants.ErrorMessages.PARKING_LOT_NOT_CREATED);
                System.out.println();
            } else if (this.slotCarMap.size() == this.MAX_SIZE) {
                System.out.println(ParkingConstants.ErrorMessages.PARKING_LOT_FULL);
                System.out.println();
            } else {
                Collections.sort(availableSlotList);
                String slot = availableSlotList.get(0).toString();
                Car car = new Car(registeredNo, color);
                this.slotCarMap.put(slot, car);
                this.registereddNoSlotMap.put(registeredNo, slot);
                if (this.colorRegisteredNoMap.containsKey(color)) {
                    ArrayList<String> regNoList = this.colorRegisteredNoMap.get(color);
                    this.colorRegisteredNoMap.remove(color);
                    regNoList.add(registeredNo);
                    this.colorRegisteredNoMap.put(color, regNoList);
                } else {
                    ArrayList<String> regNoList = new ArrayList<String>();
                    regNoList.add(registeredNo);
                    this.colorRegisteredNoMap.put(color, regNoList);
                }
                System.out.println("Allocated slot number: " + slot);
                System.out.println();
                availableSlotList.remove(0);
            }
        }

        /**
        * Function for freeing up a car's parking lot from parking system
        *
        * @param slotNo car slot number
        * @return return type is void
        */
        public void leave(String slotNo) {
            if (this.MAX_SIZE == 0) {
                System.out.println(ParkingConstants.ErrorMessages.PARKING_LOT_NOT_CREATED);
                System.out.println();
            } else if (this.slotCarMap.size() > 0) {
                Car carToLeave = this.slotCarMap.get(slotNo);
                if (carToLeave != null) {
                    this.slotCarMap.remove(slotNo);
                    this.registereddNoSlotMap.remove(carToLeave.getRegisteredNumber());
                    ArrayList<String> regNoList = this.colorRegisteredNoMap.get(carToLeave.getColor());
                    if (regNoList.contains(carToLeave.getRegisteredNumber())) {
                        regNoList.remove(carToLeave.getRegisteredNumber());
                    }
                    // Add the sLot No to the available slots list.
                    this.availableSlotList.add(Integer.parseInt(slotNo));
                    System.out.println("Slot number " + slotNo + " is free");
                    System.out.println();
                } else {
                    System.out.println("Slot number " + slotNo + " is already empty");
                    System.out.println();
                }
            } else {
                System.out.println(ParkingConstants.ErrorMessages.PARKING_LOT_EMPTY);
                System.out.println();
            }
        }

        /**
        * Function to know the current status of the parking slot
        *
        * @return return type is void
        */
        public void status() {
            if (this.MAX_SIZE == 0) {
                System.out.println(ParkingConstants.ErrorMessages.PARKING_LOT_NOT_CREATED);
                System.out.println();
            } else if (this.slotCarMap.size() > 0) {
                // Print the current status.
                System.out.println("Slot No.\tRegistration No.\tColor");
                Car car;
                for (int i = 1; i <= this.MAX_SIZE; i++) {
                    String key = Integer.toString(i);
                    if (this.slotCarMap.containsKey(key)) {
                        car = this.slotCarMap.get(key);
                        System.out.println(i + "\t" + car.getRegisteredNumber() + "\t" + car.getColor());
                    }
                }
                System.out.println();
            } else {
                System.out.println(ParkingConstants.ErrorMessages.PARKING_LOT_EMPTY);
                System.out.println();
            }
        }

        /**
        * Function for getting the list of car registration numbers with given color
        *
        * @param color car color
        * @return return type is void
        */
        public void getRegistrationNumbersFromColor(String color) {
            if (this.MAX_SIZE == 0) {
                System.out.println(ParkingConstants.ErrorMessages.PARKING_LOT_NOT_CREATED);
                System.out.println();
            } else if (this.colorRegisteredNoMap.containsKey(color)) {
                ArrayList<String> regNoList = this.colorRegisteredNoMap.get(color);
                System.out.println();
                for (int i=0; i < regNoList.size(); i++) {
                    if (!(i==regNoList.size() - 1)){
                        System.out.print(regNoList.get(i) + ",");
                    } else {
                        System.out.print(regNoList.get(i));
                    }
                }
            } else {
                System.out.println(ParkingConstants.ErrorMessages.REGISTERED_NO_NOT_FOUND_FOR_COLOR + color);
                System.out.println();
            }
        }


        /**
        * Function for getting the list of allocated slot numbers against given color
        *
        * @param color car color
        * @return return type is void
        */
        public void getSlotNumbersFromColor(String color) {
            if (this.MAX_SIZE == 0) {
                System.out.println(ParkingConstants.ErrorMessages.PARKING_LOT_NOT_CREATED);
                System.out.println();
            } else if (this.colorRegisteredNoMap.containsKey(color)) {
                ArrayList<String> regNoList = this.colorRegisteredNoMap.get(color);
                ArrayList<Integer> slotList = new ArrayList<Integer>();
                System.out.println();
                for (int i=0; i < regNoList.size(); i++) {
                    slotList.add(Integer.valueOf(this.registereddNoSlotMap.get(regNoList.get(i))));
                }
                Collections.sort(slotList);
                for (int j=0; j < slotList.size(); j++) {
                    if (!(j == slotList.size() - 1)) {
                        System.out.print(slotList.get(j) + ",");
                    } else {
                        System.out.print(slotList.get(j));
                    }
                }
                System.out.println();
            } else {
                System.out.println(ParkingConstants.ErrorMessages.SLOT_NUMBER_NOT_FOUND_FOR_COLOR + color);
                System.out.println();
            }
        }

        /**
        * Function for getting the list of allocated slot numbers against car registered number
        *
        * @param registeredNo car registered plate number
        * @return return type is void
        */
        public void getSlotNumberFromRegNo(String registeredNo) {
            if (this.MAX_SIZE == 0) {
                System.out.println(ParkingConstants.ErrorMessages.PARKING_LOT_NOT_CREATED);
                System.out.println();
            } else if (this.registereddNoSlotMap.containsKey(registeredNo)) {
                System.out.println(this.registereddNoSlotMap.get(registeredNo));
            } else {
                System.out.println(ParkingConstants.ErrorMessages.SLOT_NUMBER_NOT_FOUND_FOR_REGISTERED_NO + registeredNo);
                System.out.println();
            }
        }
    }

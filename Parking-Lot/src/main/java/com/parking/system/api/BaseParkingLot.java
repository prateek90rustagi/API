/**
 * Alipay.com Inc.
 * <p>
 * Copyright (c) 2004-2017 All Rights Reserved.
 */

package com.parking.system.api;

import com.parking.system.entity.Car;

import java.util.ArrayList;
import java.util.Map;

/**

 * @author Prateek.Rustagi

 * @version $Id: BaseParkingLot.java, v 0.1 2017-12-16 10:47 AM Prateek.Rustagi Exp $$

 */
public abstract class BaseParkingLot {


    // Initial size of parking slot
    protected int MAX_SIZE = 0;
    // List of all Available slots
    protected ArrayList<Integer> availableSlotList;
    // Map of Slots and Car
    protected Map<String, Car> slotCarMap;
    // Map of RegisteredNo and Slot
    protected Map<String, String> registereddNoSlotMap;
    // Map of Color and List of RegisteredNo
    protected Map<String, ArrayList<String>> colorRegisteredNoMap;

    /**
     * Getter method for property MAX_SIZE.
     *
     * @return property value of MAX_SIZE
     */
    public int getMAX_SIZE() {
        return MAX_SIZE;
    }

    /**
     * Setter method for property MAX_SIZE.
     *
     * @param MAX_SIZE value to be assigned to property MAX_SIZE
     */
    public void setMAX_SIZE(int MAX_SIZE) {
        this.MAX_SIZE = MAX_SIZE;
    }

    /**
     * Getter method for property availableSlotList.
     *
     * @return property value of availableSlotList
     */
    public ArrayList<Integer> getAvailableSlotList() {
        return availableSlotList;
    }

    /**
     * Setter method for property availableSlotList.
     *
     * @param availableSlotList value to be assigned to property availableSlotList
     */
    public void setAvailableSlotList(ArrayList<Integer> availableSlotList) {
        this.availableSlotList = availableSlotList;
    }

    /**
     * Getter method for property slotCarMap.
     *
     * @return property value of slotCarMap
     */
    public Map<String, Car> getSlotCarMap() {
        return slotCarMap;
    }

    /**
     * Setter method for property slotCarMap.
     *
     * @param slotCarMap value to be assigned to property slotCarMap
     */
    public void setSlotCarMap(Map<String, Car> slotCarMap) {
        this.slotCarMap = slotCarMap;
    }

    /**
     * Getter method for property registereddNoSlotMap.
     *
     * @return property value of registereddNoSlotMap
     */
    public Map<String, String> getRegistereddNoSlotMap() {
        return registereddNoSlotMap;
    }

    /**
     * Setter method for property registereddNoSlotMap.
     *
     * @param registereddNoSlotMap value to be assigned to property registereddNoSlotMap
     */
    public void setRegistereddNoSlotMap(Map<String, String> registereddNoSlotMap) {
        this.registereddNoSlotMap = registereddNoSlotMap;
    }

    /**
     * Getter method for property colorRegisteredNoMap.
     *
     * @return property value of colorRegisteredNoMap
     */
    public Map<String, ArrayList<String>> getColorRegisteredNoMap() {
        return colorRegisteredNoMap;
    }

    /**
     * Setter method for property colorRegisteredNoMap.
     *
     * @param colorRegisteredNoMap value to be assigned to property colorRegisteredNoMap
     */
    public void setColorRegisteredNoMap(Map<String, ArrayList<String>> colorRegisteredNoMap) {
        this.colorRegisteredNoMap = colorRegisteredNoMap;
    }
}

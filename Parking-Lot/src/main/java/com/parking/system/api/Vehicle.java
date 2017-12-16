/**
 * Alipay.com Inc.
 * <p>
 * Copyright (c) 2004-2017 All Rights Reserved.
 */

package com.parking.system.api;

/**

 * @author Prateek.Rustagi

 * @version $Id: Vehicle.java, v 0.1 2017-12-16 10:37 AM Prateek.Rustagi Exp $$

 */
public abstract class Vehicle {

    // Registered plate number of the vehicle
    protected String registeredNumber;

    // Color of the vehicle
    protected String color;

    /**
     * Getter method for property registeredNumber.
     *
     * @return property value of registeredNumber
     */
    public String getRegisteredNumber() {
        return registeredNumber;
    }

    /**
     * Setter method for property registeredNumber.
     *
     * @param registeredNumber value to be assigned to property registeredNumber
     */
    public void setRegisteredNumber(String registeredNumber) {
        this.registeredNumber = registeredNumber;
    }

    /**
     * Getter method for property color.
     *
     * @return property value of color
     */
    public String getColor() {
        return color;
    }

    /**
     * Setter method for property color.
     *
     * @param color value to be assigned to property color
     */
    public void setColor(String color) {
        this.color = color;
    }

}

/**
 * Alipay.com Inc.
 * <p>
 * Copyright (c) 2004-2017 All Rights Reserved.
 */

package com.parking.system.entity;

import com.parking.system.api.Vehicle;

/**

 * @author Prateek.Rustagi

 * @version $Id: Car.java, v 0.1 2017-12-16 2:09 AM Prateek.Rustagi Exp $$

 */
public class Car extends Vehicle{

    public Car(String registeredNumber, String color) {
        this.registeredNumber = registeredNumber;
        this.color = color;
    }

}

/**
 * Alipay.com Inc.
 * <p>
 * Copyright (c) 2004-2017 All Rights Reserved.
 */

package com.parking.system.api;

/**

 * @author Prateek.Rustagi

 * @version $Id: ParkingLotService.java, v 0.1 2017-12-16 1:06 AM Prateek.Rustagi Exp $$

 */
public interface ParkingLotService {

    /**
     * Create parking lot system with slot count
     *
     * @param slotCount
     * @return void
     */
    void createParkingLot(String slotCount);

    /**
     * Park a car with given registeredNo and color
     *
     * @param registeredNo
     * @param color
     * @return void
     */
    void park(String registeredNo, String color);

    /**
     * Car at given slot number leaves the parking lot
     *
     * @param slotNo
     * @return void
     */
    void leave(String slotNo);

    /**
     * Status of parking lot system at given instance
     *
     * @param
     * @return void
     */
    void status();

    /**
     * Retreives the list of all registration numbers of cars with a given colors
     *
     * @param color
     * @return void
     */
    void getRegistrationNumbersFromColor(String color);

    /**
     * Retreives the list of all slot numbers where cars with given color are parked
     *
     * @param color
     * @return void
     */
    void getSlotNumbersFromColor(String color);

    /**
     * Retreives the list of all slot numbers with given car's registered plate number
     *
     * @param registeredNo
     * @return void
     */
    void getSlotNumberFromRegNo(String registeredNo);

}

/**
 * Alipay.com Inc.
 * <p>
 * Copyright (c) 2004-2017 All Rights Reserved.
 */

package com.parking.system.constants;

/**

 * @author Prateek.Rustagi

 * @version $Id: ParkingConstants.java, v 0.1 2017-12-16 1:06 AM Prateek.Rustagi Exp $$

 */
public interface ParkingConstants {

    interface ErrorMessages{

        String INVALID_LOT_COUNT = "Invalid lot count ";

        String PARKING_LOT_NOT_CREATED = "Sorry, parking lot is not created";

        String PARKING_LOT_FULL = "Sorry, parking lot is full";

        String PARKING_LOT_EMPTY = "Parking lot is empty";

        String REGISTERED_NO_NOT_FOUND_FOR_COLOR = "Registered Plate number Not found with given color ";

        String SLOT_NUMBER_NOT_FOUND_FOR_COLOR = "Slot Number not found for car's with color ";

        String SLOT_NUMBER_NOT_FOUND_FOR_REGISTERED_NO = "Slot number Not found for car with given registered number ";
    }

}

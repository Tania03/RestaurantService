package com.swiggy.battleship.ship;

import com.swiggy.battleship.models.Constants;

import java.util.UUID;

public class CarrierShip extends Ship {

    public CarrierShip() {
        setId(UUID.randomUUID().toString());
        setLength(Constants.CARRIER_LENGTH);
        setShipType(ShipType.Carrier);
        setStatus(ShipStatus.Afloat);
    }
}

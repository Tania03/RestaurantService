package com.swiggy.battleship.ship;

import com.swiggy.battleship.models.Constants;

import java.util.UUID;

public class CruiserShip extends Ship {

    public CruiserShip() {
        setId(UUID.randomUUID().toString());
        setLength(Constants.CRUISER_LENGTH);
        setShipType(ShipType.Cruiser);
        setStatus(ShipStatus.Afloat);
    }

}

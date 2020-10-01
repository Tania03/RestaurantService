package com.swiggy.battleship.ship;

import com.swiggy.battleship.models.Constants;

import java.util.UUID;

public class SubmarineShip extends Ship {

    public SubmarineShip() {
        setId(UUID.randomUUID().toString());
        setLength(Constants.SUBMARINE_LENGTH);
        setShipType(ShipType.Submarine);
        setStatus(ShipStatus.Afloat);
    }
}

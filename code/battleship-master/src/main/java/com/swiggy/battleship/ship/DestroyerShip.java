package com.swiggy.battleship.ship;

import com.swiggy.battleship.models.Constants;

import java.util.UUID;


public class DestroyerShip extends Ship {

    public DestroyerShip() {
        setId(UUID.randomUUID().toString());
        setLength(Constants.DESTROYER_LENGTH);
        setShipType(ShipType.Destroyer);
        setStatus(ShipStatus.Afloat);
    }
}


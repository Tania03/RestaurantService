package com.swiggy.battleship.ship;

import com.swiggy.battleship.models.Constants;

import java.util.UUID;

public class BattleShip extends Ship {

    public BattleShip() {
        setId(UUID.randomUUID().toString());
        setLength(Constants.BATTLESHIP_LENGTH);
        setShipType(ShipType.Battleship);
        setStatus(ShipStatus.Afloat);
    }
}

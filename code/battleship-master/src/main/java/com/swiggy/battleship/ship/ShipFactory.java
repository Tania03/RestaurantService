package com.swiggy.battleship.ship;

public class ShipFactory {

    //factory method for getting ship
    public static Ship createShip(ShipType shipType) {

        switch (shipType) {
            case Carrier:
                return new CarrierShip();
            case Destroyer:
                return new DestroyerShip();
            case Cruiser:
                return new CruiserShip();
            case Submarine:
                return new SubmarineShip();
            case Battleship:
                return new BattleShip();
            default:
                return null;
        }
    }
}

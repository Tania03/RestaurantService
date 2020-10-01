package com.swiggy.battleship;

import com.swiggy.battleship.ship.*;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public class ShipFactoryTest {

    @Test
    public void testShipFactory() {
        Ship shipCarrier = ShipFactory.createShip(ShipType.Carrier);
        Ship shipSubmarine = ShipFactory.createShip(ShipType.Submarine);
        Ship shipBattleship = ShipFactory.createShip(ShipType.Battleship);
        Ship shipCruiser = ShipFactory.createShip(ShipType.Cruiser);
        Ship shipDestroyer = ShipFactory.createShip(ShipType.Destroyer);


        assertThat(shipCarrier, instanceOf(CarrierShip.class));
        assertThat(shipSubmarine, instanceOf(SubmarineShip.class));
        assertThat(shipBattleship, instanceOf(BattleShip.class));
        assertThat(shipCruiser, instanceOf(CruiserShip.class));
        assertThat(shipDestroyer, instanceOf(DestroyerShip.class));
    }
}

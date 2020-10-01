package com.swiggy.battleship.ship;

import com.swiggy.battleship.board.Position;


public abstract class Ship {

    protected String id;
    protected ShipType shipType;
    protected int length;
    protected ShipStatus status;
    protected Position position;
    protected ShipOrientation orientation;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ShipType getShipType() {
        return shipType;
    }

    public void setShipType(ShipType shipType) {
        this.shipType = shipType;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public ShipStatus getStatus() {
        return status;
    }

    public void setStatus(ShipStatus status) {
        this.status = status;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public ShipOrientation getOrientation() {
        return orientation;
    }

    public void setOrientation(ShipOrientation orientation) {
        this.orientation = orientation;
    }
}

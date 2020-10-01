package com.swiggy.battleship.board;

public enum BoardTypeOcean {
    Ship {
        @Override
        public String toString() {
            return "S";
        }
    },
    ShipHit {
        @Override
        public String toString() {
            return "X";
        }
    },
    Nil {
        @Override
        public String toString() {
            return "-";
        }
    }
}
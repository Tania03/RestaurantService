package com.swiggy.battleship.board;

public enum BoardTypeTarget {
    Hit {
        @Override
        public String toString() {
            return "H";
        }
    },
    Miss {
        @Override
        public String toString() {
            return "M";
        }
    },
    Unknown {
        @Override
        public String toString() {
            return "-";
        }
    }
}
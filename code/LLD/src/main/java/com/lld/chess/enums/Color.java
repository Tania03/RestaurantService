package com.lld.chess.enums;

/**
 * @author tania.gupta
 * @date 16/08/20
 */
public enum Color {

    BLACK("Black"), WHITE("White");

    String color;

    Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}

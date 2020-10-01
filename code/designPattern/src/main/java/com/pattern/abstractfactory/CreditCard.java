package com.pattern.abstractfactory;

/**
 * @author tania.gupta
 * @date 02/06/20
 */
public abstract class CreditCard {

    protected int number;

    protected int cvv;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }
}

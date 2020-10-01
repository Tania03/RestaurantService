package com.pattern.abstractfactory;

/**
 * @author tania.gupta
 * @date 02/06/20
 */
public abstract class CreditCardFactory {

    public static CreditCardFactory getCreditCardFactory(int credits) {

        if (credits > 90)
            return new HDFCCreditCardFactory();
        else
            return new ICICICreditCardFactory();
    }

    public abstract CreditCard getCreditCard(CardType cardType);
}

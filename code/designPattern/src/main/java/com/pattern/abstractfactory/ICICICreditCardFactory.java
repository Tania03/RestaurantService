package com.pattern.abstractfactory;

/**
 * @author tania.gupta
 * @date 02/06/20
 */
public class ICICICreditCardFactory extends CreditCardFactory {

    @Override
    public CreditCard getCreditCard(CardType cardType) {
        switch (cardType) {
            case GOLD:
                return new ICICIGoldCreditCard();
            case PLATINUM:
                return new ICICIPlatinumCreditCard();
        }
        return null;
    }
}

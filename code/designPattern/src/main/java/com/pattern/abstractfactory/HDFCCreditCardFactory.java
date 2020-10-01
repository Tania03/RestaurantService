package com.pattern.abstractfactory;

/**
 * @author tania.gupta
 * @date 02/06/20
 */
public class HDFCCreditCardFactory extends CreditCardFactory {

    @Override
    public CreditCard getCreditCard(CardType cardType) {
        switch (cardType) {
            case GOLD:
                return new HDFCGoldCreditCard();
            case PLATINUM:
                return new HDFCPlatinumCreditCard();
        }
        return null;
    }
}

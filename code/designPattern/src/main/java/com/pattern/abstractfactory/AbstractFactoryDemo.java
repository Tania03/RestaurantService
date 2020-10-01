package com.pattern.abstractfactory;

/**
 * @author tania.gupta
 * @date 02/06/20
 */
public class AbstractFactoryDemo {

    public static void main(String[] args) {

        CreditCardFactory creditCardFactory = CreditCardFactory.getCreditCardFactory(100);

        CreditCard card = creditCardFactory.getCreditCard(CardType.GOLD);

        System.out.println(card.getClass());

        creditCardFactory = CreditCardFactory.getCreditCardFactory(80);

        card = creditCardFactory.getCreditCard(CardType.PLATINUM);

        System.out.println(card.getClass());

    }
}

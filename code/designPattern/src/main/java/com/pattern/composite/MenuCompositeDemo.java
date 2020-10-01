package com.pattern.composite;

/**
 * @author tania.gupta
 * @date 02/06/20
 */
public class MenuCompositeDemo {

    public static void main(String[] args) {

        Menu menu = new Menu("Main", "/menu");

        MenuItem menuItem = new MenuItem("SafetyItem", "/safetyItem");

        menu.add(menuItem);

        Menu claimsMenu = new Menu("Claims", "/claims");

        menu.add(claimsMenu);

        MenuItem personalClaimItem = new MenuItem("PersonalClaimItem", "/personalClaimItem");

        claimsMenu.add(personalClaimItem);

        System.out.println(menu.toSring());

    }
}

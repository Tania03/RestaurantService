package com.pattern.factory;

/**
 * @author tania.gupta
 * @date 02/06/20
 */
public class Shop extends Website {

    @Override
    public void createWebsite() {
        pages.add(new CartPage());
        pages.add(new ItemPage());
        pages.add(new SearchPage());
    }


}

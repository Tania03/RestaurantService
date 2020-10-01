package com.pattern.factory;

/**
 * @author tania.gupta
 * @date 02/06/20
 */
public class WebsiteFactoryDemo {

    public static void main(String[] args) {

        Website blog = WebsiteFactory.getWebsite(WebsiteType.BLOG);

        System.out.println(blog.getPages().toString());

        Website shop = WebsiteFactory.getWebsite(WebsiteType.SHOP);

        System.out.println(shop.getPages().toString());

    }
}

package com.pattern.prototype;

/**
 * @author tania.gupta
 * @date 02/06/20
 */
public class PrototypeDemo {

    public static void main(String[] args) {

        Registry registry = new Registry();
        registry.loadItems();


        Item item1 = registry.createItem(ItemType.MOVIE);

        System.out.println(item1.toString());

        Movie item2 = (Movie) registry.createItem(ItemType.MOVIE);
        item2.setTitle("Design Pattern");

        System.out.println(item2.toString());

    }
}

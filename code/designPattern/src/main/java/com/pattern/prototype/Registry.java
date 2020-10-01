package com.pattern.prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tania.gupta
 * @date 02/06/20
 */
public class Registry {

    Map<ItemType, Item> map = new HashMap<>();

    public Registry() {
        loadItems();
    }

    public Item createItem(ItemType type) {

        Item item = null;

        try {
            item = (Item) map.get(type).clone();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return item;

    }

    public void loadItems() {

        Movie movie = new Movie();
        movie.setDirector("ABC");
        movie.setPrice(1000d);
        movie.setTitle("Gang of Four");
        map.put(ItemType.MOVIE, movie);

        Book book = new Book();
        book.setAuthor("David");
        map.put(ItemType.BOOK, book);


    }

}

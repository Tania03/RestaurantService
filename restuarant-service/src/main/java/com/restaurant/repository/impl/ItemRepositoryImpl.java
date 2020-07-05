package com.restaurant.repository.impl;

import com.restaurant.repository.entity.Item;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tania.gupta
 * @date 28/06/20
 */
public class ItemRepositoryImpl implements com.restaurant.repository.ItemRepository {


    private Map<String, Item> items;

    @PostConstruct
    public void init(){

        items = new HashMap<>();

        items.put("1A", new Item("1A", "Burger"));
        items.put("2B", new Item("2B", "Noodles"));
        items.put("3C", new Item("3C", "Pasta"));
        items.put("4D" ,new Item("4D", "Pizza"));
        items.put("5E", new Item("5E", "French Fries"));

    }

    public String getItemNameForItemId(String itemId) {
        String result = null;

        if (items.containsKey(itemId)) {
            result = items.get(itemId).getItemName();
        }
        return result;
    }
}

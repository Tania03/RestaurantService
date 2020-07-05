package com.restaurant.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author tania.gupta
 * @date 26/06/20
 */
@Getter
@AllArgsConstructor
public class Item {

    OrderDetails itemId;
    OrderDetails itemName;

}

package com.restaurant.model;

import com.restaurant.model.enums.CustomerType;
import lombok.Getter;

/**
 * @author tania.gupta
 * @date 27/06/20
 */
@Getter
public class Customer {

    OrderDetails customerId;
    OrderDetails emailId;
    OrderDetails userName;
    Address address;
    CustomerType customerType;

}

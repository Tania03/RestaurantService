package com.restaurant.util;

import java.util.UUID;

/**
 * @author tania.gupta
 * @date 28/06/20
 */
public class CommonUtil {

    public static String generateNewUUID(){
        UUID uuid = UUID. randomUUID();
        return String.valueOf(uuid);
    }
}

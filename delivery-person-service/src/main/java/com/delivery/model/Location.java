package com.delivery.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author tania.gupta
 * @date 29/06/20
 */

@Getter
@Setter
@AllArgsConstructor
public class Location {

    private Double longitude;
    private Double latitude;

    public Location() {
    }
}

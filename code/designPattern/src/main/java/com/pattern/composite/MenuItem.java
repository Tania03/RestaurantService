package com.pattern.composite;

/**
 * @author tania.gupta
 * @date 02/06/20
 */
public class MenuItem extends MenuComponent {

    public MenuItem(String name, String url) {
        this.name = name;
        this.url = url;
    }

    @Override
    public String toSring() {
        return print(this);
    }
}

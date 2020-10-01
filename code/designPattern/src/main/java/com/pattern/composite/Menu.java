package com.pattern.composite;

import java.util.Iterator;

/**
 * @author tania.gupta
 * @date 02/06/20
 */
public class Menu extends MenuComponent {

    public Menu(String name, String url) {
        this.name = name;
        this.url = url;
    }

    @Override
    public MenuComponent add(MenuComponent menuComponent) {
        menuComponentList.add(menuComponent);
        return menuComponent;
    }

    @Override
    public MenuComponent remove(MenuComponent menuComponent) {
        menuComponentList.remove(menuComponent);
        return menuComponent;
    }

    @Override
    public String toSring() {
        StringBuilder builder = new StringBuilder();

        builder.append(print(this));

        Iterator<MenuComponent> iterator = menuComponentList.iterator();

        while (iterator.hasNext()) {
            MenuComponent menuComponent = iterator.next();
            builder.append(menuComponent.toSring());
        }
        return builder.toString();
    }
}

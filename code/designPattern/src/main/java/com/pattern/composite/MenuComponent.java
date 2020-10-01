package com.pattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tania.gupta
 * @date 02/06/20
 */
public abstract class MenuComponent {

    protected String name;
    protected String url;

    List<MenuComponent> menuComponentList = new ArrayList<>();

    public MenuComponent add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException("Feature not implemented at this level");
    }

    public MenuComponent remove(MenuComponent menuComponent) {
        throw new UnsupportedOperationException("Feature not implemented at this level");
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public abstract String toSring();

    String print(MenuComponent Component) {
        StringBuilder builder = new StringBuilder(name);
        builder.append(":");
        builder.append(url);
        builder.append("\n");

        return builder.toString();
    }
}

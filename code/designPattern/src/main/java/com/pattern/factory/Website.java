package com.pattern.factory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tania.gupta
 * @date 02/06/20
 */
public abstract class Website {

    protected List<Page> pages = new ArrayList<>();

    public List<Page> getPages() {
        return pages;
    }

    public Website() {
        createWebsite();
    }

    public abstract void createWebsite();
}

package com.pattern.prototype;

/**
 * @author tania.gupta
 * @date 02/06/20
 */
public abstract class Item implements Cloneable {

    protected String title;
    protected double price;
    protected String URL;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Item{");
        sb.append("title='").append(title).append('\'');
        sb.append(", price=").append(price);
        sb.append(", URL='").append(URL).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

package com.pattern.prototype;

/**
 * @author tania.gupta
 * @date 02/06/20
 */
public class Book extends Item {

    private String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("author='").append(author).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", price=").append(price);
        sb.append(", URL='").append(URL).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

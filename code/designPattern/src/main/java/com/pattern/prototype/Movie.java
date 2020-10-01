package com.pattern.prototype;

/**
 * @author tania.gupta
 * @date 02/06/20
 */
public class Movie extends Item {

    private String director;

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Movie{");
        sb.append("director='").append(director).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", price=").append(price);
        sb.append(", URL='").append(URL).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

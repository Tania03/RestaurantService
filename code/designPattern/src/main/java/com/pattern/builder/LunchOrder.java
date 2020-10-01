package com.pattern.builder;

/**
 * @author tania.gupta
 * @date 02/06/20
 */
public class LunchOrder {

    public static class Builder {

        private String bread;
        private String condiments;
        private String dressings;

        public Builder(String bread) {
            this.bread = bread;
        }

        public Builder condiments(String condiments) {
            this.condiments = condiments;
            return this;
        }

        public Builder dressings(String dressings) {
            this.dressings = dressings;
            return this;
        }


        public Builder both(String condiments, String dressings) {
            this.condiments = condiments;
            this.dressings = dressings;
            return this;
        }

        public LunchOrder build() {
            return new LunchOrder(this);
        }
    }

    private final String bread;
    private final String condiments;
    private final String dressings;
    public static Builder builder;

    public LunchOrder(Builder builder) {
        this.bread = builder.bread;
        this.condiments = builder.condiments;
        this.dressings = builder.dressings;
    }


    public String getBread() {
        return bread;
    }

    public String getCondiments() {
        return condiments;
    }

    public String getDressings() {
        return dressings;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LunchOrder{");
        sb.append("bread='").append(bread).append('\'');
        sb.append(", condiments='").append(condiments).append('\'');
        sb.append(", dressings='").append(dressings).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

package com.feliperuppel.attributesample;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Bike extends Product {

    private Bike() {
        super("Bike");
    }

    public static class Builder {
        private final List<Attribute<?>> attributes;

        public Builder() {
            attributes = new ArrayList<>();
        }

        public Builder addPrice(final BigDecimal price) {
            attributes.add(new Attribute<>("Price", price));
            return this;
        }

        public Builder addColor(final String color) {
            attributes.add(new Attribute<>("Color", color));
            return this;
        }

        public Builder addSize(final int size) {
            attributes.add(new Attribute<>("Size", size));
            return this;
        }

        public Bike build() {
            final Bike bike = new Bike();
            attributes.forEach(bike::addAttribute);
            return bike;
        }
    }


}

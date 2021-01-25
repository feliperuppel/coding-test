package com.feliperuppel.attributesample;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Table extends Product {

    private Table(final String tableType) {
        super(tableType);
    }

    public static class Builder {
        private final List<Attribute<?>> attributes;
        private final String tableType;

        public Builder(final String tableType) {
            this.tableType = tableType;
            attributes = new ArrayList<>();
        }

        public Builder addPrice(final BigDecimal price) {
            attributes.add(new Attribute<>("Price", price));
            return this;
        }

        public Builder addWidth(final int width) {
            attributes.add(new Attribute<>("Width", width));
            return this;
        }

        public Builder addDepth(final int depth) {
            attributes.add(new Attribute<>("Depth", depth));
            return this;
        }

        public Builder addHeight(final int height) {
            attributes.add(new Attribute<>("Height", height));
            return this;
        }

        public Table build() {
            final Table kt = new Table(tableType);
            attributes.forEach(kt::addAttribute);
            return kt;
        }
    }


}

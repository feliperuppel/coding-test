package com.feliperuppel.attributesample;

import java.util.ArrayList;
import java.util.List;

public class Product {

    private final String productName;
    private final List<Node> attributes;


    public Product(String productName) {
        this.productName = productName;
        attributes = new ArrayList<>();
    }

    public void addAttribute(Attribute<?> a) {
        attributes.add(new Node(a));
    }

    public void addNode(Node n) {
        attributes.add(n);
    }

    public String toPrettyString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\"").append(productName).append("\"");
        sb.append(" : {\n");
        attributes.forEach(n -> sb.append(n.toPrettyString("\t", 1)));
        sb.append("}");
        return sb.toString();
    }
}

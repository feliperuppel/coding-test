package com.feliperuppel.attributesample;

import java.util.Arrays;
import java.util.List;

public class Node {

    private Attribute<?> attribute;
    private String key;
    private List<Node> nodes;

    public Node(final Attribute<?> a) {
        this.attribute = a;
    }

    public Node(final String key, final Node... n) {
        this.key = key;
        this.nodes = Arrays.asList(n.clone());
    }

    public String toPrettyString(final String tabSeparator, final int tabCount) {
        StringBuilder tab = new StringBuilder();

        tab.append(String.valueOf(tabSeparator).repeat(Math.max(0, tabCount)));

        if (attribute != null) {
            return tab + attribute.toString();
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(tab);
            sb.append("\"").append(key).append("\"");
            sb.append(" : {\n");
            nodes.forEach(n -> sb.append(n.toPrettyString(tabSeparator, tabCount + 1)));
            sb.append(tab);
            sb.append("}\n");
            return sb.toString();
        }
    }
}

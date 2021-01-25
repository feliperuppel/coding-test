package com.feliperuppel.attributesample;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class TreeExampleApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TreeExampleApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println();

        Bike b = createBike();

        System.out.println("-----------------");
        System.out.println(b.toPrettyString());
        System.out.println("-----------------");

        Table kt = createTable();

        System.out.println("-----------------");
        System.out.println(kt.toPrettyString());
        System.out.println("-----------------");

        Product generic = createGenericProduct();

        System.out.println("-----------------");
        System.out.println(generic.toPrettyString());
        System.out.println("-----------------");

    }

    private Bike createBike() {
        return new Bike.Builder()
                .addColor("red")
                .addSize(24)
                .addPrice(BigDecimal.valueOf(146.99))
                .build();
    }

    private Table createTable() {
        return new Table.Builder("Kitchen Table")
                .addPrice(BigDecimal.valueOf(50.00))
                .addWidth(60)
                .addDepth(30)
                .addHeight(50)
                .build();
    }

    private Product createGenericProduct() {
        Product generic = new Product("Product Attributes");
        generic.addNode(new Node("Attributes 1",
                        new Node(new Attribute<>("Attribute 1", "Value 1")),
                        new Node(new Attribute<>("Attribute 2", "Value 2"))
                )
        );
        generic.addAttribute(new Attribute<>("Attribute 3", "Value 3"));
        generic.addNode(new Node("Attributes 2",
                        new Node("Attributes 3", new Node(
                                new Attribute<>("Attribute 4", "Value 4"))
                        ),
                        new Node(new Attribute<>("Attribute 5", "Value 5"))
                )
        );

        return generic;
    }
}

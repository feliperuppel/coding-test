package com.feliperuppel.fibonacci;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class FibonacciApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(FibonacciApplication.class, args);
    }

    @Override
    public void run(String... args) {

        final Scanner scan = new Scanner(System.in);
        final Fibonacci fibonacci = new Fibonacci();
        String input;
        System.out.println();
        System.out.println("------------------------------");
        System.out.println("Welcome to the fibonacci app");
        System.out.println("------------------------------");
        do {
            printMenu();
            input = scan.next();
            try {

                switch (input.toLowerCase()) {
                    case "exit":
                        scan.close();
                        break;
                    case "print":
                        System.out.println(fibonacci.toString());
                        break;
                    default:
                        try {
                            System.out.printf("%s%n   Fibonacci value is: %s %n", " *** ", fibonacci.getValue(Integer.parseInt(input)));
                            System.out.println(" *** ");
                        } catch (NumberFormatException e) {
                            throw new IllegalArgumentException("Invalid option");
                        }

                }
                System.out.println("---");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        } while (!"exit".equalsIgnoreCase(input));

    }

    private void printMenu() {
        System.out.println();
        System.out.println(" Please: ");
        System.out.println("  - Choose a positive integer to get its fibonacci value");
        System.out.println("  - Type 'print' to print current sequence");
        System.out.println("  - Type 'exit' to leave the program");
        System.out.println("---");
        System.out.print("Option: ");
    }
}

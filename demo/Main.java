package com.example.demo;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Prompt for user input to configure ticket pool size and vendor/customer settings
        Scanner scanner = new Scanner(System.in);

        // Get maximum ticket capacity and validate the input
        int maxTicketCapacity = getValidatedInput(scanner, "Enter the maximum ticket capacity for the pool: ", 1);

        // Get the total number of vendors
        int totalVendors = getValidatedInput(scanner, "Enter the total number of vendors: ", 1);

        // Get the total number of customers
        int totalCustomers = getValidatedInput(scanner, "Enter the total number of customers: ", 1);

        // Create a configuration object
        Configuration config = new Configuration(maxTicketCapacity, totalVendors, totalCustomers);

        // Save configuration settings in JSON format
        ConfigurationManager.saveConfigurationToJSON(config);

        // Save configuration settings in text format
        ConfigurationManager.saveConfigurationToTextFile(config);

        // Creating a ticket pool with the user-defined maximum capacity
        TicketPool ticketPool = new TicketPool(config.getMaxTicketCapacity());

        // Create vendor and customer threads based on user input
        Vendor[] vendors = new Vendor[config.getTotalVendors()];
        for (int i = 0; i < vendors.length; i++) {
            vendors[i] = new Vendor(20, 5, ticketPool);
            Thread vendorThread = new Thread(vendors[i], "Vendor ID-" + i);
            vendorThread.start();
        }

        Customer[] customers = new Customer[config.getTotalCustomers()];
        for (int i = 0; i < customers.length; i++) {
            customers[i] = new Customer(ticketPool, 6, 5);
            Thread customerThread = new Thread(customers[i], "Customer ID-" + i);
            customerThread.start();
        }
    }

    // Helper method to get validated user input
    private static int getValidatedInput(Scanner scanner, String prompt, int minValue) {
        int input = 0;
        boolean valid = false;
        while (!valid) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                if (input >= minValue) {
                    valid = true;
                } else {
                    System.out.println("Input must be greater than or equal to " + minValue);
                }
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // Consume the invalid input
            }
        }
        return input;
    }
}



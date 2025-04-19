package com.example.demo;

import com.google.gson.Gson;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConfigurationManager {

    // Save configuration to JSON file
    public static void saveConfigurationToJSON(Configuration config) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter("config.json")) {
            gson.toJson(config, writer);
            System.out.println("Configuration saved to JSON.");
        } catch (IOException e) {
            System.out.println("Error saving configuration to JSON: " + e.getMessage());
        }
    }

    // Load configuration from JSON file
    public static Configuration loadConfigurationFromJSON() {
        Gson gson = new Gson();
        try (Reader reader = Files.newBufferedReader(Paths.get("config.json"))) {
            return gson.fromJson(reader, Configuration.class);
        } catch (IOException e) {
            System.out.println("Error loading configuration from JSON: " + e.getMessage());
        }
        return null;
    }

    // Save configuration to plain text file
    public static void saveConfigurationToTextFile(Configuration config) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("config.txt"))) {
            writer.write("Max Ticket Capacity: " + config.getMaxTicketCapacity() + "\n");
            writer.write("Total Vendors: " + config.getTotalVendors() + "\n");
            writer.write("Total Customers: " + config.getTotalCustomers() + "\n");
            System.out.println("Configuration saved to text file.");
        } catch (IOException e) {
            System.out.println("Error saving configuration to text file: " + e.getMessage());
        }
    }

    // Load configuration from plain text file
    public static Configuration loadConfigurationFromTextFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("config.txt"))) {
            String line;
            int maxTicketCapacity = 0, totalVendors = 0, totalCustomers = 0;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Max Ticket Capacity: ")) {
                    maxTicketCapacity = Integer.parseInt(line.split(": ")[1]);
                } else if (line.startsWith("Total Vendors: ")) {
                    totalVendors = Integer.parseInt(line.split(": ")[1]);
                } else if (line.startsWith("Total Customers: ")) {
                    totalCustomers = Integer.parseInt(line.split(": ")[1]);
                }
            }
            return new Configuration(maxTicketCapacity, totalVendors, totalCustomers);
        } catch (IOException e) {
            System.out.println("Error loading configuration from text file: " + e.getMessage());
        }
        return null;
    }
}
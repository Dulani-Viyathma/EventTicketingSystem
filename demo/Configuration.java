package com.example.demo;

import java.io.Serializable;

public class Configuration implements Serializable {
    private int maxTicketCapacity;
    private int totalVendors;
    private int totalCustomers;

    public Configuration(int maxTicketCapacity, int totalVendors, int totalCustomers) {
        this.maxTicketCapacity = maxTicketCapacity;
        this.totalVendors = totalVendors;
        this.totalCustomers = totalCustomers;
    }

    public int getMaxTicketCapacity() {
        return maxTicketCapacity;
    }

    public int getTotalVendors() {
        return totalVendors;
    }

    public int getTotalCustomers() {
        return totalCustomers;
    }
}
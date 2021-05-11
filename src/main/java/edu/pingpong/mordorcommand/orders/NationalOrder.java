package edu.pingpong.mordorcommand.orders;

import edu.pingpong.mordorcommand.interfaces.Order;

import java.util.UUID;

public class NationalOrder implements Order {

    private String id = null;
    private String destination = null;
    private int weight = 0;

    public NationalOrder(String destination, int weight) {
        this.id = UUID.randomUUID().toString();
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public String getDestination() {
        return this.destination;
    }

    @Override
    public int getWeight() {
        return this.weight;
    }

    @Override
    public String getId() {
        return this.id;
    }
}

package edu.pingpong.mordorcommand.orders;

import edu.pingpong.mordorcommand.interfaces.Order;

public class InternationalOrder implements Order {

    private String destination = null;
    private int weight = 0;

    public InternationalOrder(String destination, int weight) {
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
}

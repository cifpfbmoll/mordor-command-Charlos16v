package edu.pingpong.mordorcommand;

public class InternationalOrder implements Order {

    private String destination = null;
    private int weight = 0;

    public InternationalOrder(String destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }

    public String getDestination() {
        return this.destination;
    }

    public int getWeight() {
        return this.weight;
    }
}

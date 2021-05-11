package edu.pingpong.mordorcommand.orders;

import edu.pingpong.mordorcommand.interfaces.InstructedOrder;

public class DangerousOrder implements InstructedOrder {

    private String destination = null;
    private int weight = 0;
    private String instructions = null;

    public DangerousOrder(String destination, String instructions) {
        this.destination = destination;
        this.instructions = instructions;
    }

    @Override
    public String getInstructions() {
        return this.instructions;
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

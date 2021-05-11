package edu.pingpong.mordorcommand.orders;

import edu.pingpong.mordorcommand.interfaces.InstructedOrder;

import java.util.UUID;

public class DangerousOrder implements InstructedOrder {

    private String id = null;
    private String destination = null;
    private final int weight = 0;
    private String instructions = null;

    public DangerousOrder(String destination, String instructions) {
        this.id = UUID.randomUUID().toString();
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

    @Override
    public String getId() {
        return this.id;
    }
}

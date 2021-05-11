package edu.pingpong.mordorcommand.processors;

import edu.pingpong.mordorcommand.Status;
import edu.pingpong.mordorcommand.interfaces.Order;
import edu.pingpong.mordorcommand.interfaces.OrderTreatment;
import edu.pingpong.mordorcommand.interfaces.Processor;

public class Office implements Processor {

    @Override
    public boolean processes(OrderTreatment orderTreatment) {
        return orderTreatment.treat();
    }

    // Using Ternary operator (condition? true result : false result)
    public String printStatus(boolean status, Order order) {
        return status ? order.getDestination() + " " + Status.ACCEPTED.name() :
                order.getDestination() + " " + Status.REJECTED.name();
    }
}

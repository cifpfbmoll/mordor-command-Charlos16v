package edu.pingpong.mordorcommand.processors;

import edu.pingpong.mordorcommand.interfaces.OrderTreatment;
import edu.pingpong.mordorcommand.interfaces.Processor;

public class Office implements Processor {

    @Override
    public boolean processes(OrderTreatment orderTreatment) {
        return orderTreatment.treat();
    }
}

package edu.pingpong.mordorcommand.treatments;

import edu.pingpong.mordorcommand.interfaces.OrderTreatment;
import edu.pingpong.mordorcommand.orders.DangerousOrder;

public class DangerousOrderTreatment implements OrderTreatment {

    private DangerousOrder dangerousOrder = null;

    public DangerousOrderTreatment(DangerousOrder dangerousOrder) {
        this.dangerousOrder = dangerousOrder;
    }

    @Override
    public boolean treat() {
        // If the order instruction is "No ponerselo en el dedo" return false.
        return !this.dangerousOrder.getInstructions().equals("No ponerselo en el dedo");
    }
}

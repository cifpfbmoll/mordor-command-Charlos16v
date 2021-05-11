package edu.pingpong.mordorcommand.treatments;

import edu.pingpong.mordorcommand.interfaces.OrderTreatment;
import edu.pingpong.mordorcommand.orders.InternationalOrder;

public class InternationalOrderTreatment implements OrderTreatment {

    private InternationalOrder internationalOrder = null;

    public InternationalOrderTreatment(InternationalOrder internationalOrder) {
        this.internationalOrder = internationalOrder;
    }

    @Override
    public boolean treat() {
        // If the order goes to "Mordor" return false.
        return !this.internationalOrder.getDestination().equals("Mordor");
    }
}

package edu.pingpong.mordorcommand;

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

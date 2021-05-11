package edu.pingpong.mordorcommand.treatments;

import edu.pingpong.mordorcommand.interfaces.Order;
import edu.pingpong.mordorcommand.interfaces.OrderTreatment;

import java.util.Set;

public class MultipleOrderTreatment implements OrderTreatment {

    private final Set<Order> orders;

    private Integer totalWeight = 0;
    private Integer packageQuantity = 0;

    public MultipleOrderTreatment(Set<Order> orders) {
        this.orders = orders;
    }

    public Set<Order> getOrders() {
        return this.orders;
    }

    public void setTotalWeight(Integer totalWeight) {
        this.totalWeight = totalWeight;
    }

    public Integer getTotalWeight() {
        return this.totalWeight;
    }

    public void setPackageQuantity(Integer packageQuantity) {
        this.packageQuantity = packageQuantity;
    }

    public Integer getPackageQuantity() {
        return this.packageQuantity;
    }

    @Override
    public boolean treat() {
        calculatePackageQuantity();
        calculateTotalWeight();
        return (getPackageQuantity() == getOrders().size() && getTotalWeight() > 0);
    }

    // Method encharged of sum all the weight of the orders in the orders set.
    public void calculateTotalWeight() {
        setTotalWeight(getOrders().stream().mapToInt(Order::getWeight).sum());
    }

    // Method encharged of get the number of packages inside the MultipleOrder.
    public void calculatePackageQuantity() {
        setPackageQuantity(getOrders().size());
    }
}

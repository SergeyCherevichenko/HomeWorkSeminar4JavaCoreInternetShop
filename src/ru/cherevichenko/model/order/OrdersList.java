package ru.cherevichenko.model.order;

import java.util.ArrayList;
import java.util.List;

public class OrdersList {
    private List<Order> oreders;
    public  OrdersList(){
        this.oreders = new ArrayList<>();
    }
    public void addOrders(Order order){
        oreders.add(order);
    }

    public List<Order> getOreders() {
        return oreders;
    }
}

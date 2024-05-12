package ru.cherevichenko.model.order;

public class OrdersBuild {
    public Order ordersBuild(String name,double price,int quantity){
        Order order = new Order(name,price,quantity);
        return order;
    }
}

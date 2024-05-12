package ru.cherevichenko.model.order;

public class Order {
    private String orderName;
    private double price;
    private int quantity;
    private int quantityCustomer;

    public Order(String orderName, double price,int quantity) {
        this.orderName = orderName;
        this.price = price;
        this.quantity = quantity;
        quantityCustomer = 0;
    }

    public String getOrderName() {
        return orderName;
    }

    public double getPrice() {
        return price;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setQuantityCustomer(int quantityCustomer) {
        this.quantityCustomer = quantityCustomer;
    }

    @Override
    public String toString() {
        return
                "Название товара='" + orderName + '\'' +
                ", цена=" + price +
                ", количество на складе=" + quantity +
                ", заказано пользователем =" + quantityCustomer;
    }
}

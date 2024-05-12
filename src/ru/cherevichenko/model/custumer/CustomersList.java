package ru.cherevichenko.model.custumer;

import java.util.ArrayList;
import java.util.List;

public class CustomersList {
    private List<Customer> customers;
    public CustomersList(){
        this.customers = new ArrayList<>();
    }
    public void addCustomers(Customer customer){
        customers.add(customer);
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}

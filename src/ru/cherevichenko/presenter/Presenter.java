package ru.cherevichenko.presenter;

import ru.cherevichenko.model.item.Item;
import ru.cherevichenko.view.View;


public class Presenter {
    View view;
    Item item;
    public Presenter(View view){
        this.view = view;
        this.item = new Item();
    }
    public void addEmployee(){
        item.addEmployee();
    }
    public  void addOrder(){
        item.addOrder();
    }
    public void addOrderAndEmployeeForCustomer(){
        item.addOrderAndEmployeeForCustomer();
    }
    public void allCustomer(){
        item.allCustomer();
    }
    public void allEmployee(){
        item.allEmployee();
    }
    public void allOrder(){
        item.allOrders();
    }
    public  void authorisation(){
        item.authorisation();
    }
    public void deleteCustomer(){
        item.deleteCustomer();
    }
    public void deleteOrder(){
        item.deleteOrder();
    }
    public  void deleteEmployee(){
        item.deleteEmployee();
    }
    public  void happyHolidays(){
        item.happyHolidays();
    }
    public void allMainOrder(){
        item.allMainOrder();
    }
    public void deleteMainOrder(){
        item.deleteMainOrder();
    }
    public boolean authorisationManager(){
         return item.authorisationManager();
    }
}

package ru.cherevichenko.model.custumer;

import ru.cherevichenko.model.employee.Employee;
import ru.cherevichenko.model.enums.Gender;
import ru.cherevichenko.model.order.Order;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Customer {
    private String name;
    private String lastName;
    private String surname;
    private LocalDate birthDay;
    private Gender gender;
    private String phoneNumber;
    private Map orderAndEmployee;

    public Customer(String name, String lastName, String surname,
                    Gender gender,LocalDate birthDay, String phoneNumber) {
        this.name = name;
        this.lastName = lastName;
        this.surname = surname;
        this.gender = gender;
        this.birthDay = birthDay;
        this.phoneNumber = phoneNumber;
        orderAndEmployee = new HashMap<Order, Employee>();
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Map getOrderAndEmployee() {
        return orderAndEmployee;
    }

    public void setOrder(Order order,Employee employee) {
        orderAndEmployee.put(order,employee);
    }

    @Override
    public String toString() {
        return
                "имя= " + name + '\'' +
                ", фамилия= " + lastName + '\'' +
                ", отчество= " + surname + '\'' +
                ", день рождения= " + birthDay +
                ", пол= " + gender +
                ", номер телефона= " + phoneNumber + '\'' +
                ", список товаров и имя обслуживающего сотрудника= " + orderAndEmployee;

    }
}

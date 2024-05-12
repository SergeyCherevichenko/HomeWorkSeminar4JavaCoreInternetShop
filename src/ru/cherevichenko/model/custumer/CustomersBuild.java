package ru.cherevichenko.model.custumer;

import ru.cherevichenko.model.enums.Gender;

import java.time.LocalDate;

public class CustomersBuild {
    public Customer customerBuild(String name, String lastName, String surname, Gender gender,
                                  LocalDate birthDay, String phoneNumber){
        Customer customer = new Customer(name,lastName,surname,gender,birthDay,phoneNumber);
        return customer;
    }
}

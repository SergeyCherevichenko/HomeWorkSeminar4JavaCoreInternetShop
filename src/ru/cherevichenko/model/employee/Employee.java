package ru.cherevichenko.model.employee;

import ru.cherevichenko.model.enums.Gender;

import java.time.LocalDate;

public class Employee {
private String name;
private String lastName;
private LocalDate birthDay;
private Gender gender;
private String massages;
private String phoneNumber;

    public Employee(String name, String lastName, LocalDate birthDay,Gender gender, String phoneNumber) {
        this.name = name;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        massages = null;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
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

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setMassages(String massages) {
        this.massages = massages;
    }

    public String getMassages() {
        return massages;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return
                "имя='" + name + '\'' +
                ", фамилия='" + lastName + '\'' +
                ", день рождения=" + birthDay +
                ", пол=" + gender +
                ", сообщения='" + massages + '\'' +
                ", номер телефона='" + phoneNumber + '\'';
    }
}

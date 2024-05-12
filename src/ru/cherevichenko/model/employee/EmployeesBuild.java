package ru.cherevichenko.model.employee;

import ru.cherevichenko.model.enums.Gender;

import java.time.LocalDate;

public class EmployeesBuild {
    public Employee employeeBuild(String name, String lastName, LocalDate birthDay, Gender gender, String phoneNumber){
        Employee employee = new Employee(name,lastName,birthDay,gender,phoneNumber);
        return employee;
    }
}

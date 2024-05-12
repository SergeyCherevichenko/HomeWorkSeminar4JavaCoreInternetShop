package ru.cherevichenko.model.employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeList {
    private List<Employee> employees;
    public EmployeeList(){
        this.employees = new ArrayList<>();
    }
    public  void addEmployee(Employee employee){
        employees.add(employee);
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}

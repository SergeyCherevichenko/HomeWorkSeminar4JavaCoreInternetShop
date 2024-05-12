package ru.cherevichenko.model.item;

import ru.cherevichenko.model.custumer.Customer;
import ru.cherevichenko.model.custumer.CustomersBuild;
import ru.cherevichenko.model.custumer.CustomersList;
import ru.cherevichenko.model.employee.Employee;
import ru.cherevichenko.model.employee.EmployeeList;
import ru.cherevichenko.model.employee.EmployeesBuild;
import ru.cherevichenko.model.enums.Gender;
import ru.cherevichenko.model.enums.Holidays;
import ru.cherevichenko.model.inputdate.InputDate;
import ru.cherevichenko.model.order.Order;
import ru.cherevichenko.model.order.OrdersBuild;
import ru.cherevichenko.model.order.OrdersList;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Item {
    private CustomersBuild customersBuild;
    private OrdersBuild ordersBuild;
    private EmployeesBuild employeesBuild;
    private CustomersList customersList;
    private OrdersList ordersList;
    private EmployeeList employeeList;
    private InputDate inputDate;
    private  boolean inp = true;


    public Item(){
        customersBuild = new CustomersBuild();
        ordersBuild = new OrdersBuild();
        employeesBuild = new EmployeesBuild();
        customersList = new CustomersList();
        ordersList = new OrdersList();
        employeeList = new EmployeeList();
        this.inputDate = new InputDate();

    }

public Customer addCustomer() {
    String name = inputDate.inputString("Введите свое имя :");
    String lastName = inputDate.inputString("Введите свою фамилию: ");
    String surname = inputDate.inputString("Введите ваше отчество: ");
    LocalDate birthDay = inputDate.birthDay("Введите вашу дату рождения в формате гггг-мм-дд:");
    Gender gender = inputDate.gender("Введите ваш пол м/ж: ");
    String phoneNumber = inputDate.inputString("Введите ваш номер телефона: ");
    Customer customer = customersBuild.customerBuild(name, lastName, surname,
            gender, birthDay, phoneNumber);
    customersList.addCustomers(customer);
    System.out.println("Регистрация успешна!");
    return customer;

    }

public void addOrder(){
        String name = inputDate.inputString("Введите название товара: ");
        double price = inputDate.price("Введите цену товара: ");
        int quantity = inputDate.quantity("Введите количество товара: ");
        Order order = ordersBuild.ordersBuild(name,price,quantity);
        ordersList.addOrders(order);
    System.out.println("Товар добавлен успешно!");
}
public void addEmployee(){
    String name = inputDate.inputString("Введите имя сотрудника:");
    String lastName = inputDate.inputString("Введите фамилию сотрудника: ");
    LocalDate birthDay  = inputDate.birthDay("Введите дату рождения сотрудника в формате гггг-мм-дд: ");
    Gender gender = inputDate.gender("Введите пол сотрудника: ");
    String phoneNumber = inputDate.inputString("Введите номер телефона сотрудника: ");
        Employee employee = employeesBuild.employeeBuild(name,lastName,birthDay,gender,phoneNumber);
        employeeList.addEmployee(employee);
    System.out.println("Сотрудник добавлен успешно!");
}

public Customer authorisation(){
    Scanner scan = new Scanner(System.in);
    Customer customer = null;
    System.out.println("Вы новый пользователь д/н: ");
    String inputCustomer = scan.next();
    while (inp){
        if(!"д".equals(inputCustomer) && !"н".equals(inputCustomer)){
            System.out.println("Вы должны ответить только \"д\" или \"н\"! Попробуйте еще раз!");
            inputCustomer = scan.next();
        }else {
            inp  = false;
        }
    }
    if(inputCustomer.equals("д")){
        customer = addCustomer();

    }else {
        System.out.println("Введите свою фамилию: ");
        String inputName = scan.next();
        System.out.println("Введите свой номер телефона: ");
        String inputPhoneNumber = scan.next();
        boolean inp = false;
        for (Customer c:customersList.getCustomers()) {
            if (c.getLastName().equals(inputName) && c.getPhoneNumber().equals(inputPhoneNumber)) {
                customer = c;
                System.out.println("Подтверждено!");
                inp = true;
            }
        }
            if(!inp) {
                System.out.println("Пользователь с таким именем и телефоном не обнаружен!!");
            }
        }


    return customer;
}
public boolean authorisationManager(){
        boolean manager = false;
        String name = inputDate.inputString("Введите ваше имя: ");
        String password = inputDate.inputString("Введите пароль: ");
        if(name.equals("Сергей") && password.equals("123")){
            manager = true;
            System.out.println("Добро пожаловать менеджер Сергей!");
            }else {
            System.out.println("Вы не менеджер! Вам предоставлен функционал программы для пользователя!" );
        }
        return manager;
}

public Employee autoEmployeeSelect(){
    Random random  =  new Random();
    Employee employee = null;
    try {
        int randomIndex = random.nextInt(employeeList.getEmployees().size());
        employee = employeeList.getEmployees().get(randomIndex);
    }catch (IndexOutOfBoundsException e){
        System.out.println("Не добавлен не один сотрудник магазина!");
    }
    return employee;

}

public void addOrderAndEmployeeForCustomer() {
    Scanner scan = new Scanner(System.in);
    Customer customer = authorisation();
    System.out.println("Выберите из списка какой товар вы хотите добавить(по названию):  ");
    if (ordersList.getOreders().isEmpty()) {
        System.out.println("Не добавлен ни один товар!");
    } else {
        for (Order o : ordersList.getOreders()) {
            System.out.println("Название товара: " + o.getOrderName() + "\n" + "Цена: " + o.getPrice());
        }
        String inputNameOrder = scan.next();
        for (Order o : ordersList.getOreders()) {
            if (o.getOrderName().equals(inputNameOrder)) {
                Employee employee = autoEmployeeSelect();
                customer.setOrder(o, employee);
                int quantity = inputDate.quantity("Введите количество: ");
                o.setQuantityCustomer(quantity);
                System.out.println("Товар успешно добавлен!");
            }
        }
    }
}

        public void deleteCustomer() {
            Scanner scan = new Scanner(System.in);
            boolean del = false;
            if (customersList.getCustomers().isEmpty()) {
                System.out.println("Не добавлен ни один пользователь!");
            } else {
                for(Customer c:customersList.getCustomers()){
                    System.out.println(c.getLastName() + " --" + c.getPhoneNumber());
                }
                String lastName = inputDate.inputString("Введите фамилию пользователя, которого  хотите удалить:  ");
                String phoneNumber = inputDate.inputString("Введите номер телефона пользователя, которого " +
                        " хотите удалить: ");


                for (int i = 0; i < customersList.getCustomers().size(); i++) {
                    if (customersList.getCustomers().get(i).getLastName().equals(lastName)
                            && customersList.getCustomers().get(i).getPhoneNumber().equals(phoneNumber)) {
                        customersList.getCustomers().remove(customersList.getCustomers().get(i));
                        System.out.println("Пользователь удален успешно!");
                        del = true;
                    }
                }
                if (!del) System.out.println("Такого пользователя не существует!");

            }
        }
        public void deleteEmployee(){
            Scanner scan = new Scanner(System.in);
            boolean del = false;
            if(employeeList.getEmployees().isEmpty()){
                System.out.println("Не добавлен ни один сотрудник магазина!");
            }else {
                for (Employee e: employeeList.getEmployees()){
                    System.out.println(e.getLastName() + " -- " + e.getPhoneNumber());
                }
                String lastName = inputDate.inputString("Введите фамилию сотрудника, которого  хотите удалить:  ");
                String phoneNumber = inputDate.inputString("Введите номер телефона сотрудника, которого хотите удалить:  ");
                for (int i = 0; i < employeeList.getEmployees().size(); i++) {
                    if (employeeList.getEmployees().get(i).getLastName().equals(lastName)
                            && employeeList.getEmployees().get(i).getPhoneNumber().equals(phoneNumber)) {
                        employeeList.getEmployees().remove(employeeList.getEmployees().get(i));
                        System.out.println("Сотрудник удален успешно!");
                        del = true;
                    }
                }
                if (!del) System.out.println("Такого сотрудника не существует!");
            }

        }
        public void deleteOrder() {
            Scanner scan = new Scanner(System.in);
            boolean del = false;
            if (ordersList.getOreders().isEmpty()) {
                System.out.println("Нет ни одного товара!");
            } else {
                for (Order o:ordersList.getOreders()){
                    System.out.println(o.getOrderName());
                }
                String name = inputDate.inputString("Введите название товара, который  хотите удалить:  ");

                for (int i = 0; i < ordersList.getOreders().size(); i++) {
                    if (ordersList.getOreders().get(i).getOrderName().equals(name)) {
                        ordersList.getOreders().remove(ordersList.getOreders().get(i));
                        System.out.println("Товар удален успешно!");
                        del = true;
                    }
                }
                if (!del) System.out.println("Такого товара не существует!");
            }
        }
        public void allCustomer() {
            if (customersList.getCustomers().isEmpty()) {
                System.out.println("Список пользователей пуст!");
            } else {
                for (Customer c : customersList.getCustomers()) {
                    System.out.println(c.toString());
                }
            }
        }
        public void allOrders() {
            if (ordersList.getOreders().isEmpty()) {
                System.out.println("Список товаров пуст!");
            } else {
                for (Order o : ordersList.getOreders()) {
                    System.out.println(o.toString());
                }
            }
        }
        public void allEmployee() {
            if (employeeList.getEmployees().isEmpty()) {
                System.out.println("Список сотрудников пуст!");
            } else {
                for (Employee e : employeeList.getEmployees()) {
                    System.out.println(e.toString());
                }
            }
        }

public void happyHolidays() {
    LocalDate today = inputDate.birthDay("Введите дату в формате гггг-м-д: ");
    boolean feb23 = false;
    boolean mar8 = false;
    boolean hny = false;
    for (Employee e : employeeList.getEmployees()) {
        if (today.getDayOfMonth() == 23 && today.getMonthValue() == 2) {
            if (e.getGender().equals(Gender.MALE)) {
                e.setMassages("С праздником 23 февраля!" + Holidays.FEBRUARY_23);
                feb23 = true;

            }
        } else if (today.getDayOfMonth() == 8 && today.getMonthValue() == 3) {
            if (e.getGender().equals(Gender.FEMALE)) {
                e.setMassages("C праздником 8 марта!" + Holidays.MARCH_8);
                mar8 = true;

            }
        } else if (today.getDayOfMonth() == 1 && today.getMonthValue() == 1) {
            e.setMassages("C новым годом!" + Holidays.NEW_YEAR);
            hny = true;

        }

    }
if(feb23)  System.out.println("Все сотрудники мужского пола поздравлены!");
if (mar8) System.out.println("Все сотрудники женского пола поздравлены!");
if (hny)  System.out.println("Всех сотрудников поздравили с новым годом!");
if(!feb23 && !mar8 && !hny)  System.out.println("Сегодня не праздничны день!");

        }
        public Customer allMainOrder(){
        String lastname = inputDate.inputString("Введите вашу фамилию: ");
        String phoneNumber = inputDate.inputString("Введите ваш номер телефона: ");
        Customer customer = null;
        if(customersList.getCustomers().isEmpty()){
            System.out.println("Список пользователей пуст!");
            return null;
        }else {
            for (Customer c : customersList.getCustomers()) {
                if (c.getLastName().equals(lastname) && c.getPhoneNumber().equals(phoneNumber)) {
                    customer = c;
                    if(c.getOrderAndEmployee().isEmpty()){
                        System.out.println("Ваш список товаров пуст!");
                        return null;
                    }else {
                        System.out.println("ваши товары: ");
                        Set<Order> orders = c.getOrderAndEmployee().keySet();
                        for (Order order : orders) {
                            System.out.println(order);
                        }
                    }
                }
            }
        }
        return customer;
        }
        public void deleteMainOrder(){
            Customer customer = allMainOrder();
            if(customer == null){
                System.out.println("У вас нет товаров!");
            } else {
                String nameOrder = inputDate.inputString("Выберите, по имени, из списка, какой  товар вы хотите удалить. ");
                Set<Order> orders = customer.getOrderAndEmployee().keySet();
                for (Order order : orders) {
                    if (order.getOrderName().equals(nameOrder)) {
                        customer.getOrderAndEmployee().remove(order);
                    }
                }
            }

        }
}


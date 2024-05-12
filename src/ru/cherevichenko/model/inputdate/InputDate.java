package ru.cherevichenko.model.inputdate;

import ru.cherevichenko.model.enums.Gender;

import java.time.LocalDate;
import java.util.Scanner;

public class InputDate {
    private boolean inp = true;
    public String inputString(String str){
        Scanner scanner = new Scanner(System.in);
        System.out.println(str);
        String inputCustomer = scanner.next();
        return inputCustomer;

    }
    public LocalDate birthDay(String str){
        Scanner scanner  = new Scanner(System.in);
        System.out.println(str);
        LocalDate birthDay = LocalDate.now();
        inp = true;
        while (inp) {
            String inputCustomer = scanner.next();
            String[] date = inputCustomer.split("-");
            try {
                birthDay = LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]),
                        Integer.parseInt(date[2]));
                inp = false;
            } catch (Exception e) {
                System.out.println("Не верный формат даты! Попробуйте еще раз");
            }
        }
        return birthDay;
    }
    public Gender gender(String str) {
        Scanner scanner = new Scanner(System.in);
        inp = true;
        while (inp) {
            System.out.println(str);
            String inputCustomer = scanner.next();
            if (inputCustomer.equals("ж")) {
                inp = false;
                return Gender.FEMALE;
            } else if (inputCustomer.equals("м")) {
                inp = false;
                return Gender.MALE;
            } else System.out.println("Нет такого пола! Попробуйте еще раз!");
        }
        return null;
    }
    public double price(String str){
        Scanner scan = new Scanner(System.in);
        double price  = 0.0;
        inp = true;
        while (inp) {
            System.out.println(str);
            try {
                price = Double.parseDouble(scan.next());
                inp = false;
            } catch (NumberFormatException e) {
                System.out.println("Не верный формат данных! Попробуйте еще раз!");
            }
        }

        return price;
    }
    public int quantity(String str){
        Scanner scanner = new Scanner(System.in);
        int quantity = 0;
        inp = true;
        while (inp){
        System.out.println(str);
        try {
            quantity = Integer.parseInt(scanner.next());
            inp = false;
        }catch (NumberFormatException e){
            System.out.println("Не верный формат данных! Попробуйте еще раз!");
        }
        }
        return quantity;
    }
}

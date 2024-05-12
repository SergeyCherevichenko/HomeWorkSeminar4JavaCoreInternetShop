package ru.cherevichenko.view;

import ru.cherevichenko.presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View{
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenuForCustomer mainMenuForCustomer;
    private MainMenuForManager mainMenuForManager;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        mainMenuForCustomer = new MainMenuForCustomer(this);
        mainMenuForManager  = new MainMenuForManager(this);
    }

    @Override
    public void start() {
        System.out.println("Это программа интернет магазин! Для продолжения работы пожалуйста авторизуйтесь!");
        boolean ans = authorisationStart();
        while (work) {
            if (ans) {
                printMenuManager();
                choiceM();
            } else {
                printMenuCustomer();
                choiceC();
            }
        }
    }
    public boolean authorisationStart() {
        boolean ans = true;
        System.out.println("Вы менеджер д/н ?");
        String answer = scanner.next();
        while (ans) {
            if (!"д".equals(answer) && !"н".equals(answer)) {
                System.out.println("Вы должны ответить только \"д\" или \"н\"! Попробуйте еще раз!");
                answer = scanner.next();
            } else {
                ans = false;
            }
        }
            if (answer.equals("н")) return ans;
            else ans = presenter.authorisationManager();
            return ans;

        }


    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);

    }
    private void choiceM(){
        int line = scanner.nextInt();
        if (line >0 && line <= mainMenuForManager.size()) mainMenuForManager.execute(line);
        else error();
    }
    private void choiceC(){
        int line = scanner.nextInt();
        if(line>0 && line<=mainMenuForCustomer.size()) mainMenuForCustomer.execute(line);
        else error();
    }
    private void error(){
        System.out.println("Операции с таким номером не существует! Выберите из списка!");
    }
    private void printMenuManager(){
        System.out.println(mainMenuForManager.menu());
    }
    private void printMenuCustomer(){
        System.out.println(mainMenuForCustomer.menu());
    }
    public void finish(){
        System.out.println("До новых встреч!");
        work = false;
    }
    public  void addEmployee(){
        presenter.addEmployee();
    }
    public void addOrder(){
        presenter.addOrder();
    }
    public void addOrderAndEmployeeForCustomer(){
        presenter.addOrderAndEmployeeForCustomer();
    }
    public void allCustomer(){
        presenter.allCustomer();
    }
    public void allEmployee(){
        presenter.allEmployee();
    }
    public void allMainOrder(){
        presenter.allMainOrder();
    }
    public void allOrder(){
        presenter.allOrder();
    }
    public void authorisation(){
        presenter.authorisation();
    }
    public void deleteCustomer(){
        presenter.deleteCustomer();
    }
    public void deleteEmployee(){
        presenter.deleteEmployee();
    }
    public void deleteMainOrder(){
        presenter.deleteMainOrder();
    }
    public void deleteOrder(){
        presenter.deleteOrder();
    }
    public void happyHolidays(){
        presenter.happyHolidays();
    }
}

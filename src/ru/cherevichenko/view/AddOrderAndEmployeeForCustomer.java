package ru.cherevichenko.view;

public class AddOrderAndEmployeeForCustomer extends Command{
    public AddOrderAndEmployeeForCustomer( ConsoleUI consoleUI) {
        super("добавить товар в корзину.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().addOrderAndEmployeeForCustomer();
    }
}

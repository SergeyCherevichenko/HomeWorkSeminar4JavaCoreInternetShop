package ru.cherevichenko.view;

public class AllCustomer extends Command{
    public AllCustomer( ConsoleUI consoleUI) {
        super("Список всех пользователей.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().allCustomer();
    }
}

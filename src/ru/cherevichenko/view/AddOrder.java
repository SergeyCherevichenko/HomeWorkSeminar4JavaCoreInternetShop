package ru.cherevichenko.view;

public class AddOrder extends Command{
    public AddOrder( ConsoleUI consoleUI) {
        super("Добавить товар.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().addOrder();
    }
}

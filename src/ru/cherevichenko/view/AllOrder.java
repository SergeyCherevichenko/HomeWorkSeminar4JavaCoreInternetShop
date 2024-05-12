package ru.cherevichenko.view;

public class AllOrder extends Command{
    public AllOrder( ConsoleUI consoleUI) {
        super("Список всех товаров.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().allOrder();
    }
}

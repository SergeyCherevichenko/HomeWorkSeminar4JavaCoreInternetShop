package ru.cherevichenko.view;

public class AllMainOrder extends Command{
    public AllMainOrder( ConsoleUI consoleUI) {
        super("Список моих товаров.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().allMainOrder();

    }
}

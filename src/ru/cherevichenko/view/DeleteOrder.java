package ru.cherevichenko.view;

public class DeleteOrder extends Command{
    public DeleteOrder( ConsoleUI consoleUI) {
        super("Удалить товар.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().deleteOrder();

    }
}

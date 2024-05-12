package ru.cherevichenko.view;

public class DeleteMainOrder extends Command{
    public DeleteMainOrder( ConsoleUI consoleUI) {
        super("Удалить товар из моего списка товаров.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().deleteMainOrder();

    }
}

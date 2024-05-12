package ru.cherevichenko.view;

public class DeleteCustomer extends Command{
    public DeleteCustomer( ConsoleUI consoleUI) {
        super("Удалить пользователя.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().deleteCustomer();
    }
}

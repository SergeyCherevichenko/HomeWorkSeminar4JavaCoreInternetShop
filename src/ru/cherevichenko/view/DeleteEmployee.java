package ru.cherevichenko.view;

public class DeleteEmployee extends Command{
    public DeleteEmployee( ConsoleUI consoleUI) {
        super("Удалить сотрудника.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().deleteEmployee();
    }
}

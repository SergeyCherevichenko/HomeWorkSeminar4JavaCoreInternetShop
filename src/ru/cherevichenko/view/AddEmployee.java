package ru.cherevichenko.view;

public class AddEmployee extends Command{
    public AddEmployee( ConsoleUI consoleUI) {
        super("Добавить сотрудника.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().addEmployee();

    }
}

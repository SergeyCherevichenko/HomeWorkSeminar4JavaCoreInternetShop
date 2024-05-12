package ru.cherevichenko.view;

public class AllEmployee extends Command{
    public AllEmployee( ConsoleUI consoleUI) {
        super("Список всех сотрудников. ", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().allEmployee();
    }
}

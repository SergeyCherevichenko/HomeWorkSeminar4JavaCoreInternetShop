package ru.cherevichenko.view;

public class HappyHolidays extends Command{
    public HappyHolidays( ConsoleUI consoleUI) {
        super("Поздравить сотрудников с праздником.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().happyHolidays();
    }
}

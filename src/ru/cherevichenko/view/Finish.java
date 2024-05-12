package ru.cherevichenko.view;

public class Finish extends Command {
    public Finish( ConsoleUI consoleUI) {
        super("Закончить работу приложения.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().finish();

    }
}

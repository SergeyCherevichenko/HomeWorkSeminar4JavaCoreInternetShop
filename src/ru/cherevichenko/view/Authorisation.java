package ru.cherevichenko.view;

public class Authorisation extends Command{
    public Authorisation( ConsoleUI consoleUI) {
        super("Авторизация и регистрация.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().authorisation();
    }
}

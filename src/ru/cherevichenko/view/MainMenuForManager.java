package ru.cherevichenko.view;

import java.util.ArrayList;
import java.util.List;

public class MainMenuForManager {
    private List<Command> commands;

    public MainMenuForManager(ConsoleUI consoleUI) {
        commands = new ArrayList<>();
        commands.add(new Authorisation(consoleUI));
        commands.add(new AddEmployee(consoleUI));
        commands.add(new AddOrder(consoleUI));
        commands.add(new AllCustomer(consoleUI));
        commands.add(new AllEmployee(consoleUI));
        commands.add(new AllOrder(consoleUI));
        commands.add(new DeleteCustomer(consoleUI));
        commands.add(new DeleteEmployee(consoleUI));
        commands.add(new DeleteOrder(consoleUI));
        commands.add(new HappyHolidays(consoleUI));
        commands.add(new Finish(consoleUI));
    }
    public String menu(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i+1)
                    .append(". ")
                    .append(commands.get(i).getDescription())
                    .append("\n");
        }
        return stringBuilder.toString();
    }
    public void execute(int choice){
        Command command = commands.get(choice-1);
        command.execute();
    }
    public  int size(){
        return commands.size();
    }
}

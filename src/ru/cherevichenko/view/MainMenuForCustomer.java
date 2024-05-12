package ru.cherevichenko.view;

import java.util.ArrayList;
import java.util.List;

public class MainMenuForCustomer {
    private List<Command> commands;

    public MainMenuForCustomer(ConsoleUI consoleUI) {
        commands = new ArrayList<>();
        commands.add(new Authorisation(consoleUI));
        commands.add(new AllOrder(consoleUI));
        commands.add(new AddOrderAndEmployeeForCustomer(consoleUI));
        commands.add(new AllMainOrder(consoleUI));
        commands.add(new DeleteMainOrder(consoleUI));
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

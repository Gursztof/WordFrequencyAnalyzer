import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner;
    Actions action;
    // Content of command
    private String content;
    private String command;

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
        this.action = new Actions(scanner);
    }

    public void start() {
        while (true) {
            getInput();
            if (command.equals("quit")) {
                break;
            }
            startAction();
        }
    }

    // TODO find better way of clearing data everytime.
    public void getInput() {
        // Clear old data
        this.command = "";
        this.content = "";

        System.out.print("> ");
        String input = scanner.nextLine();
        String[] splitInput = input.split(" ");
        this.command = splitInput[0];
        if (splitInput.length > 1) {
            this.content = splitInput[1];
        }
    }

    public void startAction() {
        switch(command) {
            case "help" -> action.printHelp();
            case "analyze" -> {
                if (content.isEmpty()) {
                    action.analyseUserInput();
                } else {
                    action.analyseFile(content);
                }
            }
            default -> System.out.println("Invalid command, for more info please use command help");
        }
    }
}


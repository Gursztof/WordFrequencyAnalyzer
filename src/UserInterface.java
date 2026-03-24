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

    // Better naming for makeaction
    public void start() {
        while (true) {
            getInput();
            if (command.equals("quit")) {
                break;
            }
            startAction();
        }
    }

    // TODO better naming needed. Clearing the varaibles evrytime new input
    public void getInput() {
        // Clear old data
        this.command = "";
        this.content = "";

        System.out.print("> ");
        String input = scanner.nextLine();
        String[] splitInput = input.split(" ");
        this.command = splitInput[0];
        // DOWODZIEC SIE JAK DZIAAL TWORZEBIE ARRAY
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
                    System.out.println("IN WORKING...");
                }
                System.out.println("tet1");
            }
            default -> System.out.println("Invalid command, for more info please use command help");
        }
    }
}


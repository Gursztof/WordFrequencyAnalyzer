import java.util.Scanner;

public class Actions {
    private final Scanner scanner;

    public Actions(Scanner scanner) {
        this.scanner = scanner;
    }

    public void printHelp() {
        System.out.println("quit - For to exit the program");
        System.out.println("analyze - For word frequency analyze of input");
        System.out.println("analyze 'filename' - For word frequency analyze of file");
    }

    public void analyseUserInput() {
        Dictionary dictionary = new Dictionary();
        System.out.print("    > ");
        String input = scanner.nextLine();
        String[] inputWords = input.split(" ");
        for (String wordContent : inputWords) {
            Word word = new Word(wordContent);
            dictionary.add(word);
        }
        dictionary.analyze();
    }
}

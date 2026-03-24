import java.util.Scanner;

public class Main {
    public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserInterface uInterface = new UserInterface(scanner);
        uInterface.start();
    }
}

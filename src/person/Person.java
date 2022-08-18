package person;

import utils.Display;

import java.util.List;
import java.util.Scanner;

abstract public class Person {
    Scanner scanner = new Scanner(System.in);
    abstract List<String> getMenuOptions();
    abstract void handleOption(int selectedOption);
    public void requestUserInput() {
        String input = scanner.nextLine();

        try {
            int selectedOption = Integer.parseInt(input);

            handleOption(selectedOption);
        }
        catch (NumberFormatException | IndexOutOfBoundsException exception) {
            Display.printInvalidOption();
            viewBanner();
            requestUserInput();
        }
    }

    public void viewBanner() {
        System.out.print("Choose an option: ");
    }

    public void optionList(List<String> options) {

        for (int index = 0; index < options.size(); index++) {
            int number = index+1;
            String label = options.get(index);

            System.out.println("[" + number + "] " + label);
        }
    }
}

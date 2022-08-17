package mainMenu;

import utils.Display;

import java.util.Scanner;

public class MainMenuController {
    private final MainMenuModel model;
    private final Scanner scanner;

    public MainMenuController(MainMenuModel model) {
        this.model = model;
        this.scanner = new Scanner(System.in);
    }

    public void requestUserInput() {
        String input = scanner.nextLine();

        try {
            int selectedOption = Integer.parseInt(input);

            model.handleOption(selectedOption);
        }
        catch (NumberFormatException | IndexOutOfBoundsException exception) {
            Display.printInvalidOption();
            Display.printChoiceSelection();
            requestUserInput();
        }
    }
}

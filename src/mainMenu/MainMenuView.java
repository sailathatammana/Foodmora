package mainMenu;

import java.util.Map;
import java.util.HashMap;

public class MainMenuView {
    public MainMenuView(HashMap<Integer, String> options) {
        System.out.println("Please choose an user type:");
        optionList(options);
        printChoiceSelection();
    }

    public void optionList(HashMap<Integer, String> options) {
        for (Map.Entry<Integer, String>  option: options.entrySet()) {
            System.out.println("[" + option.getKey() + "] " + option.getValue());
        }
    }

    public void printInvalidOption() {
        System.out.println("⚠️ Invalid option");
    }

    public void printChoiceSelection() {
        System.out.print("Selected User: ");
    }
}
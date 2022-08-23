package mainMenu;

import utils.Display;

import java.util.Map;
import java.util.HashMap;

public class MainMenuView {
    public MainMenuView(HashMap<Integer, String> options) {
        Display.clearScreen();
        System.out.println("Please choose an user type:");
        optionList(options);
        Display.printChoiceSelection();
    }

    public void optionList(HashMap<Integer, String> options) {
        for (Map.Entry<Integer, String> option : options.entrySet()) {
            System.out.println("[" + option.getKey() + "] " + option.getValue());
        }
    }
}
package mainMenu;

import person.Dietician;
import person.User;

import java.util.HashMap;

public class MainMenuModel {

    private final HashMap<Integer, String> menuOptions = new HashMap<Integer, String>();
    User user = new User();
    Dietician dietician = new Dietician();

    public final void setMenuOptions() {
        menuOptions.put(1, "User");
        menuOptions.put(2, "Dietician");
    }

    public HashMap<Integer, String> getMenuOptions() {
        return menuOptions;
    }

    public void handleOption(int selectedOption) throws IndexOutOfBoundsException {
        switch (selectedOption) {
            case 1 -> {
                while (true) {
                    System.out.println("Please choose one of the following operations");
                    user.optionList(user.getMenuOptions());
                    user.printChoiceSelection();
                    user.requestUserInput();
                }
            }
            case 2 -> {
                while (true) {
                    System.out.println("Please choose one of the following operations");
                    dietician.optionList(dietician.getMenuOptions());
                    dietician.printChoiceSelection();
                    dietician.requestUserInput();
                }
            }
            default -> throw new IndexOutOfBoundsException();
        }
    }
}

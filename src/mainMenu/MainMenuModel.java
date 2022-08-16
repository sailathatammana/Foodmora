package mainMenu;

import java.util.HashMap;

public class MainMenuModel {

    private final HashMap<Integer, String> menuOptions = new HashMap<Integer, String>();

    public final void setMenuOptions(){
        menuOptions.put(1, "User");
        menuOptions.put(2, "Dietician");
    }

    public HashMap<Integer, String> getMenuOptions() {
        return menuOptions;
    }

    public void handleOption(int selectedOption) throws IndexOutOfBoundsException {
        switch (selectedOption) {
            case 1 -> System.out.println("User");
            case 2 -> System.out.println("Dietician");
            default -> throw new IndexOutOfBoundsException();
        }
    }
}

package mainMenu;

import person.Dietician;
import person.User;
import recipe.InputOutputFile;
import recipe.Recipe;
import utils.Display;

import java.util.ArrayList;
import java.util.HashMap;

public class MainMenuModel {
    public static String fileName = "src/test.txt";
    private final HashMap<Integer, String> menuOptions = new HashMap<Integer, String>();
    User user = new User();

    public final void setMenuOptions() {
        menuOptions.put(1, "User");
        menuOptions.put(2, "Dietician");
    }

    public HashMap<Integer, String> getMenuOptions() {
        return menuOptions;
    }

    public void handleOption(int selectedOption) throws IndexOutOfBoundsException {
        ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
        InputOutputFile ioFile = new InputOutputFile();
        recipeList = ioFile.readRecipesFromFile(fileName);
        Dietician dietician = new Dietician(recipeList, fileName);
        switch (selectedOption) {
            case 1 -> {
                while (true) {
                    System.out.println("Please choose one of the following operations");
                    user.optionList(user.getMenuOptions());
                    Display.printChoiceSelection();
                    user.requestUserInput();
                }
            }
            case 2 -> {
                while (true) {
                    System.out.println("Please choose one of the following operations");
                    dietician.optionList(dietician.getMenuOptions());
                    Display.printChoiceSelection();
                    dietician.requestUserInput();
                }
            }
            default -> throw new IndexOutOfBoundsException();
        }
    }
}

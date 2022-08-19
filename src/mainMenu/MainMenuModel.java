package mainMenu;

import person.Dietician;
import person.User;
import recipe.InputOutputFile;
import recipe.Recipe;

import java.util.ArrayList;
import java.util.HashMap;

public class MainMenuModel {
    public String fileName = "src/test.txt";
    private final HashMap<Integer, String> menuOptions = new HashMap<Integer, String>();

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
        User user = new User(recipeList);
        switch (selectedOption) {
            case 1 -> {
                while (true) {
                    System.out.println("Please choose one of the following operations");
                    user.optionList(user.getMenuOptions());
                    user.viewBanner();
                    user.requestUserInput();
                }
            }
            case 2 -> {
                while (true) {
                    System.out.println("Please choose one of the following operations");
                    dietician.optionList(dietician.getMenuOptions());
                    dietician.viewBanner();
                    dietician.requestUserInput();
                }
            }
            default -> throw new IndexOutOfBoundsException();
        }
    }
}

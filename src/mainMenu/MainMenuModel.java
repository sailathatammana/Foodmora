package mainMenu;

import generateWeek.UserWeek;
import person.Dietician;
import person.User;
import recipe.InputOutputFile;
import recipe.Recipe;
import utils.Display;

import java.util.*;

public class MainMenuModel {
    private final String fileName = "src/test.txt";
    private final String weekListFile = "src/weekList.txt";
    private final Map<Integer, String> menuOptions = new HashMap<>();

    public final void setMenuOptions() {
        menuOptions.put(1, "User");
        menuOptions.put(2, "Dietician");
    }

    public Map<Integer, String> getMenuOptions() {
        return menuOptions;
    }

    public void handleOption(int selectedOption) throws IndexOutOfBoundsException {
        ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
        ArrayList<UserWeek> userWeekList = new ArrayList<UserWeek>();
        InputOutputFile ioFile = new InputOutputFile();
        recipeList = ioFile.readRecipesFromFile(fileName);
        userWeekList = ioFile.readWeeksFromFile(weekListFile);
        Dietician dietician = new Dietician(recipeList, fileName);
        User user = new User(recipeList, userWeekList, weekListFile);
        switch (selectedOption) {
            case 1 -> {
                while (true) {
                    Display.clearScreen();
                    System.out.println("Please choose one of the following operations");
                    user.optionList(user.getMenuOptions());
                    user.viewBanner();
                    user.requestUserInput();
                }
            }
            case 2 -> {
                while (true) {
                    Display.clearScreen();
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

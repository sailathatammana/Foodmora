package person;

import generateWeek.GenerateWeek;
import generateWeek.UserWeek;
import generateWeek.WeekList;
import mainMenu.MainMenu;
import recipe.InputOutputFile;
import recipe.Recipe;
import recipe.RecipeList;

import java.util.ArrayList;
import java.util.List;

public class User extends Person implements iUser {
    ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
    ArrayList<UserWeek> userWeeks = new ArrayList<UserWeek>();
    String fileName;
    GenerateWeek generateWeek;
    public final List<String> menuOptions = List.of("List my weeks", "List recipes", "View recipe", "Generate a new week", "Switch Role", "Save & quit");

    public User(ArrayList<Recipe> recipe, ArrayList<UserWeek> userWeekList, String file) {
        this.recipeList = recipe;
        this.userWeeks = userWeekList;
        this.fileName = file;
        generateWeek = new GenerateWeek(userWeeks, recipeList);
    }

    public List<String> getMenuOptions() {
        return menuOptions;
    }

    public void handleOption(int selectedOption) {
        switch (selectedOption) {
            case 1 -> listMyWeeks();
            case 2 -> listRecipes();
            case 3 -> viewRecipe();
            case 4 -> userWeeks = generateWeek.addWeek();
            case 5 -> switchRole();
            case 6 -> exit();
            default -> throw new IndexOutOfBoundsException();
        }
    }

    public void listMyWeeks() {
        WeekList weekList = new WeekList(userWeeks);
        if (userWeeks.size() > 0) {
            System.out.println("List of weeks");
            for (UserWeek userWeeks1 : userWeeks)
                System.out.println("[" + userWeeks1.getWeekNo() + "] " + "WeekNo: " + userWeeks1.getWeekNo());
            weekList.request();
        } else {
            System.out.println("You haven't generated a week.");
        }
    }

    @Override
    public void viewRecipe() {
        RecipeList recipeList1 = new RecipeList(recipeList);
        recipeList1.request();
    }

    @Override
    public void listRecipes() {
        RecipeList recipeList1 = new RecipeList(recipeList);
        System.out.println("List of recipes");
        recipeList1.displayRecipesList();
    }

    @Override
    public void switchRole() {
        InputOutputFile ioFile = new InputOutputFile();
        ioFile.writeWeekObj(fileName, userWeeks);
        new MainMenu();
    }

    @Override
    public void exit() {
        InputOutputFile ioFile = new InputOutputFile();
        ioFile.writeWeekObj(fileName, userWeeks);
        System.out.println("Good Bye");
        System.exit(1);
    }
}
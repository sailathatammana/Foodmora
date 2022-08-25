package person;

import generateWeek.GenerateWeek;
import generateWeek.UserWeek;
import generateWeek.WeekList;
import mainMenu.MainMenu;
import recipe.InputOutputFile;
import recipe.Recipe;
import recipe.RecipeList;
import utils.Display;

import java.util.ArrayList;
import java.util.List;

public class User extends Person implements iUser {
    private ArrayList<UserWeek> userWeeks;
    private final String fileName;
    GenerateWeek generateWeek;
    RecipeList recipeList;
    InputOutputFile ioFile;
    WeekList weekList;
    public final List<String> menuOptions = List.of("List my weeks", "List recipes", "View a recipe with Id", "Generate a new week", "Switch Role", "Save & quit");

    public User(ArrayList<Recipe> recipe, ArrayList<UserWeek> userWeekList, String file) {
        this.userWeeks = userWeekList;
        this.fileName = file;
        this.recipeList = new RecipeList(recipe);
        this.ioFile = new InputOutputFile();
        this.weekList = new WeekList(userWeeks);
        generateWeek = new GenerateWeek(userWeeks, recipe);
    }

    @Override
    public List<String> getMenuOptions() {
        return menuOptions;
    }

    @Override
    public void handleOption(int selectedOption) {
        switch (selectedOption) {
            case 1 -> listMyWeeks();
            case 2 -> listRecipes();
            case 3 -> viewRecipe();
            case 4 -> generateWeek();
            case 5 -> switchRole();
            case 6 -> exit();
            default -> throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void listMyWeeks() {
        weekList.displayWeekList();
    }

    @Override
    public void generateWeek() {
        Display.clearScreen();
        userWeeks = generateWeek.addWeek();
    }

    @Override
    public void viewRecipe() {
        if (recipeList.listHasRecipes()) {
            recipeList.request();
            Display.returnMainMenu();
        }
    }

    @Override
    public void listRecipes() {
        recipeList.displayRecipesList();
        Display.returnMainMenu();
    }

    @Override
    public void switchRole() {
        ioFile.writeWeekObj(fileName, userWeeks);
        new MainMenu();
    }

    @Override
    public void exit() {
        ioFile.writeWeekObj(fileName, userWeeks);
        System.out.println("Good Bye");
        System.exit(1);
    }
}
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
    private ArrayList<Recipe> recipeList;
    private ArrayList<UserWeek> userWeeks;
    private String fileName;
    private GenerateWeek generateWeek;
    private RecipeList recipeList1;
    private InputOutputFile ioFile;
    private WeekList weekList;

    public User(ArrayList<Recipe> recipe, ArrayList<UserWeek> userWeekList, String file) {
        this.recipeList = recipe;
        this.userWeeks = userWeekList;
        this.fileName = file;
        this.recipeList1 = new RecipeList(recipeList);
        this.ioFile = new InputOutputFile();
        this.weekList = new WeekList(userWeeks);
        generateWeek = new GenerateWeek(userWeeks, recipeList);
    }

    public final List<String> menuOptions = List.of("List my weeks", "List recipes", "View a recipe with Id", "Generate a new week", "Switch Role", "Save & quit");

    public List<String> getMenuOptions() {
        return menuOptions;
    }

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
        userWeeks = generateWeek.addWeek();
    }

    @Override
    public void viewRecipe() {
        if (recipeList.size() == 0) {
            System.out.println("No recipe are available");
        } else {
            Display.clearScreen();
            recipeList1.request();
            Display.returnMainMenu();
        }
    }

    @Override
    public void listRecipes() {
        System.out.println("List of recipes");
        recipeList1.displayRecipesList();
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
package person;

import mainMenu.MainMenu;
import recipe.*;
import utils.*;

import java.util.ArrayList;
import java.util.List;

public class Dietician extends Person implements iDietician {
    private ArrayList<Recipe> recipes;
    private final String fileName;
    CreateRecipe createRecipe;
    RecipeList recipeList;
    EditRecipe editRecipe;
    InputOutputFile ioFile;
    public final List<String> menuOptions = List.of("List recipes", "View a recipe with Id", "Create a new recipe", "Update a new recipe", "Switch Role", "Save & quit");

    public Dietician(ArrayList<Recipe> recipe, String file) {
        this.recipes = recipe;
        this.fileName = file;
        this.createRecipe = new CreateRecipe(recipes);
        this.recipeList = new RecipeList(recipes);
        this.editRecipe = new EditRecipe(recipes);
        this.ioFile = new InputOutputFile();
    }

    @Override
    public List<String> getMenuOptions() {
        return menuOptions;
    }

    @Override
    public void handleOption(int selectedOption) {
        switch (selectedOption) {
            case 1 -> listRecipes();
            case 2 -> viewRecipe();
            case 3 -> createRecipe();
            case 4 -> updateRecipes();
            case 5 -> switchRole();
            case 6 -> exit();
            default -> throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void createRecipe() {
        recipes = createRecipe.addRecipe();
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
    public void updateRecipes() {
        recipeList.displayRecipesList();
        editRecipe.updateRequest();
    }

    @Override
    public void switchRole() {
        ioFile.writeRecipe(fileName, recipes);
        new MainMenu();
    }

    @Override
    public void exit() {
        ioFile.writeRecipe(fileName, recipes);
        System.out.println("Good Bye");
        System.exit(1);
    }
}
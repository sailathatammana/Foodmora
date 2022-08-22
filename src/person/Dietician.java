package person;

import mainMenu.MainMenu;
import recipe.*;
import utils.Display;

import java.util.ArrayList;
import java.util.List;

public class Dietician extends Person implements iDietician {
    ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
    String fileName;

    public Dietician(ArrayList<Recipe> recipe, String file) {
        this.recipeList = recipe;
        this.fileName = file;
    }

    public final List<String> menuOptions = List.of("List recipes", "View a recipe with Id", "Create a new recipe", "Update a new recipe", "Switch Role", "Save & quit");

    public List<String> getMenuOptions() {
        return menuOptions;
    }

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
        CreateRecipe readFromUser = new CreateRecipe(recipeList);
        recipeList = readFromUser.addRecipe();
    }

    @Override
    public void viewRecipe() {
        RecipeList recipeList1 = new RecipeList(recipeList);
        if (recipeList.size() == 0) {
            System.out.println("No recipe are available");
        } else {
            recipeList1.request();
            Display.exitApplication();
        }
    }

    @Override
    public void listRecipes() {
        RecipeList recipeList1 = new RecipeList(recipeList);
        System.out.println("List of recipes");
        recipeList1.displayRecipesList();
    }

    @Override
    public void updateRecipes() {
        boolean listHasRecipes;
        RecipeList recipeList1 = new RecipeList(recipeList);
        EditRecipe editRecipe = new EditRecipe(recipeList);
        listHasRecipes = recipeList1.listHasRecipes();
        if (listHasRecipes) {
            editRecipe.updateRequest();
        }
    }

    @Override
    public void switchRole() {
        InputOutputFile ioFile = new InputOutputFile();
        ioFile.writeRecipeObj(fileName, recipeList);
        new MainMenu();
    }

    @Override
    public void exit() {
        InputOutputFile ioFile = new InputOutputFile();
        ioFile.writeRecipeObj(fileName, recipeList);
        System.out.println("Good Bye");
        System.exit(1);
    }
}
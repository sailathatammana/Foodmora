package person;

import mainMenu.MainMenu;
import recipe.*;
import utils.Display;

import java.util.ArrayList;
import java.util.List;

public class Dietician extends Person implements iDietician {
    private ArrayList<Recipe> recipeList;
    private String fileName;
    private CreateRecipe createRecipe;
    private RecipeList recipeList1;
    private EditRecipe editRecipe;
    private InputOutputFile ioFile;


    public Dietician(ArrayList<Recipe> recipe, String file) {
        this.recipeList = recipe;
        this.fileName = file;
        this.createRecipe = new CreateRecipe(recipeList);
        this.recipeList1 = new RecipeList(recipeList);
        this.editRecipe = new EditRecipe(recipeList);
        this.ioFile = new InputOutputFile();
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
        recipeList = createRecipe.addRecipe();
    }

    @Override
    public void viewRecipe() {
        if (recipeList.size() == 0) {
            System.out.println("No recipe are available");
        } else {
            Display.clearScreen();
            recipeList1.request();
            Display.exitApplication();
        }
    }

    @Override
    public void listRecipes() {
        recipeList1.displayRecipesList();
    }

    @Override
    public void updateRecipes() {
        boolean listHasRecipes;
        listHasRecipes = recipeList1.listHasRecipes();
        if (listHasRecipes) {
            editRecipe.updateRequest();
        }
    }

    @Override
    public void switchRole() {
        ioFile.writeRecipeObj(fileName, recipeList);
        new MainMenu();
    }

    @Override
    public void exit() {
        ioFile.writeRecipeObj(fileName, recipeList);
        System.out.println("Good Bye");
        System.exit(1);
    }
}
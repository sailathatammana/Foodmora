package person;

import recipe.*;

import java.util.ArrayList;
import java.util.List;

public class Dietician extends Person {
    ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
    String fileName;

    public Dietician(ArrayList<Recipe> recipe, String file) {
        this.recipeList = recipe;
        this.fileName = file;
    }

    public final List<String> menuOptions = List.of("List recipes", "View a recipe with Id", "Create a new recipe", "Update a new recipe", "Save & quit");

    public List<String> getMenuOptions() {
        return menuOptions;
    }

    public void handleOption(int selectedOption) {
        boolean listHasRecipes;
        InputOutputFile ioFile = new InputOutputFile();
        CreateRecipe readFromUser = new CreateRecipe(recipeList);
        RecipeList recipeList1 = new RecipeList(recipeList);
        EditRecipe editRecipe = new EditRecipe(recipeList);
        switch (selectedOption) {
            case 1 -> {
                System.out.println("List of recipes");
                recipeList1.displayRecipesList();
            }
            case 2 -> {
                recipeList1.printSelection();
                recipeList1.request();
            }
            case 3 -> recipeList = readFromUser.addRecipe();

            case 4 -> {
                listHasRecipes = recipeList1.listHasRecipes();
                if (listHasRecipes) {
                    editRecipe.updateRequest();
                }
            }
            case 5 -> {
                System.out.println("Good Bye");
                ioFile.writeRecipeObj(fileName, recipeList);
                System.exit(1);
            }
            default -> throw new IndexOutOfBoundsException();
        }
    }
}
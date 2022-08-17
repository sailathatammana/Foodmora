package person;

import recipe.InputOutputFile;
import recipe.CreateRecipe;
import recipe.Recipe;
import recipe.RecipeList;

import java.util.ArrayList;
import java.util.List;

public class Dietician extends Person {
    ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
    String fileName;

    public Dietician(ArrayList<Recipe> recipe, String file) {
        this.recipeList = recipe;
        this.fileName = file;
    }

    public final List<String> menuOptions = List.of("List recipes", "View recipe", "Create a new recipe", "Update a new recipe", "Save & quit");

    public List<String> getMenuOptions() {
        return menuOptions;
    }

    public void handleOption(int selectedOption) {
        boolean listHasRecipes;
        InputOutputFile ioFile = new InputOutputFile();
        CreateRecipe readFromUser = new CreateRecipe(recipeList);
        RecipeList recipeList1 = new RecipeList(recipeList);
        switch (selectedOption) {
            case 1 -> {
                System.out.println("List of recipes");
                recipeList1.displayRecipesList();
                break;
            }
            case 2 -> System.out.println("View recipe");
            case 3 -> {
                recipeList = readFromUser.addRecipe();
                break;
            }
            case 4 -> {
                listHasRecipes = recipeList1.listHasRecipes();
                if (listHasRecipes) {
                    recipeList1.editRecipe(scanner.nextLine());
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
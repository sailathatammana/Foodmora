package person;

import recipe.Recipe;
import recipe.RecipeList;

import java.util.ArrayList;
import java.util.List;

public class User extends Person implements iUser {
    ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
    public final List<String> menuOptions = List.of("List my weeks", "List recipes", "View recipe", "Generate a new week", "Quit");

    public User(ArrayList<Recipe> recipe) {
        this.recipeList = recipe;
    }

    public List<String> getMenuOptions() {
        return menuOptions;
    }


    public void handleOption(int selectedOption) {
        switch (selectedOption) {
            case 1 -> System.out.println("List my weeks");
            case 2 -> listRecipes();
            case 3 -> viewRecipe();
            case 4 -> System.out.println("Generate a new week");
            case 5 -> exit();
            default -> throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void viewRecipe() {
        RecipeList recipeList1 = new RecipeList(recipeList);
        recipeList1.printSelection();
        recipeList1.request();
    }

    @Override
    public void listRecipes() {
        RecipeList recipeList1 = new RecipeList(recipeList);
        System.out.println("List of recipes");
        recipeList1.displayRecipesList();
    }

    @Override
    public void exit() {
        System.out.println("Good Bye");
        System.exit(1);
    }
}

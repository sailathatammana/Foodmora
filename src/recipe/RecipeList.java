package recipe;

import utils.Display;

import java.util.ArrayList;
import java.util.Scanner;

public class RecipeList {
    private ArrayList<Recipe> recipe;
    Scanner scanner;

    public RecipeList(ArrayList<Recipe> recipe) {
        this.recipe = recipe;
        scanner = new Scanner(System.in);
    }

    public void displayRecipesList() {
        if (listHasRecipes()) {
            Display.clearScreen();
            System.out.println("List of recipes");
            for (Recipe recipe1 : recipe)
                System.out.println(recipe.indexOf(recipe1) + 1 + "   " + recipe1.getTitle());
        }
    }

    public boolean listHasRecipes() {
        if (recipe.size() > 0) {
            return true;
        } else {
            System.out.println("Recipe list is empty");
            return false;
        }
    }

    public void request() {
        System.out.print("Enter a recipe number: ");
        String input = scanner.nextLine();
        try {
            int selectedOption = Integer.parseInt(input) - 1;
            viewRecipe(selectedOption);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            Display.printInvalidOption();
            request();
        }
    }

    public Recipe viewRecipe(int choice) {
        Recipe recipe1 = null;
        try {
            validateListSize(choice);
            recipe1 = recipe.get(choice);
            Display.printRecipeDetails(recipe1);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayIndexOutOfBoundsException("Invalid Option");
        }
        return recipe1;
    }

    public void validateListSize(int choice) {
        if (choice < 0 || choice >= recipe.size()) {
            throw new ArrayIndexOutOfBoundsException("Recipe selected is not in the List:returning to main menu");
        }
    }
}
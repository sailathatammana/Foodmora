package recipe;

import utils.Display;

import java.util.ArrayList;
import java.util.Scanner;

public class RecipeList {
    private ArrayList<Recipe> recipe;
    CreateRecipe createRecipe;
    Scanner scanner;

    public RecipeList(ArrayList<Recipe> recipe) {
        this.recipe = recipe;
        createRecipe = new CreateRecipe(recipe);
        scanner = new Scanner(System.in);
    }

    public void displayRecipesList() {
        if (recipe.size() > 0) {
            System.out.println("ID" + "  " + "Title");
            for (Recipe recipe1 : recipe)
                System.out.println(recipe.indexOf(recipe1) + 1 + "   " + recipe1.getTitle());
        } else {
            System.out.println("Recipe list is empty");
        }
    }

    public boolean listHasRecipes() {
        if (recipe.size() > 0) {
            System.out.println("ID" + "  " + "Title");
        } else {
            System.out.println("Recipe list is empty");
            return false;
        }
        for (Recipe recipe1 : recipe)
            System.out.println(recipe.indexOf(recipe1) + 1 + "   " + recipe1.getTitle() + recipe1.getIngredients());
        return true;
    }

    public Recipe viewRecipe(int choice) {
        Recipe recipe1 = null;
        try {
            if (choice < 0 || choice >= recipe.size()) {
                throw new ArrayIndexOutOfBoundsException("Recipe selected is not in the List:returning to main menu");
            }
            recipe1 = recipe.get(choice);
            System.out.println("Selected Recipe is  :" + (choice + 1) + "\n" + recipe1.getTitle());
        } catch (ArrayIndexOutOfBoundsException e) {
            Display.printInvalidOption();
            printSelection();
            request();
        }
        return recipe1;
    }

    public void request() {
        String input = scanner.nextLine();
        try {
            int selectedOption = Integer.parseInt(input) - 1;
            viewRecipe(selectedOption);
        } catch (NumberFormatException e) {
            Display.printInvalidOption();
            printSelection();
            request();
        }
    }

    public void printSelection() {
        System.out.print("Enter a recipe number: ");
    }
}

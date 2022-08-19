package recipe;

import utils.Display;

import java.util.ArrayList;
import java.util.Scanner;

public class EditRecipe {
    private ArrayList<Recipe> recipe;
    RecipeList recipeList;
    CreateRecipe createRecipe;
    Scanner scanner;

    public EditRecipe(ArrayList<Recipe> recipe) {
        this.recipe = recipe;
        recipeList = new RecipeList(recipe);
        createRecipe = new CreateRecipe(recipe);
        scanner = new Scanner(System.in);
    }

    public void updateRecipe(int recipeChoice) {
        try {
            Recipe recipe1 = recipeList.viewRecipe(recipeChoice);
            Display.editRecipeMenu();
            updateRecipeOptions(recipeChoice, recipe1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void updateRecipeOptions(int recipeChoice, Recipe recipe1) throws IndexOutOfBoundsException {
        System.out.print("Enter your choice: ");
        String choice = scanner.nextLine();
        try {
            int input = Integer.parseInt(choice);
            if (input < 1 || input > 2) {
                throw new ArrayIndexOutOfBoundsException("Recipe selected is not in the List:returning to main menu");
            }
            switch (input) {
                case 1 -> createRecipe.recipeToUpdate(recipe1);
                case 2 -> {
                    recipe.remove(recipe1);
                    System.out.println("Recipe Number " + (recipeChoice + 1) + " is removed from the List");
                }
                default -> System.out.println("Unexpected choice : Returning to main menu ");
            }
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            Display.printInvalidOption();
            updateRecipeOptions(recipeChoice, recipe1);
        }
    }

    public void updateRequest() {
        System.out.print("Enter a recipe number: ");
        String input = scanner.nextLine();
        try {
            int selectedOption = Integer.parseInt(input) - 1;
            if (selectedOption < 0 || selectedOption > (recipe.size() - 1)) {
                throw new ArrayIndexOutOfBoundsException("Recipe selected is not in the List:returning to main menu");
            }
            updateRecipe(selectedOption);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            Display.printInvalidOption();
            updateRequest();
        }
    }
}

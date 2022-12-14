package recipe;

import utils.Display;

import java.util.*;

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

    public void updateRequest() {
        System.out.println("Enter `q` to go back to main menu");
        System.out.print("Enter a recipe number to update \noption: ");
        String input = scanner.nextLine();
        try {
            if (Display.checkInput(input)) return;
            int selectedOption = Integer.parseInt(input) - 1;
            recipeList.validateListSize(selectedOption);
            updateRecipe(selectedOption);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            Display.printInvalidOption();
            updateRequest();
        }
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
        System.out.println("Enter `q` to go back to main menu");
        System.out.print("Select an choice \nOption: ");
        String choice = scanner.nextLine();
        try {
            if (Display.checkInput(choice)) return;
            int input = Integer.parseInt(choice);
            switch (input) {
                case 1 -> createRecipe.recipeToUpdate(recipe1);
                case 2 -> recipeToDelete(recipeChoice, recipe1);
                default -> throw new IndexOutOfBoundsException();
            }
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            Display.printInvalidOption();
            updateRecipeOptions(recipeChoice, recipe1);
        }
    }

    private void recipeToDelete(int recipeChoice, Recipe recipe1) {
        Display.clearScreen();
        recipe.remove(recipe1);
        System.out.println("Recipe Number " + (recipeChoice + 1) + " is removed from the List");
        Display.returnMainMenu();
    }
}
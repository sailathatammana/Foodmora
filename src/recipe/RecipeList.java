package recipe;

import utils.Display;

import java.util.ArrayList;
import java.util.Scanner;

public class RecipeList {
    private ArrayList<Recipe> recipe;
    CreateRecipe createRecipe;

    public RecipeList(ArrayList<Recipe> recipe) {
        this.recipe = recipe;
        createRecipe = new CreateRecipe(recipe);
    }

    public void displayRecipesList() {
        if (recipe.size() > 0) {
            System.out.println("ID" + "  " + "Title");
        } else {
            System.out.println("Recipe list is empty");
        }
        for (Recipe recipe1 : recipe)
            System.out.println(recipe.indexOf(recipe1) + 1 + "   " + recipe1.getTitle());
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
        System.out.print("Enter the Recipe number to edit and press enter: ");
        System.out.println();
        return true;
    }

    public void editRecipe(String recipeChoice) {
        try {

            // Checking if the recipeChoice given is not null or empty
            if (recipeChoice.trim().equals("")) {
                throw new NullPointerException("Empty Recipe Number: Returning to main menu");
            }
            int recipeIndex = Integer.parseInt(recipeChoice) - 1;
            if (recipeIndex < 0 || recipeIndex >= recipe.size()) {
                throw new ArrayIndexOutOfBoundsException("Recipe selected is not in the List:returning to main menu");
            }
            Recipe recipe1 = recipe.get(recipeIndex);
            System.out.println("\nSelected Recipe is  :" + recipeChoice + "\n" + recipe1.getTitle());

            Display.editRecipeMenu();
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    createRecipe.recipeToUpdate(recipe1);
                    break;
                case "2":
                    recipe.remove(recipe1);
                    System.out.println("Recipe Number " + recipeChoice + " is removed from the List");
                    break;
                default:
                    System.out.println("Unexpected choice : Returning to main menu ");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

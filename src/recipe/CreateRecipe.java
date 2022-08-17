package recipe;

import java.util.ArrayList;
import java.util.Scanner;

public class CreateRecipe {
    ArrayList<Recipe> recipe;

    public CreateRecipe(ArrayList<Recipe> recipe) {
        this.recipe = recipe;
    }

    public ArrayList<Recipe> addRecipe() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the tittle of the recipe: ");
            String title = scanner.nextLine();
            ArrayList<String> ingredients = addIngredients(scanner);
            ArrayList<String> steps = addSteps(scanner);
            this.recipe.add(new Recipe(title, ingredients, steps));
            System.out.println("Recipe added to the list successfully");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return recipe;
    }

    private ArrayList<String> addSteps(Scanner scanner) {
        System.out.println("Enter the steps: ");
        ArrayList<String> steps = new ArrayList<String>();
        while (scanner.hasNextLine()) {
            String i = scanner.nextLine();
            if (i.startsWith(" ")) {
                break;
            }
            steps.add(i);
        }
        return steps;
    }

    private ArrayList<String> addIngredients(Scanner scanner) {
        System.out.println("Enter the ingredients: ");
        ArrayList<String> ingredients = new ArrayList<String>();
        while (scanner.hasNextLine()) {
            String i = scanner.nextLine();
            if (i.startsWith(" ")) {
                break;
            }
            ingredients.add(i);
        }
        return ingredients;
    }

    public void recipeToUpdate(Recipe recipe) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter recipe Details to Update:");

            System.out.print("Recipe Title(Press enter if you do not want to change the title): ");
            String title = scanner.nextLine();
            if (!title.trim().equals("")) {
                recipe.setTitle(title);
            }
            System.out.println("Ingredients List(Press enter if you do not want to change the project): ");
            ArrayList<String> ingredients = addIngredients(scanner);
            if (ingredients.size() != 0) {
                recipe.setIngredients(ingredients);
            }
            System.out.print("Steps List(Press enter if you do not want to change the project): ");
            ArrayList<String> steps = addSteps(scanner);
            if (steps.size() != 0) {
                recipe.setSteps(steps);
            }

            System.out.println("Recipe updated successfully ");

        } catch (Exception e) {
            System.out.println("Recipe not Updated:" + e.getMessage());
        }
    }
}
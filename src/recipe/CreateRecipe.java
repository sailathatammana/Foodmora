package recipe;

import java.util.ArrayList;
import java.util.Scanner;

public class CreateRecipe {
    ArrayList<Recipe> recipe;

    public CreateRecipe(ArrayList<Recipe> recipe) {
        this.recipe = recipe;
    }

    public ArrayList<Recipe> addTask() {
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
}

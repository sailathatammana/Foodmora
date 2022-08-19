package recipe;

import java.util.ArrayList;
import java.util.Objects;
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
            System.out.println("Enter the ingredients and enter stop if you are done: ");
            ArrayList<String> ingredients = addData(scanner);
            System.out.println("Enter the steps and enter stop if you are done: ");
            ArrayList<String> steps = addData(scanner);
            this.recipe.add(new Recipe(title, ingredients, steps));
            System.out.println("Recipe added to the list successfully");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return recipe;
    }

    private ArrayList<String> addData(Scanner scanner) {
        ArrayList<String> data = new ArrayList<String>();
        while (scanner.hasNextLine()) {
            String i = scanner.nextLine();
            if (Objects.equals(i, "stop")) {
                break;
            }
            data.add(i);
        }
        return data;
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
            System.out.println("Ingredients List(Enter stop if you are done): ");
            ArrayList<String> ingredients = addData(scanner);
            if (ingredients.size() != 0) {
                recipe.setIngredients(ingredients);
            }
            System.out.print("Steps List(Enter stop if you are done): ");
            ArrayList<String> steps = addData(scanner);
            if (steps.size() != 0) {
                recipe.setSteps(steps);
            }
            System.out.println("Recipe updated successfully ");
        } catch (Exception e) {
            System.out.println("Recipe not Updated:" + e.getMessage());
        }
    }
}
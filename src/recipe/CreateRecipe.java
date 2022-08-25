package recipe;

import utils.Display;

import java.util.*;

public class CreateRecipe {
    private ArrayList<Recipe> recipe;

    public CreateRecipe(ArrayList<Recipe> recipe) {
        this.recipe = recipe;
    }

    public ArrayList<Recipe> addRecipe() {
        try {
            Display.clearScreen();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the tittle of the recipe: ");
            String title = scanner.nextLine();
            List<List<String>> ingredients = addIngredients(scanner);
            System.out.println("Enter the steps and enter stop if you are done: ");
            ArrayList<String> steps = addSteps(scanner);
            this.recipe.add(new Recipe(title, ingredients, steps));
            System.out.println("Recipe added to the list successfully");
            Display.returnMainMenu();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return recipe;
    }

    private List<List<String>> addIngredients(Scanner scanner) {
        List<List<String>> ingredients = new ArrayList<>();
        List<String> itemList = new ArrayList<>();
        while (true) {
            System.out.println("Enter the ingredient name");
            String input = scanner.nextLine();
            itemList.add(input);
            addMeasurement(scanner, itemList);
            System.out.println("Enter the quantity");
            input = scanner.nextLine();
            itemList.add(input);
            ingredients.add(itemList);
            System.out.print("If you are done enter stop or press enter and continue");
            input = scanner.nextLine();
            if (Display.validateInput(input)) break;
            itemList = new ArrayList<>();
        }
        return ingredients;
    }

    private void addMeasurement(Scanner scanner, List<String> item) {
        System.out.println("Enter the type of measurement");
        System.out.println("Please only enter kg or ´l´ for litres or ´pc´ for Quantity");
        while (true) {
            String input = scanner.nextLine();
            String choice = input.toLowerCase();
            if (Objects.equals(choice, "kg") || Objects.equals(choice, "l") || Objects.equals(choice, "pc")) {
                item.add(input);
                break;
            }
            System.out.println("Please choose valid measurement");
        }
    }

    private ArrayList<String> addSteps(Scanner scanner) {
        ArrayList<String> data = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if (Display.validateInput(input)) break;
            data.add(input);
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
            System.out.print("Ingredients(Press enter if you do not want to change or press anything to change): ");
            String input = scanner.nextLine();
            if (!(Objects.equals(input, ""))) {
                List<List<String>> ingredients = addIngredients(scanner);
                if (ingredients.size() != 0) {
                    recipe.setIngredients(ingredients);
                }
            }
            System.out.print("Steps(Press enter if you do not want to change or press anything to change): ");
            input = scanner.nextLine();
            if (!(Objects.equals(input, ""))) {
                ArrayList<String> steps = addSteps(scanner);
                if (steps.size() != 0) {
                    recipe.setSteps(steps);
                }
            }
            System.out.println("Recipe updated successfully ");
            Display.returnMainMenu();
        } catch (Exception e) {
            System.out.println("Recipe not Updated:" + e.getMessage());
        }
    }
}
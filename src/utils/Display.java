package utils;

import recipe.Recipe;

import java.util.ArrayList;

public class Display {
    public static void printInvalidOption() {
        System.out.println("⚠️ Invalid option");
    }

    public static void printChoiceSelection() {
        System.out.print("Selected User: ");
    }

    public static void viewRecipes(ArrayList<Recipe> recipeList) {
        for (int i = 0; i < recipeList.size(); i++) {
            System.out.println(recipeList.get(i).getTitle());
            System.out.println(recipeList.get(i).getIngredients());
            System.out.println(recipeList.get(i).getSteps());
            System.out.println(i);
        }
    }
}

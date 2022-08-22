package utils;


import recipe.Recipe;

import java.util.Objects;
import java.util.Scanner;

public class Display {
    public static void printInvalidOption() {
        System.out.println("⚠️ Invalid option");
    }

    public static void printChoiceSelection() {
        System.out.print("Selected User: ");
    }

    public static void printRecipeDetails(Recipe list) {
        System.out.println("Selected Recipe is : " + list.getTitle() + "\n");
        System.out.println("Ingredients:");
        for (int i = 1; i <= list.getIngredients().size(); i++) {
            System.out.println("[" + i + "]" + " " + list.getIngredients().get(i-1));
        }
        System.out.println("\n" + "Steps:");
        for (int i = 1; i <= list.getSteps().size(); i++) {
            System.out.println("[" + i + "]" + " " + list.getSteps().get(i-1));
        }
        System.out.println();
    }

    public static void exitApplication(){
        System.out.println("Enter `q` to exit: ");
        Scanner scanner = new Scanner(System.in);
        while ((true)) {
            String option = scanner.nextLine();
            if (Objects.equals(option, "q")) {
                System.exit(1);
            }
            else {
                System.out.println("You entered wrong input please press q to exit");
            }
        }
    }

    public static void returnMainMenu(){
        System.out.println("Press `q` to return to main menu");
        Scanner scanner = new Scanner(System.in);
        while ((true)) {
            String option = scanner.nextLine();
            if (Objects.equals(option, "q")) {
                return;
            }
            else {
                System.out.println("You entered wrong input please press q to return to main menu");
            }
        }
    }

    public static void editRecipeMenu() {
        System.out.println("Edit a recipe");
        System.out.println("-----------");
        System.out.println("1. Edit a selected recipe");
        System.out.println("2. Remove a recipe");
    }
}

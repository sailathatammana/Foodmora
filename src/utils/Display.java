package utils;


import recipe.Recipe;

import java.util.Objects;
import java.util.Scanner;

public class Display {

    private static void welcomeMsg() {
        System.out.println("Welcome to Foodmora \n");
    }

    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                Display.welcomeMsg();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
                Display.welcomeMsg();
            }
        } catch (Exception E) {
            System.out.println(E);
        }
    }


    public static void printInvalidOption() {
        System.out.println("⚠️ Invalid option");
    }

    public static void printChoiceSelection() {
        System.out.print("Selected User: ");
    }

    public static boolean checkInput(String input) {
        return Objects.equals(input.toLowerCase(), "q");
    }

    public static void printRecipeDetails(Recipe list) {
        System.out.println("Selected Recipe is : " + list.getTitle() + "\n");
        System.out.println("Ingredients:");
        for (int i = 1; i <= list.getIngredients().size(); i++) {
            System.out.println("[" + i + "]" + " " + list.getIngredients().get(i - 1).get(0) + " " + list.getIngredients().get(i - 1).get(2) + list.getIngredients().get(i - 1).get(1));
        }
        System.out.println("\n" + "Steps:");
        for (int i = 1; i <= list.getSteps().size(); i++) {
            System.out.println("[" + i + "]" + " " + list.getSteps().get(i - 1));
        }
    }

    public static void returnMainMenu() {
        System.out.print("Press `q` to return to main menu: ");
        Scanner scanner = new Scanner(System.in);
        while ((true)) {
            String option = scanner.nextLine();
            if (checkInput(option)) return;
            else {
                System.out.print("You entered wrong input please press q to return to main menu: ");
            }
        }
    }

    public static void editRecipeMenu() {
        System.out.println("\n Edit a recipe");
        System.out.println("-----------");
        System.out.println("1. Edit a selected recipe");
        System.out.println("2. Remove a recipe");
    }

    public static boolean validateInput(String input) {
        return Objects.equals(input.toLowerCase(), "stop");
    }
}

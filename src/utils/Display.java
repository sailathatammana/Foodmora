package utils;


public class Display {
    public static void printInvalidOption() {
        System.out.println("⚠️ Invalid option");
    }

    public static void printChoiceSelection() {
        System.out.print("Selected User: ");
    }

    public static void editRecipeMenu() {
        System.out.println("Edit a recipe");
        System.out.println("-----------");
        System.out.println("1. Edit a selected recipe");
        System.out.println("2. Remove a recipe");
    }
}

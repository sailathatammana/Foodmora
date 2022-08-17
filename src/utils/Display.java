package utils;


public class Display {
    public static void printInvalidOption() {
        System.out.println("⚠️ Invalid option");
    }

    public static void printChoiceSelection() {
        System.out.print("Selected User: ");
    }

    public static void editRecipeMenu() {
        System.out.println("\nEdit a recipe");
        System.out.println("-----------\n");
        System.out.println("1. Edit a selected recipe");
        System.out.println("2. Remove a recipe");
        System.out.print("Enter your choice[1-2]: ");
    }
}

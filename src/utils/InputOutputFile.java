package utils;

import generateWeek.UserWeek;
import recipe.Recipe;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class InputOutputFile {
    ArrayList<Recipe> recipeList = new ArrayList<>();
    ArrayList<UserWeek> userWeekList = new ArrayList<>();

    public ArrayList<Recipe> readRecipes(String fileName) {
        try {
            Files.isReadable(Paths.get(fileName));
            FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream stream = new ObjectInputStream(file);
            recipeList = (ArrayList<Recipe>) stream.readObject();
            stream.close();
            file.close();
        } catch (IOException | ClassNotFoundException ignored) {
        }
        return recipeList;
    }

    public void writeRecipe(String filename, ArrayList<Recipe> recipe) {
        try {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream output = new ObjectOutputStream(file);
            output.writeObject(recipe);
            output.close();
            file.close();
            System.out.println("Recipes saved to the file");

        } catch (IOException e) {
            System.out.println("File doesn't found" + e);
        }
    }

    public ArrayList<UserWeek> readWeeks(String fileName) {
        try {
            Files.isReadable(Paths.get(fileName));
            FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream stream = new ObjectInputStream(file);
            userWeekList = (ArrayList<UserWeek>) stream.readObject();
            stream.close();
            file.close();
        } catch (IOException | ClassNotFoundException ignored) {
        }
        return userWeekList;
    }

    public void writeWeek(String filename, ArrayList<UserWeek> userWeek) {
        try {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream output = new ObjectOutputStream(file);
            output.writeObject(userWeek);
            output.close();
            file.close();
            System.out.println("Weeks saved to the file");

        } catch (IOException e) {
            System.out.println("File doesn't found" + e);
        }
    }
}

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

    public ArrayList<Recipe> readRecipesFromFile(String fileName) {
        try {
            if (!Files.isReadable(Paths.get(fileName))) {
                System.out.println(" The data file does not exist, Creating a new data file ");
            }
            FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream stream = new ObjectInputStream(file);
            // read recepies from the stream
            recipeList = (ArrayList<Recipe>) stream.readObject();
            stream.close();
            file.close();
        } catch (IOException e) {
            System.out.println("File doesn't found " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("problems inside the file " + e);
        }
        return recipeList;
    }

    public void writeRecipeObj(String filename, ArrayList<Recipe> recipe) {
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

    public ArrayList<UserWeek> readWeeksFromFile(String fileName) {
        try {
            if (!Files.isReadable(Paths.get(fileName))) {
                System.out.println(" The data file does not exist, Creating a new data file ");
            }
            FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream stream = new ObjectInputStream(file);
            // read recepies from the stream
            userWeekList = (ArrayList<UserWeek>) stream.readObject();
            stream.close();
            file.close();
        } catch (IOException e) {
            System.out.println("File doesn't found " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("problems inside the file " + e);
        }
        return userWeekList;
    }

    public void writeWeekObj(String filename, ArrayList<UserWeek> userWeek) {
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

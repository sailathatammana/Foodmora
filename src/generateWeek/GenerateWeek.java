package generateWeek;

import recipe.Recipe;
import utils.Display;

import java.security.InvalidParameterException;
import java.time.DateTimeException;
import java.util.*;

public class GenerateWeek {
    private ArrayList<UserWeek> userWeek;
    private ArrayList<Recipe> recipe;

    public GenerateWeek(ArrayList<UserWeek> userWeek, ArrayList<Recipe> recipe) {
        this.recipe = recipe;
        this.userWeek = userWeek;
    }

    public ArrayList<UserWeek> addWeek() {
        Calendar startDate = Calendar.getInstance(Locale.GERMANY);
        int currentWeek = (startDate.get(Calendar.WEEK_OF_YEAR));
        int weeksOfYear = Calendar.getInstance().getActualMaximum(Calendar.WEEK_OF_YEAR);
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the week no: ");
            String week = scanner.nextLine();
            int weekNo = Integer.parseInt(week);
            validateWeek(currentWeek, weeksOfYear, weekNo);
            generateRandomRecipes(weekNo);
        } catch (InvalidParameterException e) {
            Display.returnMainMenu();
        } catch (Exception e) {
            Display.printInvalidOption();
            addWeek();
        }
        return userWeek;
    }

    private void validateWeek(int currentWeek, int weeksOfYear, int weekNo) {
        try {
            for (UserWeek weekId : userWeek) {
                if (weekId.getWeekNo() == weekNo) {
                    throw new IllegalArgumentException("You have generated a diet plan for the week: " + weekNo);
                }
            }
            if (weekNo < currentWeek || weekNo > weeksOfYear) {
                System.out.println("Please enter a valid week between " + currentWeek + "(this week) and " + weeksOfYear);
                throw new DateTimeException("You entered a week is not valid");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw new InvalidParameterException();
        }
    }

    private void generateRandomRecipes(int weekNo) {
        try {
            if (recipe.size() < 7) {
                throw new IllegalArgumentException("There are no sufficient recipes to generate a week");
            } else {
                ArrayList<Recipe> randomRecipes = randomRecipes(recipe);
                this.userWeek.add(new UserWeek(weekNo, randomRecipes));
                System.out.println("Week added to the list successfully");
                Display.returnMainMenu();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            Display.returnMainMenu();
        }
    }

    private ArrayList<Recipe> randomRecipes(ArrayList<Recipe> localRecipe) {
        ArrayList<Recipe> shuffleRecipes = new ArrayList<>();
        Recipe[] clonedRecipes = localRecipe.toArray(new Recipe[0]);
        List<Recipe> list = Arrays.asList(clonedRecipes);
        Collections.shuffle(list);
        for (int i = 0; i < 7; ++i) {
            shuffleRecipes.add(list.get(i));
        }
        return shuffleRecipes;
    }
}
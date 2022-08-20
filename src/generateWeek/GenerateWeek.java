package generateWeek;

import recipe.Recipe;
import utils.Display;

import java.time.DateTimeException;
import java.util.*;

public class GenerateWeek {
    ArrayList<UserWeek> userWeek;
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
            for(UserWeek weekId : userWeek){
                if(weekId.getWeekNo()== weekNo){
                    throw new IllegalArgumentException("You have generated a diet plan for the week: " + weekNo);
                }
            }
            if(weekNo <currentWeek || weekNo >weeksOfYear ){
                System.out.println("Please enter a valid week between " + currentWeek + "(this week) and " + weeksOfYear);
                throw new DateTimeException("You entered a week is not valid");
            }
            ArrayList<Recipe> randomRecipes = randomRecipes(recipe);
            this.userWeek.add(new UserWeek(weekNo, randomRecipes));
            System.out.println("Week added to the list successfully");
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            addWeek();
        }
        catch (Exception e) {
            Display.printInvalidOption();
            addWeek();
        }
        return userWeek;
    }

    private ArrayList<Recipe> randomRecipes(ArrayList<Recipe> localRecipe){
        ArrayList<Recipe> clonedRecipes = new ArrayList<>();
        ArrayList<Recipe> shuffleRecipes = new ArrayList<Recipe>();
        clonedRecipes =   localRecipe;
        Collections.shuffle(clonedRecipes,new Random());
        for (int i = 0; i < 7; ++ i) {
            shuffleRecipes.add(clonedRecipes.get(i));
        }
        return shuffleRecipes;
    }
}

package generateWeek;

import recipe.Recipe;
import utils.Display;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WeekList {
    private ArrayList<UserWeek> userWeeks;
    Scanner scanner;
    private final List<String> weekDay = List.of("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
    UserWeek userWeek1 = null;

    public WeekList(ArrayList<UserWeek> userWeek) {
        this.userWeeks = userWeek;
        scanner = new Scanner(System.in);
    }

    public void viewWeek(int choice) {
        try {
            int userWeekIndex = checkWeekNo(choice, userWeeks);
            userWeek1 = userWeeks.get(userWeekIndex);
            System.out.println("Selected Week is  :" + choice);
            for (int i = 0; i < 7; ++i) {
                System.out.println("[" + (i + 1) + "] " + weekDay.get(i) + " " + userWeek1.getRecipes().get(i).getTitle());
            }
            requestDay();
        } catch (ArrayIndexOutOfBoundsException e) {
            Display.printInvalidOption();
            request();
        }
    }

    public void request() {
        System.out.print("Enter a week number: ");
        String input = scanner.nextLine();
        try {
            int selectedOption = Integer.parseInt(input);
            viewWeek(selectedOption);
        } catch (NumberFormatException e) {
            Display.printInvalidOption();
            request();
        }
    }

    public int checkWeekNo(int choice, ArrayList<UserWeek> userWeeks) {
        int index = -100;
        try {
            boolean isExists = false;
            for (UserWeek uw : userWeeks) {
                if (choice == uw.getWeekNo()) {
                    isExists = true;
                    index = userWeeks.indexOf(uw);
                }
            }
            if (!isExists) {
                Display.printInvalidOption();
                throw new IndexOutOfBoundsException("Invalid Option");
            }
        } catch (IndexOutOfBoundsException e) {
            request();
        }
        return index;
    }

    public void requestDay() {
        System.out.print("Select a day to see recipe details: ");
        String input = scanner.nextLine();
        int selectedOption = -100;
        try {
            selectedOption = Integer.parseInt(input) -1;
            if (selectedOption < 0 || selectedOption >= 7) {
                throw new ArrayIndexOutOfBoundsException("Recipe selected is not in the List:returning to main menu");
            }
            Recipe recipe = userWeek1.getRecipes().get(selectedOption);
            System.out.println("Selected Recipe is: " + recipe.getTitle());
            System.exit(1);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            Display.printInvalidOption();
            requestDay();
        }
    }
}


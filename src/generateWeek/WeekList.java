package generateWeek;

import recipe.Recipe;
import utils.Display;

import java.security.InvalidParameterException;
import java.util.*;

public class WeekList {
    private ArrayList<UserWeek> userWeeks;
    Scanner scanner;
    private final List<String> weekDay = List.of("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
    UserWeek userWeek1 = null;
    int userWeekIndex = -100;

    public WeekList(ArrayList<UserWeek> userWeek) {
        this.userWeeks = userWeek;
        scanner = new Scanner(System.in);
    }

    public void viewWeek(int choice) {
        try {
            checkWeekNo(choice, userWeeks);
            Display.clearScreen();
            userWeek1 = userWeeks.get(userWeekIndex);
            System.out.println("Selected Week is  :" + choice);
            for (int i = 0; i < 7; ++i) {
                System.out.println("[" + (i + 1) + "] " + weekDay.get(i) + " " + userWeek1.getRecipes().get(i).getTitle());
            }
            requestDay();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new InvalidParameterException("Invalid week entered");
        }
    }

    public void request() {
        System.out.println("Enter `c` to select current week: ");
        System.out.println("Enter `q` to go back to main menu: ");
        System.out.println("Enter a week number: ");
        String input = scanner.nextLine();
        try {
            if (Objects.equals(input, "c")) {
                Calendar startDate = Calendar.getInstance(Locale.GERMANY);
                int currentWeek = (startDate.get(Calendar.WEEK_OF_YEAR));
                viewWeek(currentWeek);
            } else if (Objects.equals(input, "q")) {
                return;
            } else {
                int selectedOption = Integer.parseInt(input);
                viewWeek(selectedOption);
            }
        } catch (NumberFormatException e) {
            Display.printInvalidOption();
            request();
        } catch (InvalidParameterException p) {
            request();
        }
    }

    public void checkWeekNo(int choice, ArrayList<UserWeek> userWeeks) {
        try {
            boolean isExists = false;
            for (UserWeek uw : userWeeks) {
                if (choice == uw.getWeekNo()) {
                    isExists = true;
                    userWeekIndex = userWeeks.indexOf(uw);
                }
            }
            if (!isExists) {
                System.out.println("Week " + choice + " does not exist.");
                throw new IndexOutOfBoundsException("Invalid Option");
            }
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidParameterException("Problem");
        }
    }

    public void requestDay() {
        System.out.println("Enter `q` to go back to main menu: ");
        System.out.println("Select a day to see recipe details: ");
        String input = scanner.nextLine();
        int selectedOption = -100;
        try {
            if (Objects.equals(input, "q")) {
                return;
            }
            selectedOption = Integer.parseInt(input) - 1;
            if (selectedOption < 0 || selectedOption >= 7) {
                throw new ArrayIndexOutOfBoundsException("Recipe selected is not in the List:returning to main menu");
            }
            Recipe recipe = userWeek1.getRecipes().get(selectedOption);
            Display.clearScreen();
            Display.printRecipeDetails(recipe);
            Display.exitApplication();
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            Display.printInvalidOption();
            requestDay();
        }
    }
}
package person;

import java.util.List;

public class Dietician extends Person {
    public final List<String> menuOptions = List.of("List recipes", "View recipe", "Create a new recipe", "Update a new recipe", "Save & quit");

    public List<String> getMenuOptions() {
        return menuOptions;
    }


    public void handleOption(int selectedOption) {
        switch (selectedOption) {
            case 1 -> System.out.println("List recipes");
            case 2 -> System.out.println("View recipe");
            case 3 -> System.out.println("Create a new recipe");
            case 4 -> System.out.println("Update a new recipe");
            case 5 -> {
                System.out.println("Good Bye");
                System.exit(1);
            }
            default -> throw new IndexOutOfBoundsException();
        }
    }
}
